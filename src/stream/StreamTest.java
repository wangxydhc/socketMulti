package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class StreamTest {
	public static void main(String[] args) throws IOException {
		File r=new File("D:/read.txt");
		File w=new File("D:/write.txt");
		String s="";
		
		try {
			r.createNewFile();
			w.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Reader isr=new FileReader(r);
			BufferedReader br=new BufferedReader(isr);
			s=br.readLine();
			System.out.println(s);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Writer fos=new FileWriter(w);
			BufferedWriter bw=new BufferedWriter(fos);
			PrintWriter pw=new PrintWriter(bw);
			pw.write(s+"dsf");			
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
