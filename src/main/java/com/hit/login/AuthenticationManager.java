package com.hit.login;

import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.hit.dm.User;

public class AuthenticationManager 
{

	public static boolean authenticate(String username, String password) throws JsonIOException, JsonSyntaxException, FileNotFoundException{

		Gson gson = new Gson();
		User[] authorizedUsers = gson.fromJson(new JsonReader(new FileReader("src/main/resources/com/hit/login/Users.json")), User[].class); //getting an array of all authorized users

		User incomingUser = new User(); 		 //creating a new User with the giving arguments.
		incomingUser.setPassword(password);
		incomingUser.setUsername(username);

		for(int i=0;i<authorizedUsers.length;++i){ 		//Checking inside the list to see if that user exists.
			if(authorizedUsers[i].equals(incomingUser))
				return true;
		}
		return false;
	}
}
