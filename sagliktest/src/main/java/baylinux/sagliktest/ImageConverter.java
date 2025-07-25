package baylinux.sagliktest;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.Word;

public class ImageConverter {
	
//	static {
//		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//	}
	public static byte[] getUserImageBytes(PreferredSettings ps,String imageFullPath)
	{
		
			
	        
			
		  Mat image=null;
	       try 
	       {
	    	   image=Imgcodecs.imread(imageFullPath);
	       }
	       catch(Exception ex)
	       {
	    	   
	       }
	       Mat resizedImage = new Mat();
	       Size newSize = new Size(image.rows(), image.cols()); 
	       Imgproc.resize(image, resizedImage, newSize);
	       
	       MatOfByte mob= new MatOfByte();
	       Imgcodecs.imencode(".jpg", resizedImage, mob);
	       return mob.toArray();
	       
	}
	public static String convertTitlesOfExamToDigitalFormatFromImageToObtainTestType
	(PreferredSettings ps,String imageFullPath)
	{
		long startTime=System.currentTimeMillis();
		Tesseract tesseract=new Tesseract();
        tesseract.setDatapath(ps.getTesseract_data_path());
        tesseract.setLanguage(ps.getTesseract_language());
        tesseract.setPageSegMode(ps.getTesseract_page_seg_mode());
        tesseract.setOcrEngineMode(ps.getTesseract_ocr_engine_mode());
        List<List<String>> output=new ArrayList<List<String>>();
        
        Mat image=null;
       try 
       {
    	   image=Imgcodecs.imread(imageFullPath);
       }
       catch(Exception ex)
       {
    	   
       }
       Mat resizedImage = new Mat();
       Size newSize = new Size(ps.getResized_width_for_title(), ps.getResized_height_for_title()); 
       Imgproc.resize(image, resizedImage, newSize);
       
       Mat gray=new Mat();
       Imgproc.cvtColor(resizedImage, gray, Imgproc.COLOR_BGR2GRAY);
//       Imgcodecs.imwrite(imagePath+"ilkCikti.png",gray);
       
       Imgproc.GaussianBlur(gray, gray, new Size(5, 5), 0);
//       Imgcodecs.imwrite(imagePath+"ikinciCikti.png",gray);
//       Imgproc.medianBlur(gray, gray, 3);
       

       
       Mat binary=new Mat();
       Imgproc.adaptiveThreshold(gray, binary, 255, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, 
    		   Imgproc.THRESH_BINARY_INV, 11, 2);
//       Imgcodecs.imwrite(imagePath+"ucuncuCikti.png",binary);
       
       		int x_start=ps.getX_start();
       		int y_start=ps.getY_start();
       		double widthPercentageToBeCut=ps.getWidth_percentage_to_be_cut();
       		double heightPercentageToBeCut=ps.getHeight_percentage_to_be_cut();
       		if(x_start>binary.width()||x_start<0) x_start=0;
       		if(y_start>binary.height()||y_start<0) y_start=0;
       		if(widthPercentageToBeCut>100
       				||widthPercentageToBeCut<0) widthPercentageToBeCut=100;
       		if(heightPercentageToBeCut>100
       				||heightPercentageToBeCut<0) heightPercentageToBeCut=100;
       		
    		//Burada kırparak tablonun üstündeki isim soyisim yazılı olan alanı elde etmeye çalışıyorum
    		Rect higherRect= new Rect(x_start,y_start,
    				(int)(binary.width()*(widthPercentageToBeCut/100)),
    				(int)(binary.height()*(heightPercentageToBeCut/100)));
    		Mat higherCroppedPart=new Mat(binary,higherRect);
    		
//    		Imgcodecs.imwrite(imageFullPath.substring(0,
//    													imageFullPath.lastIndexOf("/")+1)+
//    													"denemeCikti.png",
//    													higherCroppedPart);
    		
    		List<MatOfPoint> contours = new ArrayList<>();
    		Mat hierarchy = new Mat();
    		Imgproc.findContours(higherCroppedPart, contours, hierarchy, 
    				Imgproc.RETR_LIST, 
    				Imgproc.CHAIN_APPROX_NONE);
    	
    		for (int i = 0; i < contours.size(); i++) 
    		{
    		    double area = Imgproc.contourArea(contours.get(i));
    		   
        		if (area < ps.getMin_area_threshold_for_noise_for_title()) 
                {
                    
                    Imgproc.drawContours(higherCroppedPart, 
                    		Collections.singletonList(contours.get(i)), -1, 
                    		new Scalar(0), ps.getDraw_contours_thickness_for_title());
                }
    		}
    		
    		
//    		Imgcodecs.imwrite(imageFullPath.substring(0,
//			imageFullPath.lastIndexOf("/")+1)+
//			"denemeCikti2.png",
//			higherCroppedPart);
    		
    		Mat higherCroppedImageWithWhiteBGColorAndBlackWritingColor=new Mat();
    		Core.bitwise_not(higherCroppedPart,higherCroppedImageWithWhiteBGColorAndBlackWritingColor);
    		
    		
    		BufferedImage highBufferedImage=ImageConverter
    				.matToBufferedImage(higherCroppedImageWithWhiteBGColorAndBlackWritingColor);
    		
    		String highText="";
    		
    		
    		 if (highBufferedImage != null) 
	         {
    			 
	             try 
	             {
	                 highText = tesseract.doOCR(highBufferedImage).trim();
	                 
	             }
	             catch(Exception ex)
	             {
	            	 highText="";
	             }
	             
	         }
    		 //System.out.println("hightext is: "+highText);
    		 return highText;

	}
	
