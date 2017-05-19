package socket;

import java.io.IOException;

public class ClientHelper {
	int port;
	String file;
	ClientHelper(int port,String file){
		this.port=port;
		this.file=file;
		this.begin();
	}
	public void begin(){
		new Thread(new Runnable(){
			public void run(){
				Client c=new Client(port,file);
				try {
					c.begin();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
	
}
