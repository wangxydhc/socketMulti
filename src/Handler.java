import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;


public class Handler implements Runnable {
		final SocketChannel socket;
		final SelectionKey sk;
		ByteBuffer input = ByteBuffer.allocate(200);
		ByteBuffer output = ByteBuffer.allocate(200);
		static final int READING = 0, SENDING = 1;
		int state = READING;

		Handler(Selector sel, SocketChannel c) throws IOException {
			socket = c;
			c.configureBlocking(false);
			sk = socket.register(sel, 0);
			sk.attach(this);
			sk.interestOps(SelectionKey.OP_READ);
			sel.wakeup();
			
			
		}



//		boolean inputIsComplete() { /* ... */
//		
//		}
//
//		boolean outputIsComplete() { /* ... */
//		}

		void process() { /* ... */
		}

		public void run() {
			try {
				if (state == READING)
					read();
				else if (state == SENDING)
					send();
			} catch (IOException ex) { /* ... */
			}
		}

		void read() throws IOException {
			socket.read(input);
//			if (inputIsComplete()) {
				process();
				state = SENDING;
				sk.interestOps(SelectionKey.OP_WRITE);
//			}
		}

		void send() throws IOException {
			socket.write(output);
//			if (outputIsComplete())
				sk.cancel();
		}
	}
