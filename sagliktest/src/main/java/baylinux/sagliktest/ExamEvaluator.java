package baylinux.sagliktest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExamEvaluator 
{
	
	public static ParticipantAnswer createParticipantAnswerWithInformation
	(PreferredSettings ps,File file,Exam exam,int sayi) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		String imageFullPath=file.getAbsolutePath();
		ParticipantAnswer pa=new ParticipantAnswer();
		String title=ImageConverter
				.convertTitlesOfExamToDigitalFormatFromImageToObtainTestType(ps, imageFullPath);
		String test_type=InfoExtractor.extractTestType(title);
		
		//String name_surname=InfoExtractor.extractNameAndSurnameFromTitle(title,ps.getNearWords());
		String name_surname="";
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yy HH-mm-ss");
		String oldFileName="";
		if(imageFullPath.contains("/"))
		{
			oldFileName=imageFullPath.substring(imageFullPath.lastIndexOf("/")+1);
		}
		else
		{
			oldFileName=imageFullPath.substring(imageFullPath.lastIndexOf("\\")+1);
		}
		String ext = oldFileName.substring(oldFileName.lastIndexOf('.')+1);
		String newFileName=LocalDateTime.now().format(dateFormat)
				+" "+test_type.split(" ")[0]+" "+sayi+"."+ext;
		 Path sourcePath = Paths.get(imageFullPath);
	        Path targetPath = sourcePath.resolveSibling(newFileName);
	        try 
	        {
				Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
			} 
	        catch (IOException e) 
	        {
				e.printStackTrace();
			}
	        String newImageFullPath = targetPath.toString();
	        byte[] bytes=ImageConverter.getUserImageBytes(ps, newImageFullPath);
		List<List<String>> tableData=ImageConverter
					.convertMultipleChoiceExamAnswersToDigitalFormatFromImage(ps, newImageFullPath);
		
		pa.setFile_name(newFileName);
		pa.setTest_image(bytes);
		pa.setName_surname(name_surname);
		pa.setTest_type(test_type);
		pa.setExam_id(exam.getId());
		List<String> answers=new ArrayList<String>();
		
		int i=0;
		while(i<tableData.size())
		{
			String s="";
			if(tableData.get(i).size()==4)
			{
				if(tableData.get(i).get(0).equalsIgnoreCase("+")) s="A";
				if(tableData.get(i).get(1).equalsIgnoreCase("+")) s="B";
				if(tableData.get(i).get(2).equalsIgnoreCase("+")) s="C";
				if(tableData.get(i).get(3).equalsIgnoreCase("+")) s="D";
			}
			else if(tableData.get(i).size()==5)
			{
				if(tableData.get(i).get(0).equalsIgnoreCase("+")) s="A";
				if(tableData.get(i).get(1).equalsIgnoreCase("+")) s="B";
				if(tableData.get(i).get(2).equalsIgnoreCase("+")) s="C";
				if(tableData.get(i).get(3).equalsIgnoreCase("+")) s="D";
				if(tableData.get(i).get(4).equalsIgnoreCase("+")) s="E";
			}
			answers.add(s);
			++i;
		}
		i=0;
		int numberOfCorrectAnswersOver30=0;
		int numberOfCorrectAnswersOver25=0;
		while(i<tableData.size())
		{
			if(pa.getTest_type().equalsIgnoreCase("ON TEST"))
			{
				String g="getOn"+(i+1);
				Method method = Exam.class.getMethod(g);
				String result = (String) method.invoke(exam);
				
				String k="setParticipant_answer_"+(i+1);
				Method method2 = ParticipantAnswer.class.getMethod(k,String.class);
				method2.invoke(pa,answers.get(i));
				
				String l="setAnswer_correctness_"+(i+1);
				Method method3 = ParticipantAnswer.class.getMethod(l,String.class);
				
				
				if(answers.get(i).equalsIgnoreCase(result)&&!answers.get(i).equalsIgnoreCase(""))
				{
					method3.invoke(pa,"D");
					++numberOfCorrectAnswersOver30;
					if(i<=25)
					{
						++numberOfCorrectAnswersOver25;
					}
				}
				else
				{
					method3.invoke(pa,"Y");
				}
			}
			else if(pa.getTest_type().equalsIgnoreCase("SON TEST"))
			{
				String g="getSon"+(i+1);
				Method method = Exam.class.getMethod(g);
				String result = (String) method.invoke(exam);
				
				String k="setParticipant_answer_"+(i+1);
				Method method2 = ParticipantAnswer.class.getMethod(k,String.class);
				method2.invoke(pa,answers.get(i));
				
				String l="setAnswer_correctness_"+(i+1);
				Method method3 = ParticipantAnswer.class.getMethod(l,String.class);
				
				
				if(answers.get(i).equalsIgnoreCase(result)&&!answers.get(i).equalsIgnoreCase(""))
				{
					method3.invoke(pa,"D");
					++numberOfCorrectAnswersOver30;
					if(i<=25)
					{
						++numberOfCorrectAnswersOver25;
					}
				}
				else
				{
					method3.invoke(pa,"Y");
				}
			}
			else
			{
				String k="setParticipant_answer_"+(i+1);
				Method method2 = ParticipantAnswer.class.getMethod(k,String.class);
				method2.invoke(pa,answers.get(i));
				
				String l="setAnswer_correctness_"+(i+1);
				Method method3 = ParticipantAnswer.class.getMethod(l,String.class);
				method3.invoke(pa,"Y");
			}
			++i;
		}
		pa.setNumber_of_correct_answers_over_30(numberOfCorrectAnswersOver30);
		pa.setTotal_point_over_30(pa.getNumber_of_correct_answers_over_30()*100/30);
		pa.setNumber_of_correct_answers_over_25(numberOfCorrectAnswersOver25);
		pa.setTotal_point_over_25(pa.getNumber_of_correct_answers_over_25()*100/25);
		return pa;
		
		
	}
	public static ParticipantAnswer updateParticipantAnswerInformation
	(PreferredSettings ps,ParticipantAnswer pa,Exam exam) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		
		
		
		
		
		
		
		int i=0;
		int numberOfCorrectAnswersOver30=0;
		int numberOfCorrectAnswersOver25=0;
		while(i<30)
		{
			if(pa.getTest_type().equalsIgnoreCase("ON TEST"))
			{
				String g="getOn"+(i+1);
				Method method = Exam.class.getMethod(g);
				String result = (String) method.invoke(exam);
				
				String m="getParticipant_answer_"+(i+1);
				Method method1 = ParticipantAnswer.class.getMethod(m);
				String participantAnswer=(String)method1.invoke(pa);
				
				
				
				String l="setAnswer_correctness_"+(i+1);
				Method method3 = ParticipantAnswer.class.getMethod(l,String.class);
				
				
				if(participantAnswer.equalsIgnoreCase(result))
				{
					method3.invoke(pa,"D");
					++numberOfCorrectAnswersOver30;
					if(i<=25)
					{
						++numberOfCorrectAnswersOver25;
					}
				}
				else
				{
					method3.invoke(pa,"Y");
				}
			}
			else if(pa.getTest_type().equalsIgnoreCase("SON TEST"))
			{
				String g="getSon"+(i+1);
				Method method = Exam.class.getMethod(g);
				String result = (String) method.invoke(exam);
				
				String m="getParticipant_answer_"+(i+1);
				Method method1 = ParticipantAnswer.class.getMethod(m);
				String participantAnswer=(String)method1.invoke(pa);
				
				String l="setAnswer_correctness_"+(i+1);
				Method method3 = ParticipantAnswer.class.getMethod(l,String.class);
				
				
				if(participantAnswer.equalsIgnoreCase(result))
				{
					method3.invoke(pa,"D");
					++numberOfCorrectAnswersOver30;
					if(i<=25)
					{
						++numberOfCorrectAnswersOver25;
					}
				}
				else
				{
					method3.invoke(pa,"Y");
				}
			}
			else
			{
				String m="getParticipant_answer_"+(i+1);
				Method method1 = ParticipantAnswer.class.getMethod(m);
				String participantAnswer=(String)method1.invoke(pa);
				
				String l="setAnswer_correctness_"+(i+1);
				Method method3 = ParticipantAnswer.class.getMethod(l,String.class);
				method3.invoke(pa,"Y");
			}
			++i;
		}
		pa.setNumber_of_correct_answers_over_30(numberOfCorrectAnswersOver30);
		pa.setTotal_point_over_30(pa.getNumber_of_correct_answers_over_30()*100/30);
		pa.setNumber_of_correct_answers_over_25(numberOfCorrectAnswersOver25);
		pa.setTotal_point_over_25(pa.getNumber_of_correct_answers_over_25()*100/25);
		return pa;
		
		
	}
}
