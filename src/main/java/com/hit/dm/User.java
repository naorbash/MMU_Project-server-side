package com.hit.dm;

public class User 
{
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean equals(Object obj) {
		User user = (User) obj;
		if(this.getUsername().equals(user.getUsername()))
			if(this.getPassword().equals(user.getPassword()))
				return true;
		return false;
	}
	
}
