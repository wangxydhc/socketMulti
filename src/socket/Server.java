package socket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port;
	Server(int port){
		this.port=port;
		System.out.println("Server的线程号："+Thread.currentThread());
	}
	public void begin() throws IOException, Throwable {
		ServerSocket server = new ServerSocket(port);
		Socket socket = server.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
//		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Server用于接收的线程号："+Thread.currentThread());
				while (true) {
					try {			
						if(br.ready()){
							String s = br.readLine();
							System.out.println("Server"+port + "输出:" + s);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}).start();
//		FileReader fr=new FileReader("D:/serverInput.txt");
//		BufferedReader ServerBr=new BufferedReader(fr);
//		for(int i=0;i<20;i++){
//			Thread.sleep(2000);
//			String text=ServerBr.readLine();
//			System.out.println(text);
////			pw.println(text);
//		}
	}
	public static void main(String[] args) throws IOException, Throwable {
		new ServerHelper(2000);
		new ClientHelper(2000,"D:/2000.txt");
		Thread.sleep(3000);
		new ServerHelper(1600);
		new ClientHelper(1600,"D:/1600.txt");
	}
}
	
