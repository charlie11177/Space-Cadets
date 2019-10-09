import java.io.*;
import java.net.*;
import java.util.regex.*;
import java.util.Scanner;

public class SCChallengeEmail {
	public static void main(String[] args) throws Exception{
		while(true){
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter the id");
			String inp = scn.nextLine();
			URL url = new URL("https://www.ecs.soton.ac.uk/people/"+inp);
			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
				String html = new String();
				while (br.readLine() != null){
					html += br.readLine();
				}
				Pattern p = Pattern.compile("<title>(.*?)\\|");
				Matcher m = p.matcher(html);
				m.find();
				if(m.group(1).contains("People")){
					System.out.println("No Staff member found");
				}else {
					System.out.println(m.group(1));
				}
				
			}
			catch(Exception e){
				System.out.println("Error: " + e);
			}
		}
	}
}