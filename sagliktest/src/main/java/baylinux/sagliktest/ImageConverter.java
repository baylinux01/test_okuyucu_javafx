package baylinux.sagliktest;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ImageConverter {
	
//	static {
//		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//	}
	
	public static String convertTitlesOfMultipleChoiceExamToDigitalFormatFromImage
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
	             try {
	                 highText = tesseract.doOCR(highBufferedImage).trim();
	                 
	             }
	             catch(Exception ex)
	             {
	            	 highText="";
	             }
	             
	         }
    		 System.out.println(highText);
    		 return highText;
//	                 if(highText!=null)
//	                 {
//	                	 
//		                 String[] dizi0=highText.split("\t");
//		                 String[] dizi1=dizi0[0].split("\n");
//		                 
//		                 for(int y=0;y<dizi1.length;y++)
//		                 {
//		                	
//		                		 try 
//		                		 {
//		                			 list1.add(dizi1[y].toUpperCase().trim());
//		                		 }
//		                		 catch(IndexOutOfBoundsException ex)
//		                		 {
//		                			System.out
//		                			.println
//		                			("istenilen colon sayısı"
//		                					+ " tesseract'ın tesbit ettiği aralığın dışında kalıyor"
//		                					+ " negatif değer girmeyin"
//		                					+ " ve istenilen son kolon değeri"
//		                					+ " fazla geliyorsa küçültün");
//		                		 }
//		                	 
//		                	 
//		                 }
//		                
//	                 }
//	             } 
//	             catch (TesseractException e) 
//	             {
//	                 System.out.println(e.getMessage());
//	                 
//	             }
//	         } 
//	         else 
//	         {
//	            list1.add("başlık tesbit edilemedi");
//	            
//	         }
//    		 long endTime=System.currentTimeMillis()-startTime;
//    		 System.out.println("time for extract title: "+endTime);
//    		return list1;
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
//       Imgcodecs.imwrite(imageFullPath+"ucuncuCikti.png",binary);
       
    
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

       int horizontalErodeKernelHeightForTable=ps.getErosion_degree();
       int horizontalErodeKernelWidthForTable=
    		   image.cols()/ps.getHorizontal_kernel_length_division_factor();
       int horizontalDilateKernelHeightForTable=ps.getDilation_degree();
       int horizontalDilateKernelWidthForTable=ps.getDilation_degree();
       Mat horizontalLines = new Mat();
       Mat dilatedHorizontalLines=new Mat();
    		Mat horizontalErodeKernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, 
    		  new Size(horizontalErodeKernelWidthForTable,horizontalErodeKernelHeightForTable));  
    		
    		Mat horizontalDilateKernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, 
    				new Size(horizontalDilateKernelWidthForTable,
    						horizontalDilateKernelHeightForTable)); 
    		 
    		Imgproc.erode(croppedBinary, horizontalLines, horizontalErodeKernel,
    				new Point(-1,-1), ps.getHorizontal_erosion_iteration_number());  
    		
    		Imgproc.dilate(horizontalLines, dilatedHorizontalLines, horizontalDilateKernel,
    				new Point(-1,-1),ps.getHorizontal_dilation_iteration_number());
    				
    		

//    		Imgcodecs.imwrite(imagePath+"dorduncuCikti_horizontalLines.png", dilatedHorizontalLines); 
    		
    		Mat verticalLines = new Mat(); 
    		Mat dilatedVerticalLines=new Mat();
    		int verticalErodeKernelWidthForTable=ps.getErosion_degree();
    		int verticalErodeKernelHeightForTable=image.rows()/ps.getVertical_kernel_length_division_factor();
    		int verticalDilateKernelWidthForTable=ps.getDilation_degree();
    		int verticalDilateKernelHeightForTable=ps.getDilation_degree();
    		Mat verticalErodeKernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, 
    				new Size(verticalErodeKernelWidthForTable, 
    						verticalErodeKernelHeightForTable));  
    		
    		Imgproc.erode(croppedBinary, verticalLines, verticalErodeKernel,
    				new Point(-1,-1), ps.getVertical_erosion_iteration_number()); 
    		
    		Mat verticalDilateKernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, 
    				new Size(verticalDilateKernelWidthForTable, 
    						verticalDilateKernelHeightForTable));
    		
    		Imgproc.dilate(verticalLines, dilatedVerticalLines, verticalDilateKernel,
    				new Point(-1,-1), ps.getVertical_dilation_iteration_number());  
//    		Imgcodecs.imwrite(imagePath+"besinciCikti_verticalLines.png", 
//    				dilatedVerticalLines); 

    		
    		
    		Mat tableLines = new Mat(); 
    		Core.bitwise_or(dilatedHorizontalLines, dilatedVerticalLines, tableLines); 
    		
//    		Imgcodecs.imwrite(imagePath+"altinciCikti_tableLinesCombined.png", 
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
    		
//    		Imgcodecs.imwrite(imageFullPath + "text_only_without_lines.png", textOnlyImage);
    		
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
    		Core.bitwise_and(horizontalLines, verticalLines, intersections); 
