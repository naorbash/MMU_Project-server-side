package com.hit.businesslogic;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MMUConfigFileBrowsing {
	private ArrayList<File> files;
	
	public MMUConfigFileBrowsing(){
		File f = new File("src/main/resources/com/hit/data");
		 files = new ArrayList<File>(Arrays.asList(f.listFiles()));//Putting all files in the directory in a data structure.
	}
	
	public File findingConfigFile(String fileName){
		for(int i=0;i<files.size();++i)   //search for the requested file and return in to the client.
		{
			if (fileName.equals(files.get(i).getName()))
					return files.get(i).getAbsoluteFile();
		}
		return null;
		
	}
}
