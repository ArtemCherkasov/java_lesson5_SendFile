import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static final int PORT = 19000;
    public static final String HOST = "localhost";
    public static final int filesize=70112; 

    public static void main(String[] args) throws Exception {

    	int bytesRead; 
    	int currentTot = 0; 
    	Socket socket = new Socket(HOST, PORT);

    	byte [] bytearray = new byte [filesize]; 
    	InputStream is = socket.getInputStream(); 
    	FileOutputStream fos = new FileOutputStream("copy.dat"); 
    	BufferedOutputStream bos = new BufferedOutputStream(fos); 
    	bytesRead = is.read(bytearray,0,bytearray.length); 
    	currentTot = bytesRead;
    	/*
    	do { 
    		bytesRead = is.read(bytearray, currentTot, (bytearray.length-currentTot)); 
    		if(bytesRead >= 0) currentTot += bytesRead; 
    	} while(bytesRead > -1);
    	*/
    	bos.write(bytearray, 0 , currentTot); 
    	bos.flush(); 
    	bos.close(); 
    	socket.close();
    	System.out.println("end.........");

    }
    
}