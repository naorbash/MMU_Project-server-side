package com.hit.businesslogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.hit.login.AuthenticationManager;

public class MMUConfigFileFacade implements Runnable{
	
	private AuthenticationManager AM = new AuthenticationManager();
	private MMUConfigFileBrowsing fileBrowsing = new MMUConfigFileBrowsing();
	private Socket someClient;
	
	public MMUConfigFileFacade(Socket s) {
		someClient = s;
	}
	
	@Override
	public void run() {
		try{
			ObjectOutputStream output=new ObjectOutputStream(someClient.getOutputStream());
			ObjectInputStream input=new ObjectInputStream(someClient.getInputStream());
			
			String requestInfo =(String)input.readObject();  //getting the content string from the user.
			Scanner sc = new Scanner(requestInfo);
			sc.useDelimiter(" ");
			String username = sc.next();
			String password = sc.next();
			String configFile = sc.next();
			sc.close();
			
			boolean userAuthentication = AuthenticationManager.authenticate(username, password);
			if(userAuthentication){
				output.writeObject("Logged in successfully");
				output.flush();
				
				File f;
				f = fileBrowsing.findingConfigFile(configFile);
				output.writeObject(f);
				output.flush();
			}
			else{
				output.writeObject("Error  - username / password invalid.");
				output.flush();
			}
			output.close();
			input.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
