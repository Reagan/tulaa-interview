package tulaa;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimpleClient {

    public static void main(String[] args) {
        SimpleClient client = new SimpleClient();
        client.initiateRequest();
    }

    private void initiateRequest() {
        try {
            Socket clientSocket = new Socket("localhost", 8080);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeBytes("/parenthesis/validate/()()");
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String s = "";
            while(inFromServer.read() != -1) {
                s += inFromServer.readLine();
            }
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
