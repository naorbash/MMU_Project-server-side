package com.hit.Controller;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.hit.businesslogic.MMUConfigFileFacade;

public class MMUConfigFileController 
{
	private static boolean serverUp = true;

	public void start()
	{
		try {
			 ServerSocket server = new ServerSocket(12345);
			 while(serverUp)
			 {
				 Socket someClient = server.accept();
				 Executor executor = Executors. newFixedThreadPool (10);
				 executor.execute (new MMUConfigFileFacade(someClient));
				// new Thread(new Request(someClient)).start();
			 }
			 
			 server.close();
			 
			} catch (Exception e) {
			  System.out.println("Server Error");
			}
	}
}