//    		Imgcodecs.imwrite(imageFullPath+"yedinciCikti_intersections.png", intersections); 

    		List<MatOfPoint> intersectionContours = new ArrayList<>(); 
    		Imgproc.findContours(intersections, intersectionContours, new Mat(), 
    				Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_NONE); 
    		
    		Set<Point> intersectionPointsSet = new LinkedHashSet<Point>();

    		intersectionContours.stream()
     	    .forEach(c-> 
     	    		{
     	    			intersectionPointsSet
     	    			.add(new Point(Imgproc.boundingRect(c).x ,Imgproc.boundingRect(c).y)); 
     	    			intersectionPointsSet
     	    			.add(new Point
     	    					(Imgproc.boundingRect(c).x+Imgproc.boundingRect(c).width,
     	    							Imgproc.boundingRect(c).y));
     	    			intersectionPointsSet
     	    			.add(new Point
     	    					(Imgproc.boundingRect(c).x,
     	    							Imgproc.boundingRect(c).y+Imgproc.boundingRect(c).height));
     	    			intersectionPointsSet
     	    			.add(new Point(Imgproc.boundingRect(c).x+Imgproc.boundingRect(c).width,
     	    					Imgproc.boundingRect(c).y+Imgproc.boundingRect(c).height));
     	    		});
    		List<Double> rawYCoords = new ArrayList<>();
    		List<Double> rawXCoords = new ArrayList<>();
    		
    		
    		intersectionPointsSet.stream().forEach(p->{rawYCoords.add(p.y);rawXCoords.add(p.x);});
    		
    		
    		List<Double> xCoords = removeCloseCoordinates(rawXCoords, 
    				ps.getColumn_number(),textOnlyImage.cols());
    		List<Double> yCoords = removeCloseCoordinates(rawYCoords, 
    				ps.getRow_number(),textOnlyImage.rows());
    		
    		
    		
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
    		        
    		        
    		        if (cellWidth > 0 && cellHeight > 0 &&
    		            cellX + cellWidth <= binary.cols() 
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
							
							Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, 
									new Size(3, 3));
							Mat small = new Mat();
							Imgproc.resize(cellImageMat, small, 
									new Size(cellImageMat.cols() * (ps.getCell_mat_downscale_factor()/100.0),
											cellImageMat.rows() * (ps.getCell_mat_downscale_factor()/100.0))); 
							Imgproc.erode(small, small, kernel);  
							Imgproc.resize(small, cellImageMat, cellImageMat.size());
							
//				    		Imgcodecs.imwrite(imageFullPath
//				    				.substring(0,imageFullPath.lastIndexOf("/")-1)
//				    				+sayi+".png", cellImageMat); 
//				    		++sayi;
							
						} 
						catch (Exception e) 
						{
							
							e.printStackTrace();
						} 
    		         
    		            
    		            int cellMatWidth=cellImageMat.width();
    		            int cellMatHeight=cellImageMat.height();
    		            int cellMatWidthCropDegree=cellMatWidth/ps.getCell_mat_width_crop_degree_factor();
    		            int cellMatHeightCropDegree=cellMatHeight/ps.getCell_mat_width_crop_degree_factor();
    		            
    		            Rect roi = new Rect(cellMatWidthCropDegree, cellMatHeightCropDegree, 
    		            		Math.abs(cellMatWidth - 2 * cellMatWidthCropDegree), 
    		            		Math.abs(cellMatHeight - 2 * cellMatHeightCropDegree));

    		            Mat croppedCellImageMat = new Mat(cellImageMat, roi);
    		            int whitePixelCount=Core.countNonZero(croppedCellImageMat);
    		            int totalPixelCount=croppedCellImageMat.rows()*croppedCellImageMat.cols();
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


//    		if(ps.getDont_read_first_column()==1)
//    		{
//    			for(int k=0;k<output.size();k++)
//    			{
//    				if(output.get(k).size()>=1)
//    				{
//    					output.get(k).remove(0);
//    				}
//    				
//    			}
//    		}
//    		if(ps.getDont_read_first_row()==1) output.remove(0);
    		
    		
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

	        List<Double> filteredCoords=new ArrayList<Double>();

//	        double t=coords.get(0);
//	        double y=coords.get(coords.size()-1);
//	        double z=(y-t)/(elementNumber-1);
//	        double i=t-z;
//	        if(i<1) i=1.0;
//	        double j=y+z;
//	        if(j>matLengthInThatAxis) j=matLengthInThatAxis;
	        filteredCoords.add(0.0);
	        filteredCoords.add((double)matLengthInThatAxis);
	        coords.add(0,0.0);
	        coords.add((double)matLengthInThatAxis);
	        Collections.sort(coords);
	        double pay=0;
	        //double step=(j-i)/(elementNumber-1)+pay;
	        double step=matLengthInThatAxis/(elementNumber-1);
	        int a=1;
	        double l=0;
	        while(filteredCoords.size()<elementNumber)
	        {
	        	l=0+a*step;
	        	filteredCoords.add(l);
	        	++a;
	        }
	        Collections.sort(filteredCoords);
	        
	        

	        List<Double> lastFilteredCoords=new ArrayList<Double>();
	        
	        int s=0; int g=0;
	        while(s<filteredCoords.size())
	        {
	        	double minDif=Double.MAX_VALUE;
	        	int minIndex=Integer.MAX_VALUE;
	        	g=0;
	        	while(g<coords.size())
	        	{
	        		double dif=Math.abs(filteredCoords.get(s)-coords.get(g));
	        		if(dif<minDif)
	        		{
	        			minDif=dif;
	        			minIndex=g;
	        		}
	        		g++;
	        	}
	        	if(minIndex<coords.size()&&minIndex>-1)
       		{
	        		lastFilteredCoords.add(coords.get(minIndex));
       		}
	        	
	        	s++;
	        }
	        
	        return lastFilteredCoords.stream()
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
}