	public static List<List<String>> convertMultipleChoiceExamAnswersToDigitalFormatFromImage
	(PreferredSettings ps,String imageFullPath)
	{
		
        List<List<String>> output= new ArrayList<List<String>>();
       
		
        Mat image=null; 
        try 
        {
        	image=Imgcodecs.imread(imageFullPath);
        }
        catch(NullPointerException ex)
        {
        	
        }
        System.out.println(image.width()+" "+image.height());
       
        //Imgcodecs.imwrite("/home/baylinux/Desktop/image.png",image);
        Mat resizedImage = new Mat();
        Size newSize = new Size(ps.getResized_width_for_table(), ps.getResized_height_for_table()); 
        Imgproc.resize(image, resizedImage, newSize);
       
       Mat gray=new Mat();
       Imgproc.cvtColor(resizedImage, gray, Imgproc.COLOR_BGR2GRAY);
//       Imgcodecs.imwrite(imagePath+"ilkCikti.png",gray);
       
       Imgproc.GaussianBlur(gray, gray, new Size(5, 5), 0);
//       Imgcodecs.imwrite(imagePath+"ikinciCikti.png",gray);
//       Imgproc.medianBlur(gray, gray, 3);
       

       
       Mat binary=new Mat();
       Imgproc.adaptiveThreshold(gray, binary, 255, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, 
    		   Imgproc.THRESH_BINARY_INV, 11, 2);
       
       //Imgcodecs.imwrite("/home/baylinux/Desktop/binary.png",binary);
       
    
    List<MatOfPoint> paperContoursBinary = new ArrayList<>();
    Mat paperHierarchyBinary = new Mat();
    Imgproc.findContours(binary, paperContoursBinary, paperHierarchyBinary, 
    		Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_NONE);

    
    
   Optional<MatOfPoint> contour = paperContoursBinary.stream()
    	    .filter(c -> Imgproc.contourArea(c) > ps.getMin_area_threshold_for_noise_for_table()) 
    	    .max((contour1, contour2) -> 
    	    Double.compare(Imgproc.contourArea(contour1), 
    	    		Imgproc.contourArea(contour2)));
   
    Rect paperRectBinary = Imgproc.boundingRect(contour.get());
    Mat croppedBinary = new Mat(binary, paperRectBinary);
    //Imgcodecs.imwrite("/home/baylinux/Desktop/croppedBinary.png",croppedBinary);
    
    
//       int horizontalErodeKernelHeightForTable=ps.getErosion_degree();
//       int horizontalErodeKernelWidthForTable=
//    		   image.cols()/ps.getHorizontal_kernel_length_division_factor();
//       int horizontalDilateKernelHeightForTable=ps.getDilation_degree();
//       int horizontalDilateKernelWidthForTable=ps.getDilation_degree();
       Mat horizontalLines = new Mat();
       Mat dilatedHorizontalLines=new Mat();
       Mat verticalLines = new Mat(); 
		Mat dilatedVerticalLines=new Mat();
		
    		Mat horizontalErodeKernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, 
    		  new Size(croppedBinary.cols()/ps.getHorizontal_kernel_length_division_factor(),1));  
    		
