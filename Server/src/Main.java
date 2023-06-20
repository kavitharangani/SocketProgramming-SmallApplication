import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            //create a server socket - 1
            ServerSocket serverSocket = new ServerSocket(3002);

            //accept request and move to new socket - 2
            Socket socket = serverSocket.accept();
            System.out.println("Accept");
            
            //java application used inputStream to read the data - 3
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            //dataOutputStream.writeUTF("hello sir");
            String massage = dataInputStream.readUTF();
            System.out.println("Client : " +massage);

            //final close socket - 5

            while (!massage.equals("exsit")){
                massage = dataInputStream.readUTF();
                dataOutputStream.writeUTF("hello sir");
                dataOutputStream.flush();
            }

            dataOutputStream.flush();
            dataOutputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
