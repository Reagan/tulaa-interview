package tulaa;

import java.io.*;
import java.net.*;

class SimpleServer {

    public SimpleServer(int port) {}

    public static void main(String[] args) {
        int port = 8080;
        SimpleServer server = new SimpleServer(port);
        server.start();
    }

    public void start() {
        try {
            System.out.println("Starting server...");
            ServerSocket socket = new ServerSocket(8080);
            Socket incoming = socket.accept();
            PrintWriter out = new PrintWriter(incoming.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));

            String inputLine, response = "";
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals("exit")) break;
                System.out.println(String.format("Received: %s", inputLine));
                String processStr = inputLine.substring(inputLine.lastIndexOf("/") + 1);
                if (inputLine.contains("/parenthesis/validate"))
                    response = new ParenthesisChecker().validate(processStr);
                else if (inputLine.contains("/string_reverser/swap"))
                    response = new StringReverserSansSpecialChars().swap(processStr);
                out.println(response);
            }

            socket.close();
            incoming.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}