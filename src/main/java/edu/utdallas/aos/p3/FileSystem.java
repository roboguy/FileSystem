package edu.utdallas.aos.p3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class FileSystem {

	ArrayList<String> listOfFiles=new ArrayList<String>();
	public String read(String fileName)
	{
		String path="/root0/"+fileName;
		try {
			FileReader f=new FileReader(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
