import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            //remote socket - 1
            Socket socket = new Socket("LocalHost",3002);

            //use outputstream for write data - 2
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            // send massage
            dataOutputStream.writeUTF("hello sir");

            String massage = null;

            while (!massage.equals("exsit")){
                massage = dataInputStream.readUTF();
                System.out.println("Server : " +massage);
                dataInputStream.readUTF();
            }

            dataOutputStream.flush();
            dataOutputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
