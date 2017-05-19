package socket;

import java.io.IOException;

public class ServerHelper {
	int port;
	ServerHelper(int port){
		this.port=port;
		this.begin();
	}
	public void begin(){
		new Thread(new Runnable(){
			public void run(){
				Server c=new Server(port);
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
