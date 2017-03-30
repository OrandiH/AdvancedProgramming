package sdsmh_server;

import java.io.IOException;
import java.net.*;

public class Server {
	private static ServerSocket server; 
	private static Socket connection;
	
	public static void main(String[]args)
	{
		try {
			server = new ServerSocket(1337,2);
			
			System.out.println("Waiting on connections....");
			connection = server.accept();
			
			if(connection != null)
			{
				System.out.println("Connection made!");
			}
			
			connection.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