    		Imgproc.erode(croppedBinary, horizontalLines, horizontalErodeKernel,
    				new Point(-1,-1), ps.getHorizontal_erosion_iteration_number()); 
    		
//    		Imgcodecs.imwrite("/home/baylinux/Desktop/horizontalLines.png", horizontalLines);
    		
    		Mat horizontalDilateKernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, 
    				new Size(croppedBinary.cols(),1)); 
    		
    		Imgproc.dilate(horizontalLines, dilatedHorizontalLines, horizontalDilateKernel,
    				new Point(-1,-1),ps.getHorizontal_dilation_iteration_number());
    				
//    		Imgcodecs.imwrite("/home/baylinux/Desktop/dilatedHorizontalLines.png", dilatedHorizontalLines); 
    		
    		
//    		int verticalErodeKernelWidthForTable=ps.getErosion_degree();
//    		int verticalErodeKernelHeightForTable=image.rows()/ps.getVertical_kernel_length_division_factor();
//    		int verticalDilateKernelWidthForTable=ps.getDilation_degree();
//    		int verticalDilateKernelHeightForTable=ps.getDilation_degree();
    		
    		Mat verticalErodeKernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, 
    				new Size(1, croppedBinary.rows()/ps.getVertical_kernel_length_division_factor()));  
    		
    		Imgproc.erode(croppedBinary, verticalLines, verticalErodeKernel,
    				new Point(-1,-1), ps.getVertical_erosion_iteration_number()); 
    		
//    		Imgcodecs.imwrite("/home/baylinux/Desktop/verticalLines.png",verticalLines);
    		
    		Mat verticalDilateKernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, 
    				new Size(1,croppedBinary.rows()));
    		
    		Imgproc.dilate(verticalLines, dilatedVerticalLines, verticalDilateKernel,
    				new Point(-1,-1), ps.getVertical_dilation_iteration_number());
    		
    		

//    		Imgcodecs.imwrite("/home/baylinux/Desktop/dilatedVerticalLines.png",dilatedVerticalLines);
    		
    		
    		
    		Mat tableLines = new Mat(); 
    		Core.bitwise_or(dilatedHorizontalLines, dilatedVerticalLines, tableLines); 
    		
//    		Imgcodecs.imwrite("/home/baylinux/Desktop/altinciCikti_tableLines.png", 
//    				tableLines); 
    		
    		
    		Core.bitwise_or(tableLines, croppedBinary, croppedBinary);
    		
            List<MatOfPoint> contoursToCleanInsideTable = new ArrayList<>();
            Mat hierarchyToCleanInsideTable = new Mat();
           
            Imgproc.findContours(croppedBinary, contoursToCleanInsideTable, 
            					hierarchyToCleanInsideTable,
                                 Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_NONE);

            contoursToCleanInsideTable.stream()
            	    .filter(c -> Imgproc.contourArea(c) < ps.getMin_area_threshold_for_noise_for_table())
            	    .forEach(x-> Imgproc.drawContours(croppedBinary, 
            	    		Collections.singletonList(x), -1,new Scalar(0),ps.getDraw_contours_thickness_for_table()));
            	    
    		Mat inverseTableLines = new Mat();
    		Core.bitwise_not(tableLines, inverseTableLines);
    		
    		
