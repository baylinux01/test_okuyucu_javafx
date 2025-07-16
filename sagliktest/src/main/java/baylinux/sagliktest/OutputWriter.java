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
	protected static void writeToSameXlsxAllONAndSONTESTES(String exportPath,
			List<ParticipantAnswer> participantAnswersON,List<ParticipantAnswer> participantAnswersSON) throws IOException
	{
		FileOutputStream fos=new FileOutputStream(exportPath);
		XSSFWorkbook workbook = new XSSFWorkbook();
		
        XSSFSheet sheet = workbook.createSheet("ON TEST");
        
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
        while(i<participantAnswersON.size())
        {
        	XSSFRow row=sheet.createRow(rowCount);
            ++rowCount;
            columnCount=0;
            
            XSSFCell c=row.createCell(columnCount);
            c.setCellValue(participantAnswersON.get(i).getName_surname());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_1());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_2());
            ++columnCount;
            
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_3());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_4());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_5());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_6());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_7());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_8());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_9());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_10());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_11());
            ++columnCount;
            
            c=row.createCell(columnCount);
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_12());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_13());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_14());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_15());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_16());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_17());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_18());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_19());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_20());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_21());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_22());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_23());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_24());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_25());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_26());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_27());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_28());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_29());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getAnswer_correctness_30());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getNumber_of_correct_answers());
            ++columnCount;                   
                                             
            c=row.createCell(columnCount);   
            c.setCellValue(participantAnswersON.get(i).getTotal_point());
            ++columnCount;
            
            
            
        	++i;
        }
        
        int totalDForColumn1=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_1();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn1;
        	++i;
        }
        
        int totalDForColumn2=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_2();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn2;
        	++i;
        }
        
        
        int totalDForColumn3=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_3();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn3;
        	++i;
        }
        
        int totalDForColumn4=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_4();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn4;
        	++i;
        }
        
        int totalDForColumn5=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_5();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn5;
        	++i;
        }
        
        int totalDForColumn6=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_6();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn6;
        	++i;
        }
        
        int totalDForColumn7=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_7();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn7;
        	++i;
        }
        
        int totalDForColumn8=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_8();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn8;
        	++i;
        }
        
        int totalDForColumn9=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_9();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn9;
        	++i;
        }
        
        int totalDForColumn10=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_10();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn10;
        	++i;
        }
        
        int totalDForColumn11=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_11();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn11;
        	++i;
        }
        
        int totalDForColumn12=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_12();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn12;
        	++i;
        }
        
        int totalDForColumn13=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_13();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn13;
        	++i;
        }
        
        int totalDForColumn14=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_14();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn14;
        	++i;
        }
        
        int totalDForColumn15=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_15();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn15;
        	++i;
        }
        
        int totalDForColumn16=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_16();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn16;
        	++i;
        }
        
        int totalDForColumn17=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_17();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn17;
        	++i;
        }
        
        int totalDForColumn18=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_18();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn18;
        	++i;
        }
        
        int totalDForColumn19=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_19();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn19;
        	++i;
        }
        
        int totalDForColumn20=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_20();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn20;
        	++i;
        }
        
        int totalDForColumn21=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_21();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn21;
        	++i;
        }
        
        int totalDForColumn22=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_22();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn22;
        	++i;
        }
        
        int totalDForColumn23=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_23();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn23;
        	++i;
        }
        
        int totalDForColumn24=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_24();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn24;
        	++i;
        }
        
        int totalDForColumn25=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_25();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn25;
        	++i;
        }
        
        int totalDForColumn26=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_26();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn26;
        	++i;
        }
        
        int totalDForColumn27=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_27();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn27;
        	++i;
        }
        
        int totalDForColumn28=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_28();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn28;
        	++i;
        }
        
        int totalDForColumn29=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_29();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn29;
        	++i;
        }
        
        int totalDForColumn30=0;
        i=0;
        while(i<participantAnswersON.size())
        {
        	String s=participantAnswersON.get(i).getAnswer_correctness_30();
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
        			)/participantAnswersON.size();
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
        
        
        XSSFSheet sheetSON = workbook.createSheet("SON TEST");
        
        int rowCountSON=0;
        int columnCountSON=0;
        
        XSSFRow headerRowSON=sheetSON.createRow(rowCountSON);
        ++rowCountSON;
        
        XSSFCell cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("İsim Soyisim");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("1");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("2");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("3");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("4");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("5");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("6");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("7");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("8");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("9");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("10");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("11");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("12");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("13");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("14");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("15");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("16");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("17");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("18");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("19");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("20");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("21");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("22");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("23");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("24");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("25");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("26");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("27");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("28");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("29");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("30");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("Doğru Sayısı");
        
        cellSON=headerRowSON.createCell(columnCountSON);
        ++columnCountSON;
        cellSON.setCellValue("Puan");
        
        i=0;
        while(i<participantAnswersSON.size())
        {
        	XSSFRow rowSON=sheetSON.createRow(rowCountSON);
            ++rowCountSON;
            columnCountSON=0;
            
            XSSFCell cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getName_surname());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_1());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_2());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_3());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_4());
            ++columnCountSON;
                                             
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_5());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_6());
            ++columnCountSON;
                                             
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_7());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_8());
            ++columnCountSON;
                                             
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_9());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_10());
            ++columnCountSON;
                                             
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_11());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_12());
            ++columnCountSON;
                                             
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_13());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_14());
            ++columnCountSON;
                                             
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_15());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_16());
            ++columnCountSON;
                                             
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_17());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_18());
            ++columnCountSON;
                                             
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_19());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_20());
            ++columnCountSON;
                                             
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_21());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_22());
            ++columnCountSON;
                                             
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_23());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_24());
            ++columnCountSON;
                                             
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_25());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_26());
            ++columnCountSON;
                                             
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_27());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_28());
            ++columnCountSON;
                                             
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_29());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getAnswer_correctness_30());
            ++columnCountSON;
                                             
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getNumber_of_correct_answers());
            ++columnCountSON;
            
            cSON=rowSON.createCell(columnCountSON);
            cSON.setCellValue(participantAnswersSON.get(i).getTotal_point());
            ++columnCountSON;
                                             
          
        	++i;
        }
        
        int totalDForColumn1SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_1();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn1SON;
        	++i;
        }
        
        int totalDForColumn2SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_2();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn2SON;
        	++i;
        }
        
        
        int totalDForColumn3SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_3();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn3SON;
        	++i;
        }
        
        int totalDForColumn4SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_4();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn4SON;
        	++i;
        }
        
        int totalDForColumn5SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_5();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn5SON;
        	++i;
        }
        
        int totalDForColumn6SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_6();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn6SON;
        	++i;
        }
        
        int totalDForColumn7SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_7();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn7SON;
        	++i;
        }
        
        int totalDForColumn8SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_8();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn8SON;
        	++i;
        }
        
        int totalDForColumn9SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_9();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn9SON;
        	++i;
        }
        
        int totalDForColumn10SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_10();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn10SON;
        	++i;
        }
        
        int totalDForColumn11SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_11();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn11SON;
        	++i;
        }
        
        int totalDForColumn12SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_12();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn12SON;
        	++i;
        }
        
        int totalDForColumn13SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_13();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn13SON;
        	++i;
        }
        
        int totalDForColumn14SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_14();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn14SON;
        	++i;
        }
        
        int totalDForColumn15SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_15();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn15SON;
        	++i;
        }
        
        int totalDForColumn16SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_16();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn16SON;
        	++i;
        }
        
        int totalDForColumn17SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_17();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn17SON;
        	++i;
        }
        
        int totalDForColumn18SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_18();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn18SON;
        	++i;
        }
        
        int totalDForColumn19SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_19();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn19SON;
        	++i;
        }
        
        int totalDForColumn20SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_20();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn20SON;
        	++i;
        }
        
        int totalDForColumn21SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_21();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn21SON;
        	++i;
        }
        
        int totalDForColumn22SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_22();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn22SON;
        	++i;
        }
        
        int totalDForColumn23SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_23();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn23SON;
        	++i;
        }
        
        int totalDForColumn24SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_24();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn24SON;
        	++i;
        }
        
        int totalDForColumn25SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_25();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn25SON;
        	++i;
        }
        
        int totalDForColumn26SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_26();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn26SON;
        	++i;
        }
        
        int totalDForColumn27SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_27();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn27SON;
        	++i;
        }
        
        int totalDForColumn28SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_28();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn28SON;
        	++i;
        }
        
        int totalDForColumn29SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_29();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn29SON;
        	++i;
        }
        
        int totalDForColumn30SON=0;
        i=0;
        while(i<participantAnswersSON.size())
        {
        	String s=participantAnswersSON.get(i).getAnswer_correctness_30();
        	if(s.equalsIgnoreCase("D")) ++totalDForColumn30SON;
        	++i;
        }
        
        int avgDSON=(
        			totalDForColumn1SON
        			+totalDForColumn2SON
        			+totalDForColumn3SON
        			+totalDForColumn4SON
        			+totalDForColumn5SON
        			+totalDForColumn6SON
        			+totalDForColumn7SON
        			+totalDForColumn8SON
        			+totalDForColumn9SON
        			+totalDForColumn10SON
        			+totalDForColumn11SON
        			+totalDForColumn12SON
        			+totalDForColumn13SON
        			+totalDForColumn14SON
        			+totalDForColumn15SON
        			+totalDForColumn16SON
        			+totalDForColumn17SON
        			+totalDForColumn18SON
        			+totalDForColumn19SON
        			+totalDForColumn20SON
        			+totalDForColumn21SON
        			+totalDForColumn22SON
        			+totalDForColumn23SON
        			+totalDForColumn24SON
        			+totalDForColumn25SON
        			+totalDForColumn26SON
        			+totalDForColumn27SON
        			+totalDForColumn28SON
        			+totalDForColumn29SON
        			+totalDForColumn30SON
        			)/participantAnswersSON.size();
        int avgPointSON=avgDSON*100/30;
        
        XSSFRow rowSON2=sheetSON.createRow(rowCountSON);
        ++rowCountSON;
        columnCountSON=1;
        
        XSSFCell cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn1SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn2SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn3SON);
        ++columnCountSON;
        
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn4SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn5SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn6SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn7SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn8SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn9SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn10SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn11SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn12SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn13SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn14SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn15SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn16SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn17SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn18SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn19SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn20SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn21SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn22SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn23SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn24SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn25SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn26SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn27SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn28SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn29SON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(totalDForColumn30SON);
        ++columnCountSON;
        
        
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(avgDSON);
        ++columnCountSON;
        
        cSON2=rowSON2.createCell(columnCountSON);
        cSON2.setCellValue(avgPointSON);
        ++columnCountSON;
        
        workbook.write(fos);
        workbook.close();
	}
	
	
}
