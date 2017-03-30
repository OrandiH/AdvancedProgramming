package sdsmh_server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import models.Student_model;

public class Client {
	private static Socket client;
	private static ObjectInputStream input;
	private static ObjectOutputStream output;
	
	public static void main(String[] args)
	{
		//connecting client to server
		try {
			Response message = new Response();
			Student_model user;
			//Connect to server class
			client = new Socket(InetAddress.getLocalHost(),1234);
			System.out.println("Connected to : " + client.getInetAddress().getHostName());
			
			output = new ObjectOutputStream(client.getOutputStream());
			message.setAction("view");
			message.setMessage("need to view data");
			message.setSource(client.getInetAddress().getHostName());
			message.setSource("student");
			message.setId(1401001);
			message.setPassword("coone1001");
			output.writeObject(message);
			output.flush();
			
			
			
			//Reading message from server
			input = new ObjectInputStream(client.getInputStream());
			user = (Student_model) input.readObject();
			System.out.println("Response: "+ message.getRepsonseSource());
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			String email = user.getEmail();
			int id = user.getId();
			String telephoneNum = user.getTelephoneNum();
			String status = user.getClearStatus();
			float balance = user.getAccountBal();
			
			Student_model user2 = new Student_model(id,firstName,lastName,email,balance,telephoneNum,status);
			System.out.println(user2);
			
			//Send message to server
			
			
			
			//output.close();
			
			
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
