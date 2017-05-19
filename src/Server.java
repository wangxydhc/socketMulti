import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Server implements Runnable {
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(1695);
			try {
				Thread.sleep(500);
				System.out.println("sleep");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("begin");
			new Thread(new Handler(ss.accept())).start();
			System.out.println("over");

			// or, single-threaded, or a thread pool
		} catch (IOException ex) { /* ... */
		}
	}

	static class Handler implements Runnable {
		final Socket socket;

		Handler(Socket s) {
			socket = s;
			System.out.println("Handler is created");
		}

		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getId());
		}
	}

	public static void main(String[] args) {
		new Thread(new Server()).start();
	}
}


