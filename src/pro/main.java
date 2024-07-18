package pro;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

	public static void main(String[] args) {
		String p1 = "\\w+@[a-zA-Z0-9.-]+\\.[a-zA-z]{2,}";
		String p2= "(\\d{10})" +
				"|((([(]\\d{3}[)])|(\\d{3}))-\\d{3}-\\d{4})" +
				"|(\\d{3}\\.\\d{3}\\.\\d{4})" +
				"|(\\d{3}\\s\\d{3}\\s\\d{4})" ;
		String p3 ="\\d{4}-(0[1-9]|1[0-2])-([0-2]\\d|3[01])" +
				"|((0?[1-9]|[0-2]\\d|3[01])-(0?[1-9]|1[0-2])-\\d{4})"+
				"|(\\d{4}/(0[1-9]|1[0-2])/([0-2]\\d|3[01]))" +
				"|((0?[1-9]|[0-2]\\d|3[01])/(0?[1-9]|1[0-2])/\\d{4})";
		String p4 = "((25[0-5]|2[0-4]\\d|[1]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[1]?\\d\\d?)";
		String p5 ="[_a-zA-Z][_a-zA-Z0-9]*";
		String p6 = "((?![bB]{3}).)*";
		String p7 = "(a(bb)*b(aa)*(aabb)*(abab)*(bbaa)*(baba)*)"
				+ "|(b(bb)*a(aa)*(aabb)*(abab)*(bbaa)*(baba)*)"
				+ "|(b(aa)*a(bb)*(aabb)*(abab)*(bbaa)*(baba)*)"
				+ "|(a(aa)*b(bb)*(aabb)*(abab)*(bbaa)*(baba)*)"
				+ "|((aa)*b(bb)*a(aa)*(bb)*)|((bb)*a(aa)*b(bb)*(bb)*)";
		String p8 = "\\b[a-zA-Z]{3}\\b";
		String p9 ="(https?://([a-zA-Z0-9.-]+)([a-zA-Z0-9-]+)(/[a-zA-Z0-9]*)*)";
		String p10 ="[-+]?(\\d+(\\.\\d+)?|[a-zA-Z])+([+-/*][-+]?(\\d+(\\.\\d+)?|[a-zA-Z])+)*"
				+ "=[-+]?(\\d+(\\.\\d+)?|[a-zA-Z])+([+-/*][-+]?(\\d+(\\.\\d+)?|[a-zA-Z])+)*";
		String readfile;
		File file = new File("input.txt");
        try {
			Scanner myReader= new Scanner(file);
			FileWriter myWriter = new FileWriter("output.txt");
			while (myReader.hasNextLine()) {
				readfile=myReader.nextLine();
				if(readfile.equals("1")) {
				    myWriter.write(readfile+"\n");
					readfile=myReader.nextLine();
					while(!readfile.equals("end")) {
						if(Pattern.matches(p1, readfile)) {
							myWriter.write("valid email\n");
						}
						else {
							myWriter.write("invalid email\n");
						}	
						readfile=myReader.nextLine();
					}
					myWriter.write("x\n");
				}
				else if(readfile.equals("2")) {
					myWriter.write(readfile+"\n");
					readfile=myReader.nextLine();
					while(!readfile.equals("end")) {
						if(Pattern.matches(p2, readfile)) {
							myWriter.write("valid phone number\n");
						}
						else {
							myWriter.write("invalid phone number\n");
						}
						readfile=myReader.nextLine();
					}
					myWriter.write("x\n");
				}
				else if(readfile.equals("3")) {
					myWriter.write(readfile+"\n");
					readfile=myReader.nextLine();
					while(!readfile.equals("end")) {
						if(Pattern.matches(p3, readfile)) {
							myWriter.write("valid date\n");
						}
						else {
							myWriter.write("invalid date\n");
						}
						readfile=myReader.nextLine();
					}
					myWriter.write("x\n");		
				}
				else if(readfile.equals("4")) {
					myWriter.write(readfile+"\n");
					readfile=myReader.nextLine();
					while(!readfile.equals("end")) {
						if(Pattern.matches(p4, readfile)) {
							myWriter.write("valid IP address\n");
						}
						else {
							myWriter.write("invalid IP address\n");
						}
						readfile=myReader.nextLine();
					}
					myWriter.write("x\n");
				}
				else if(readfile.equals("5")) {
					myWriter.write(readfile+"\n");
					readfile=myReader.nextLine();
					while(!readfile.equals("end")) {
						if(Pattern.matches(p5, readfile)) {
							myWriter.write("valid C++ variable name\n");
						}
						else {
							myWriter.write("invalid C++ variable name\n");
						}
						readfile=myReader.nextLine();
					}
					myWriter.write("x\n");
				}
				else if(readfile.equals("6")) {
					myWriter.write(readfile+"\n");
					readfile=myReader.nextLine();
					while(!readfile.equals("end")) {
						if(Pattern.matches(p6, readfile)) {
							myWriter.write("valid string\n");
						}
						else {
							myWriter.write("invalid string, has 3 consecutive b’s\n");
						}
						readfile=myReader.nextLine();
					}
					myWriter.write("x\n");
				}
				else if(readfile.equals("7")) {
					myWriter.write(readfile+"\n");
					readfile=myReader.nextLine();
					while(!readfile.equals("end")) {
						myWriter.write("*"+readfile+"*\n");
						int cnt=0;
						ArrayList<String> ans=new ArrayList<String>();
						ArrayList<Integer> start=new ArrayList<Integer>();
						ArrayList<Integer> end=new ArrayList<Integer>();
						Pattern pattern = Pattern.compile(p7);
						Matcher matcher = pattern.matcher(readfile);
						while (matcher.find())
						{
							cnt++;
							ans.add(matcher.group());
							start.add(matcher.start());
							end.add(matcher.end());
						}
						if(cnt==0)
							myWriter.write("No substring matches\n");
						else {
							myWriter.write("number of matched substrings: "+cnt+"\n");
							for(int i=0;i<cnt;i++) {
								myWriter.write("matched substring: "+ans.get(i)+"\n");
								myWriter.write("start index: "+start.get(i)
											+", end index: "+end.get(i)+"\n");
							}
						}
						readfile=myReader.nextLine();
					}
					myWriter.write("x\n");
				}
				else if(readfile.equals("8")) {
					myWriter.write(readfile+"\n");
					readfile=myReader.nextLine();
					while(!readfile.equals("end")) {
						myWriter.write("*"+readfile+"*\n");
						int cnt=0;
						ArrayList<String> ans=new ArrayList<String>();
						ArrayList<Integer> start=new ArrayList<Integer>();
						ArrayList<Integer> end=new ArrayList<Integer>();
						Pattern pattern = Pattern.compile(p8);
						Matcher matcher = pattern.matcher(readfile);
						while (matcher.find())
						{
							cnt++;
							ans.add(matcher.group());
							start.add(matcher.start());
							end.add(matcher.end());
						}
						if(cnt==0)
							myWriter.write("No word matches\n");
						else {
							myWriter.write("number of matched words: "+cnt+"\n");
							for(int i=0;i<cnt;i++) {
								myWriter.write("matched word: "+ans.get(i)+"\n");
								myWriter.write("start index: "+start.get(i)
											+", end index: "+end.get(i)+"\n");
							}
						}
						readfile=myReader.nextLine();
					}
					myWriter.write("x\n");
				}
				else if(readfile.equals("9")) {
					myWriter.write(readfile+"\n");
					readfile=myReader.nextLine();
					while(!readfile.equals("end")) {
						myWriter.write("*"+readfile+"*\n");
						File file2 = new File(readfile);
				        Scanner myReader2;
				        ArrayList<String> lines=new ArrayList<String>();
				        Pattern pattern = Pattern.compile(p9);
						myReader2 = new Scanner(file2);
						while (myReader2.hasNextLine()) {
							lines.add(myReader2.nextLine());
						}
						int cnt=0;
						ArrayList<String> ans=new ArrayList<String>();
						ArrayList<Integer> linenum=new ArrayList<Integer>();
						ArrayList<Integer> start=new ArrayList<Integer>();
						ArrayList<Integer> end=new ArrayList<Integer>();
				        for (int i=0;i<lines.size();i++) {
				            Matcher matcher = pattern.matcher(lines.get(i));
				            while (matcher.find()) {
				            	cnt++;
								ans.add(matcher.group());
								linenum.add(i+1);
								start.add(matcher.start());
								end.add(matcher.end());
				            }      
					}
				        if(cnt==0)
							myWriter.write("No URLs in file\n");
						else {
							myWriter.write("Number of URLs: "+cnt+"\n");
							for(int j=0;j<cnt;j++) {
								myWriter.write("URL: "+ans.get(j)+"\n");
								myWriter.write("Line: "+linenum.get(j)+"\n");
								myWriter.write("start index: "+start.get(j)
											+", end index: "+end.get(j)+"\n");
							}
						}
				        readfile=myReader.nextLine();
				    }
					myWriter.write("x\n");
				}
				else if(readfile.equals("10")) {
					myWriter.write(readfile+"\n");
					readfile=myReader.nextLine();
					while(!readfile.equals("end")) {
						if(Pattern.matches(p10, readfile)) {
							myWriter.write("valid mathematical expression\n");
						}
						else {
							myWriter.write("invalid mathematical expression\n");
						}
						readfile=myReader.nextLine();
					}
					myWriter.write("x\n");
				}
				else if(readfile.equals("end"))
				{
					break;
				}
					
				
	          }
			myWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

