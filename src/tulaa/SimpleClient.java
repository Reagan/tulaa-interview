package tulaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {

    public SimpleClient() {}

    public static void main(String[] args) {
        SimpleClient client = new SimpleClient();
        client.initiateRequest();
    }

    private void initiateRequest() {
        try {
            Socket socket = new Socket("localhost", 8080);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            request( "/parenthesis/validate/()()", out, in);
            request("/string_reverser/swap/This!is$a**test", out, in);

            socket.close();
            out.close();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void request(String message, PrintWriter out, BufferedReader in)
        throws IOException {
        out.println(message);
        String resp = in.readLine();
        System.out.println(String.format("Sending to server: %s", message));
        System.out.println(String.format("Received from server: %s", resp));
    }
}
