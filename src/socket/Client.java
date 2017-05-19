package socket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
	int port;
	String file="";
	Client(int port,String file) {
		System.out.println("Client的线程号："+Thread.currentThread());
		this.port = port;
		this.file=file;
	}
	public void begin() throws IOException, InterruptedException {
		System.out.println("——---------");
		Socket socket = new Socket("localhost", port);
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		System.out.println("——---------");
		FileReader fr = new FileReader(file);
		BufferedReader ServerBr = new BufferedReader(fr);
		System.out.println("——---------");
		for (int i = 0; i < 20; i++) {
			Thread.sleep(500);
			String text = ServerBr.readLine();			
			 pw.println(text);
		}
	}
}
