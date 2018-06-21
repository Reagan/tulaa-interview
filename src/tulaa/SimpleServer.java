package tulaa;

import java.io.*;
import java.net.*;

class SimpleServer {

    private static SimpleServer server;
    private ServerSocket socket;
    private Socket incoming;
    private BufferedReader readerIn;
    private PrintStream printOut;
    private static final int PORT = 8080;

    public static void main(String[] args) {
        server = new SimpleServer(PORT);
    }


    private SimpleServer(int port) {
        try {
            socket = new ServerSocket(port);
            incoming = socket.accept();
            readerIn = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            printOut = new PrintStream(incoming.getOutputStream());

            printOut.println("Enter EXIT to exit.\r");
            out("Enter EXIT to exit.\r");

            boolean done = false;
            while (!done) {
                String str = readerIn.readLine();

                if (str == null) {
                    done = true;
                } else {
                    out("Echo: " + str + "\r");
                    if (str.trim().equals("EXIT"))
                        done = true;
                }
                incoming.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void out(String str) {
        printOut.println(str);
        System.out.println(str);
    }
}