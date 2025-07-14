package baylinux.sagliktest;

import java.util.List;
import java.util.stream.Collectors;

public class InfoExtractor {
	
	public static String extractTestType(List<String> title)
	{
		if(title.size()==1)
		{
			if((title.get(0).contains("ÖN")||title.get(0).contains("ON"))
					&& !title.get(0).contains("SON"))
			{
				return "ON TEST";
			}
			else if((title.get(0).contains("ÖN")||title.get(0).contains("ON"))
					&& title.get(0).contains("SON"))
			{
				return "SON TEST";
			}
			else
			{
				return "TEST";
			}
			
		}
		else if(title.size()>=2)
		{
			if((title.get(0).contains("ÖN")||title.get(0).contains("ON"))
					&& !title.get(0).contains("SON"))
			{
				return "ON TEST";
			}
			else if((title.get(0).contains("ÖN")||title.get(0).contains("ON"))
					&& title.get(0).contains("SON"))
			{
				return "SON TEST";
			}
			else if((title.get(1).contains("ÖN")||title.get(1).contains("ON"))
					&& !title.get(1).contains("SON"))
			{
				return "ON TEST";
			}
			else if((title.get(1).contains("ÖN")||title.get(1).contains("ON"))
					&& title.get(1).contains("SON"))
			{
				return "SON TEST";
			}
			else
			{
				return "TEST";
			}
		}
		else
		{
			return "TEST";
		}
	}
	public static String extractNameAndSurnameFromTitle(List<String> title,String nearWords)
	{
		StringBuilder nameAndSurname=new StringBuilder();
		int i=0;
		List<String> nw=List.of(nearWords.split("-"));
		while(i<title.size())
		{
			int j=0;
			while(j<nw.size())
			{   String a=title.get(i).toUpperCase();
				String b=nw.get(j).toUpperCase();
				String c=b.replace("İ", "I")
						.replace("ö", "o")
						.replace("Ü", "U");
				if(
					a.contains(b) 
				  )
				{
					
					nameAndSurname=
							new StringBuilder
							(nameAndSurname
							.append(a.substring(a.indexOf(b)+b.length()+1).replaceAll("\\s", ""))
							.toString().trim())
							.append(" ");
					++i;
					j=0;
				}
				else if(
						a.contains(c)
					  )
					{
						nameAndSurname=
								new StringBuilder
								(nameAndSurname
								.append(a.substring(a.indexOf(c)+c.length()+1).replaceAll("\\s", ""))
								.toString().trim())
								.append(" ");
						++i;
						j=0;
					}
					++j;
		}
		++i;
	}
		return nameAndSurname.toString();
	}
}
