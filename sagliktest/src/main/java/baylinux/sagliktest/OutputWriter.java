package baylinux.sagliktest;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OutputWriter 
{
	protected static void writeToXlsx(String exportPath,List<ParticipantAnswer> participantAnswers) throws IOException
	{
		FileOutputStream fos=new FileOutputStream(exportPath);
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Deneme");
        
        int rowCount=0;
        int columnCount=0;
        
        XSSFRow headerRow=sheet.createRow(rowCount);
        ++rowCount;
        
        XSSFCell cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("İsim Soyisim");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("1");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("2");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("3");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("4");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("5");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("6");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("7");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("8");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("9");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("10");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("11");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("12");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("13");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("14");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("15");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("16");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("17");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("18");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("19");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("20");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("21");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("22");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("23");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("24");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("25");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("26");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("27");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("28");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("29");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("30");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("Doğru Sayısı");
        
        cell=headerRow.createCell(columnCount);
        ++columnCount;
        cell.setCellValue("Puan");
        
        int i=0;
        while(i<participantAnswers.size())
        {
        	XSSFRow row=sheet.createRow(rowCount);
            ++rowCount;
            columnCount=0;
            
            XSSFCell c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getName_surname());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_1());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_2());
            ++columnCount;
            
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_3());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_4());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_5());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_6());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_7());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_8());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_9());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_10());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_11());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_12());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_13());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_14());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_15());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_16());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_17());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_18());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_19());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_20());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_21());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_22());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_23());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_24());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_25());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_26());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_27());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_28());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_29());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getAnswer_correctness_30());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getNumber_of_correct_answers());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswers.get(i).getTotal_point());
            ++columnCount;
            
            
            
        	++i;
        }
        
        int totalDForColumn1=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_1();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn1;
        	++i;
        }
        
        int totalDForColumn2=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_2();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn2;
        	++i;
        }
        
        
        int totalDForColumn3=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_3();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn3;
        	++i;
        }
        
        int totalDForColumn4=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_4();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn4;
        	++i;
        }
        
        int totalDForColumn5=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_5();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn5;
        	++i;
        }
        
        int totalDForColumn6=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_6();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn6;
        	++i;
        }
        
        int totalDForColumn7=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_7();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn7;
        	++i;
        }
        
        int totalDForColumn8=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_8();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn8;
        	++i;
        }
        
        int totalDForColumn9=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_9();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn9;
        	++i;
        }
        
        int totalDForColumn10=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_10();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn10;
        	++i;
        }
        
        int totalDForColumn11=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_11();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn11;
        	++i;
        }
        
        int totalDForColumn12=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_12();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn12;
        	++i;
        }
        
        int totalDForColumn13=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_13();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn13;
        	++i;
        }
        
        int totalDForColumn14=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_14();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn14;
        	++i;
        }
        
        int totalDForColumn15=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_15();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn15;
        	++i;
        }
        
        int totalDForColumn16=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_16();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn16;
        	++i;
        }
        
        int totalDForColumn17=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_17();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn17;
        	++i;
        }
        
        int totalDForColumn18=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_18();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn18;
        	++i;
        }
        
        int totalDForColumn19=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_19();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn19;
        	++i;
        }
        
        int totalDForColumn20=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_20();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn20;
        	++i;
        }
        
        int totalDForColumn21=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_21();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn21;
        	++i;
        }
        
        int totalDForColumn22=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_22();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn22;
        	++i;
        }
        
        int totalDForColumn23=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_23();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn23;
        	++i;
        }
        
        int totalDForColumn24=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_24();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn24;
        	++i;
        }
        
        int totalDForColumn25=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_25();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn25;
        	++i;
        }
        
        int totalDForColumn26=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_26();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn26;
        	++i;
        }
        
        int totalDForColumn27=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_27();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn27;
        	++i;
        }
        
        int totalDForColumn28=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_28();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn28;
        	++i;
        }
        
        int totalDForColumn29=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_29();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn29;
        	++i;
        }
        
        int totalDForColumn30=0;
        i=0;
        while(i<participantAnswers.size())
        {
        	String s=participantAnswers.get(i).getAnswer_correctness_30();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn30;
        	++i;
        }
        
        int avgD=(
        			totalDForColumn1
        			+totalDForColumn2
        			+totalDForColumn3
        			+totalDForColumn4
        			+totalDForColumn5
        			+totalDForColumn6
        			+totalDForColumn7
        			+totalDForColumn8
        			+totalDForColumn9
        			+totalDForColumn10
        			+totalDForColumn11
        			+totalDForColumn12
        			+totalDForColumn13
        			+totalDForColumn14
        			+totalDForColumn15
        			+totalDForColumn16
        			+totalDForColumn17
        			+totalDForColumn18
        			+totalDForColumn19
        			+totalDForColumn20
        			+totalDForColumn21
        			+totalDForColumn22
        			+totalDForColumn23
        			+totalDForColumn24
        			+totalDForColumn25
        			+totalDForColumn26
        			+totalDForColumn27
        			+totalDForColumn28
        			+totalDForColumn29
        			+totalDForColumn30
        			)/participantAnswers.size();
        int avgPoint=avgD*100/30;
        
        XSSFRow row=sheet.createRow(rowCount);
        ++rowCount;
        columnCount=1;
        
        XSSFCell c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn1);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn2);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn3);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn4);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn5);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn6);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn7);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn8);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn9);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn10);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn11);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn12);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn13);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn14);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn15);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn16);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn17);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn18);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn19);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn20);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn21);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn22);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn23);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn24);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn25);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn26);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn27);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn28);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn29);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(totalDForColumn30);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(avgD);
        ++columnCount;
        
        c=row.createCell(columnCount);
        c.setCellValue(avgPoint);
        ++columnCount;
        
        
        
        workbook.write(fos);
        workbook.close();
        
        
        
	}
	
	
}