//    		Imgcodecs.imwrite(imageFullPath + "inverseTableLines.png", inverseTableLines);
    		
    		Mat textOnlyImage = new Mat();
    		Core.bitwise_and(croppedBinary, inverseTableLines, textOnlyImage);
    		Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, 
					new Size(3, 3));
			Mat small = new Mat();
			Imgproc.resize(textOnlyImage, small, 
					new Size(textOnlyImage.cols() * (ps.getCell_mat_downscale_factor()/100.0),
							textOnlyImage.rows() * (ps.getCell_mat_downscale_factor()/100.0))); 
			Imgproc.erode(small, small, kernel);  
			Imgproc.resize(small, textOnlyImage, textOnlyImage.size());
			
    		//Imgcodecs.imwrite("/home/baylinux/Desktop/text_only_without_lines.png", textOnlyImage);
    		
    		 List<MatOfPoint> contoursToCleanInsideTableForTextOnly = new ArrayList<>();
             Mat hierarchyToCleanInsideTableForTextOnly = new Mat();
            
             Imgproc.findContours(textOnlyImage, contoursToCleanInsideTableForTextOnly, 
             					hierarchyToCleanInsideTableForTextOnly,
                                  Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_NONE);
             
             
             contoursToCleanInsideTableForTextOnly.stream()
             	    .filter(c -> Imgproc.contourArea(c) < ps.getMin_area_threshold_for_noise_for_table())
             	    .forEach(x-> Imgproc.drawContours(croppedBinary, 
             	    		Collections.singletonList(x), -1,new Scalar(0),ps.getDraw_contours_thickness_for_table()));
            
    		Mat intersections = new Mat(); 
    		Core.bitwise_and(dilatedHorizontalLines, dilatedVerticalLines, intersections); 
    		
//    		Imgcodecs.imwrite("/home/baylinux/Desktop/yedinciCikti_intersections.png", intersections);
    		
    		
			
    		
    		List<MatOfPoint> intersectionContours = new ArrayList<>(); 
    		Imgproc.findContours(intersections, intersectionContours, new Mat(), 
    				Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_NONE); 
    		
    		Set<Point> intersectionPointsSet = new LinkedHashSet<Point>();
    		
    	
    		intersectionContours.stream().forEach(c ->       											
    		{											
    		    Rect r = Imgproc.boundingRect(c);		
    		    Point center = new Point(				
    		            r.x + r.width  / 2.0,			
    		            r.y + r.height / 2.0			
    		    );										
    		    intersectionPointsSet.add(center);
    		});
    		
    		
    		
    		
    		List<Double> rawYCoords = new ArrayList<>();
    		List<Double> rawXCoords = new ArrayList<>();
   		
    		
    		intersectionPointsSet.stream().forEach(f->{rawYCoords.add(f.y);rawXCoords.add(f.x);});
    		
    		List<Double> xCoords = removeCloseCoordinates(rawXCoords, 
    				ps.getColumn_number(),textOnlyImage.cols());
    		List<Double> yCoords = removeCloseCoordinates(rawYCoords, 
    				ps.getRow_number(),textOnlyImage.rows());
    		
