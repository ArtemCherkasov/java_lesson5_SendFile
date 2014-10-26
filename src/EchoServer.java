import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.stream.FileImageInputStream;

public class EchoServer {

    public static final int PORT = 19000;

    @SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
    	
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept(); System.out.println("Accepted connection : " + socket); 
        File transferFile = new File ("data.dat"); 
        byte [] bytearray = new byte [(int)transferFile.length()]; 
        FileInputStream fin = new FileInputStream(transferFile); 
        BufferedInputStream bin = new BufferedInputStream(fin); 
        bin.read(bytearray,0,bytearray.length); 
        OutputStream os = socket.getOutputStream(); 
        System.out.println("Sending Files..."); 
        os.write(bytearray,0,bytearray.length); 
        os.flush(); socket.close(); 
        System.out.println("File transfer complete");

    }
}