//    		int t=0;
//    		int l=0;
//    		if(ps.getDont_read_first_row()==1) t=1;
//    		if(ps.getDont_read_first_column()==1) l=1;
//    		double x1=(xCoords.get(xCoords.size()-1)-xCoords.get(l))/ps.getColumn_number()*2;
//    		double y1=(yCoords.get(yCoords.size()-1)-yCoords.get(t))/ps.getRow_number()*2;
//    		double x2=(xCoords.get(xCoords.size()-1)-xCoords.get(l))-x1;
//    		double y2=(yCoords.get(yCoords.size()-1)-yCoords.get(t))-y1;
//    		
//    		Point optimumTopLeft = intersectionPointsSet.stream()
//    		        .filter(p -> p.x < x1 && p.y < y1)          
//    		        .sorted(Comparator.comparingDouble(p -> p.x + p.y))
//    		        .findFirst()
//    		        .orElse(null);
//    		Point optimumTopRight = intersectionPointsSet.stream()
//    		        .filter(p -> p.x > x2 && p.y < y1)              
//    		        .sorted(Comparator.comparingDouble(p -> -p.x + p.y))
//    		        .findFirst()
//    		        .orElse(null);
//    		Point optimumBottomLeft = intersectionPointsSet.stream()
//    		        .filter(p -> p.x < x1 && p.y > y2)              
//    		        .sorted(Comparator.comparingDouble(p -> p.x - p.y))
//    		        .findFirst()
//    		        .orElse(null);   
//    		Point optimumBottomRight = intersectionPointsSet.stream()
//    		        .filter(p -> p.x > x2 && p.y > y2)        
//    		        .sorted(Comparator.comparingDouble(p -> -p.x - p.y))
//    		        .findFirst()
//    		        .orElse(null);
//    		
//    		
//    		List<List<Point>> pointsByRows=new ArrayList<List<Point>>();
//    		int u=0;
//    		int o=0;
//    		if(ps.getDont_read_first_row()==1) u=1;
//    		if(ps.getDont_read_first_column()==1) o=1;
//    		for (int r = u; r < yCoords.size(); r++) 
//    		{ 
//    		    List<Point> row= new ArrayList<Point>();
//    		    for (int c = o; c < xCoords.size(); c++) 
//    		    { 
//    		    	row.add(new Point(c,r));
//    		    }
//    		    pointsByRows.add(row);
//    		}
//    		
//    		boolean calledForRows=false;
//    		
//    		List<List<Point>> rowsSkewedPoints=null;
//    		if(optimumTopLeft!=null&&optimumTopRight!=null)
//    		{
//    			rowsSkewedPoints=applyRowSkew(pointsByRows, optimumTopLeft, optimumTopRight);
//    			calledForRows=true;
//    		}
//    		else if(optimumBottomLeft!=null&&optimumBottomRight!=null)
//    		{
//    			rowsSkewedPoints=applyRowSkew(pointsByRows, optimumBottomLeft, optimumBottomRight);
//    			calledForRows=true;
//    		}
//    			
//    		
//    		
//    		boolean calledForColumns=false;
//    		List<List<Point>> columnsAndRowsSkewedPoints=null;
//    		if(optimumTopLeft!=null&&optimumBottomLeft!=null&&calledForRows==true)
//    		{
//    			List<List<Point>> pointsByColumnsRowsSkewed=new ArrayList<List<Point>>();
//        		for(int i=0;i<rowsSkewedPoints.get(0).size();i++)
//        		{   List<Point> column=new ArrayList<Point>();
//        			for(int j=0;j<rowsSkewedPoints.size();j++)
//        			{
//        				column.add(rowsSkewedPoints.get(j).get(i));
//        			}
//        			pointsByColumnsRowsSkewed.add(column);
//        		}
//    			columnsAndRowsSkewedPoints=applyColSkew(pointsByColumnsRowsSkewed, optimumTopLeft, optimumBottomLeft);
//    			calledForColumns=true;
//    		}
//    		else if(optimumTopRight!=null&&optimumBottomRight!=null&&calledForRows==true)
//    		{
//    			List<List<Point>> pointsByColumnsRowsSkewed=new ArrayList<List<Point>>();
//        		for(int i=0;i<rowsSkewedPoints.get(0).size();i++)
//        		{   List<Point> column=new ArrayList<Point>();
//        			for(int j=0;j<rowsSkewedPoints.size();j++)
//        			{
//        				column.add(rowsSkewedPoints.get(j).get(i));
//        			}
//        			pointsByColumnsRowsSkewed.add(column);
//        		}
//    			columnsAndRowsSkewedPoints=applyColSkew(pointsByColumnsRowsSkewed, optimumTopRight, optimumBottomRight);
//    			calledForColumns=true;
//    		}
//    		
//    		
//    		if(calledForRows==true&&calledForColumns==true)
//    		{
//    			List<Double> skewedRawXCoords=new ArrayList<Double>();
//        		List<Double> skewedRawYCoords=new ArrayList<Double>();
//    			columnsAndRowsSkewedPoints.stream()
//        		.forEach(satir-> satir.stream()
//        				.forEach(p->{if(p.y>=0)skewedRawYCoords.add(p.y);if(p.x>=0)skewedRawXCoords.add(p.x);}));
//        		
//        		List<Double> skewedXCoords = removeCloseCoordinates(skewedRawXCoords, 
//        				ps.getColumn_number(),textOnlyImage.cols());
//        		List<Double> skewedYCoords = removeCloseCoordinates(skewedRawYCoords, 
//        				ps.getRow_number(),textOnlyImage.rows());
//        		xCoords=skewedXCoords;
//        		yCoords=skewedYCoords;
//    		}
    		
    		
    		int a=0;
    		int b=0;
    		if(ps.getDont_read_first_row()==1) a=1;
    		if(ps.getDont_read_first_column()==1) b=1;
    		int sayi=1;
    		
    		for (int r = a; r < yCoords.size() - 1; r++) 
    		{ 
    		    List<String> rowData = new ArrayList<>(); 
    		    double whitePixelRatioForA=0;
    		    double whitePixelRatioForB=0;
    		    double whitePixelRatioForC=0;
    		    double whitePixelRatioForD=0;
    		    double whitePixelRatioForE=0;
    		    
    		    for (int c = b; c < xCoords.size() - 1; c++) 
    		    { 
    		        
    		        int cellX = xCoords.get(c).intValue();
    		        int cellY = yCoords.get(r).intValue();
    		        int cellWidth = xCoords.get(c + 1).intValue() - cellX;
    		        int cellHeight = yCoords.get(r + 1).intValue() - cellY;
    		    
    		        cellX = cellX + ps.getMargin_x_left();
    		        cellY = cellY + ps.getMargin_y_up();
    		        cellWidth = cellWidth - (ps.getMargin_x_left()+ps.getMargin_x_right());
    		        cellHeight = cellHeight - (ps.getMargin_y_up()+ps.getMargin_y_down());
    		        
    		        
    		        if (cellWidth > 0 
    		        	&& cellHeight > 0 
    		        	&&cellX + cellWidth <= binary.cols() 
    		            && cellY + cellHeight <= binary.rows()) 
    		        {

    		            Rect cellRect = new Rect(cellX, cellY, cellWidth, cellHeight);

    		           
    		            Imgproc.rectangle(textOnlyImage, new Point(cellRect.x, cellRect.y),
    		                    new Point(cellRect.x + 
    		                    		cellRect.width, 
    		                    		cellRect.y + 
    		                    		cellRect.height), 
    		                    new Scalar(255), 1); 
    		            
    		            Mat cellImageMat=null;
						try 
						{
							cellImageMat = new Mat(textOnlyImage, cellRect);
							
//				    		Imgcodecs.imwrite("/home/baylinux/Desktop/"
//				    				+sayi+".png", cellImageMat); 
//				    		++sayi;
							
						} 
						catch (Exception e) 
						{
							
							e.printStackTrace();
						} 
    		         
    		          
    		            int whitePixelCount=Core.countNonZero(cellImageMat);
    		            int totalPixelCount=cellImageMat.rows()*cellImageMat.cols();
    		            double whitePixelRatio=(Double.valueOf(whitePixelCount)/totalPixelCount)*100;
    		            if(ps.getDont_read_first_column()==1&&c==1) whitePixelRatioForA=whitePixelRatio;
    		            else if(ps.getDont_read_first_column()==0&&c==0) whitePixelRatioForA=whitePixelRatio;
    		            if(ps.getDont_read_first_column()==1&&c==2) whitePixelRatioForB=whitePixelRatio;
    		            else if(ps.getDont_read_first_column()==0&&c==1) whitePixelRatioForB=whitePixelRatio;
    		            if(ps.getDont_read_first_column()==1&&c==3) whitePixelRatioForC=whitePixelRatio;
    		            else if(ps.getDont_read_first_column()==0&&c==2) whitePixelRatioForC=whitePixelRatio;
    		            if(ps.getDont_read_first_column()==1&&c==4) whitePixelRatioForD=whitePixelRatio;
    		            else if(ps.getDont_read_first_column()==0&&c==3) whitePixelRatioForD=whitePixelRatio;
    		            if(ps.getDont_read_first_column()==1&&c==5) whitePixelRatioForE=whitePixelRatio;
    		            else if(ps.getDont_read_first_column()==0&&c==4) whitePixelRatioForE=whitePixelRatio;
    		            
    		            String cellStatus="-";
    		            if(whitePixelRatio>=(ps.getWhite_ratio_limit_value()/100.0)
    		            		&&whitePixelRatio>=whitePixelRatioForA
    		            		&&whitePixelRatio>=whitePixelRatioForB
    		            		&&whitePixelRatio>=whitePixelRatioForC
    		            		&&whitePixelRatio>=whitePixelRatioForD
    		            		&&whitePixelRatio>=whitePixelRatioForE
    		            		)
    		            		{
    		            			cellStatus="+";
    		            			rowData.add(cellStatus);
    		            			
    		            			//System.out.println("all white ratios: "+whitePixelRatio);
    		    		            if(ps.getDont_read_first_column()==1&&c==2)
    		    		            {
    		    		            	rowData.set(0, "-");
    		    		            	//System.out.println("white ratio: "+whitePixelRatio);
    		    		            }
    		    		            else if(ps.getDont_read_first_column()==0&&c==1)
    		    		            {
    		    		            	rowData.set(0, "-");
    		    		            	//System.out.println("white ratio: "+whitePixelRatio);
    		    		            }
    		    		            if(ps.getDont_read_first_column()==1&&c==3)
    		    		            {
    		    		            	rowData.set(0, "-");
    		    		            	rowData.set(1, "-");
    		    		            	//System.out.println("white ratio: "+whitePixelRatio);
    		    		            }
    		    		            else if(ps.getDont_read_first_column()==0&&c==2)
    		    		            {
    		    		            	rowData.set(0, "-");
    		    		            	rowData.set(1, "-");
    		    		            	//System.out.println("white ratio: "+whitePixelRatio);
    		    		            }
    		    		            if(ps.getDont_read_first_column()==1&&c==4)
    		    		            {
    		    		            	rowData.set(0, "-");
    		    		            	rowData.set(1, "-");
    		    		            	rowData.set(2, "-");
    		    		            	//System.out.println("white ratio: "+whitePixelRatio);
    		    		            }
    		    		            else if(ps.getDont_read_first_column()==0&&c==3)
    		    		            {
    		    		            	rowData.set(0, "-");
    		    		            	rowData.set(1, "-");
    		    		            	rowData.set(2, "-");
    		    		            	//System.out.println("white ratio: "+whitePixelRatio);
    		    		            }
    		    		            if(ps.getDont_read_first_column()==1&&c==5)
    		    		            {
    		    		            	rowData.set(0, "-");
    		    		            	rowData.set(1, "-");
    		    		            	rowData.set(2, "-");
    		    		            	rowData.set(3, "-");
    		    		            	//System.out.println("white ratio: "+whitePixelRatio);
    		    		            }
    		    		            else if(ps.getDont_read_first_column()==0&&c==4)
    		    		            {
    		    		            	rowData.set(0, "-");
    		    		            	rowData.set(1, "-");
    		    		            	rowData.set(2, "-");
    		    		            	rowData.set(3, "-");
    		    		            	//System.out.println("white ratio: "+whitePixelRatio);
    		    		            }
    		            		}
    		            		else
    		            		{
    		            			cellStatus="-";
    		            			rowData.add(cellStatus);
    		            		}
    		            		

    		        }
    		    }
    		    
    		    System.out.println("For "
    		    +imageFullPath.substring(imageFullPath.lastIndexOf("/")+1)
    		    +" "+"question "+r+" A: "+whitePixelRatioForA);
    		    System.out.println("For "
    	    		    +imageFullPath.substring(imageFullPath.lastIndexOf("/")+1)
    	    		    +" "+"question "+r+" B: "+whitePixelRatioForB);
    		    System.out.println("For "
    	    		    +imageFullPath.substring(imageFullPath.lastIndexOf("/")+1)
    	    		    +" "+"question "+r+" C: "+whitePixelRatioForC);
    		    System.out.println("For "
    	    		    +imageFullPath.substring(imageFullPath.lastIndexOf("/")+1)
    	    		    +" "+"question "+r+" D: "+whitePixelRatioForD);
    		    output.add(rowData);
   }

    		
    		
    		return output;
    
	}
	
	
	
	public static List<Double> removeCloseCoordinates(List<Double> coords, 
			 int number,int matLengthInThatAxis) 
	 {
		    int elementNumber=number+1;
		    
	        if (coords == null || coords.isEmpty()) 
	        {
	            return new ArrayList<Double>();
	        }

	       Collections.sort(coords);

	        List<Double> estimatedCoords=new ArrayList<Double>();

	        
	        double step=(coords.get(coords.size()-1)-coords.get(0))/(elementNumber-1);
	        int a=0;
	        double l=0;
	        while(estimatedCoords.size()<elementNumber)
	        {
	        	l=coords.get(0)+a*step;
	        	estimatedCoords.add(l);
	        	++a;
	        }
	        Collections.sort(estimatedCoords);
	        
	        

	        List<Double> filteredCoords=new ArrayList<Double>();
	        
	        int s=0; int g=0;
	        while(filteredCoords.size()<estimatedCoords.size())
	        {
	        	double minDif=Double.MAX_VALUE;
	        	int minIndex=Integer.MAX_VALUE;
	        	g=0;
	        	while(g<coords.size())
	        	{
	        		double dif=Math.abs(estimatedCoords.get(s)-coords.get(g));
	        		if(dif<minDif)
	        		{
	        			minDif=dif;
	        			minIndex=g;
	        		}
	        		g++;
	        	}
	        if(minIndex<coords.size()&&minIndex>-1)
       		{ 		double sayi=coords.get(minIndex);
       				if(!filteredCoords.contains(sayi))
       				{
       					filteredCoords.add(coords.get(minIndex));
       				}
       				else
       				{
       					coords.remove(Double.valueOf(coords.get(minIndex)));
       					s--;
       				}
       		}
	        	
	        	s++;
	        	if(s>=estimatedCoords.size())
	        	{
	        		filteredCoords=estimatedCoords;
	        		break;
	        	}
	     }
	        
	        return filteredCoords.stream()
	        		.collect(Collectors.toSet())
	        		.stream().sorted().collect(Collectors.toList());

	}

	public static BufferedImage matToBufferedImage(Mat mat)
	{
		int type;
		if(mat.channels() == 1)
		{
			type=BufferedImage.TYPE_BYTE_GRAY;
		}
		else if(mat.channels()==3)
		{
			type=BufferedImage.TYPE_3BYTE_BGR;
		}
		else
		{
			return null;
		}
		int bufferSize=mat.channels()*mat.cols()*mat.rows();
		byte[] b=new byte[bufferSize];
		mat.get(0,0,b);
		BufferedImage image=new BufferedImage(mat.cols(),mat.rows(),type);
		final byte[] targetPixels=((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(b, 0, targetPixels, 0, b.length);
		return image;
	}
	
	
	public static List<List<Point>> applyRowSkew
			(
	        List<List<Point>> rows,
	        Point startRef,   
	        Point endRef
	        )        
	{
	   
	    double dx = endRef.x - startRef.x;
	    double dy = -(endRef.y - startRef.y);
	    double egim=dy/dx;
	    
	    return rows.stream()
	            .map(row -> {
	                
	                Point f = row.get(0);

	                return row.stream()
	                        .map(p -> {
	                            
	                            
	                            return new Point(p.x,f.y-Math.abs(p.x-f.x)*egim);
	                        })
	                        .collect(Collectors.toList());
	            })
	            .collect(Collectors.toList());
	}
	
	public static List<List<Point>> applyColSkew
	(
    List<List<Point>> cols,
    Point startRef,   
    Point endRef
    )        
	{

	double dx = endRef.x - startRef.x;
	double dy = -(endRef.y - startRef.y);
	double egim=dy/dx;
	
	return cols.stream()
	        .map(col -> {
	            
	            Point f = col.get(0);
	
	            return col.stream()
	                    .map(p -> {
	                        
	                        
	                        return new Point(f.x+Math.abs(p.y-f.y)*egim,p.y);
	                    })
	                    .collect(Collectors.toList());
	        })
	        .collect(Collectors.toList());
	}
	

	
	
	
	
}
