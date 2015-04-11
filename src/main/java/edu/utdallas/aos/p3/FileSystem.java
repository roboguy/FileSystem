package edu.utdallas.aos.p3;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileSystem {
	
	static final Logger logger = LogManager.getLogger(FileSystem.class);
	File []listOfFiles=null;
	String rootFolderPath="";
	//gets the OS based delimiter
	String fileDelimiter=System.getProperty("file.separator");
	FileSystem(String root)
	{
		File rootFolder=new File(root);
		listOfFiles=rootFolder.listFiles();
		this.rootFolderPath=root;
		try
		{
			if(listOfFiles==null)
				throw new NullPointerException();
			if(listOfFiles.length==0)
				throw new Exception();
		}
		catch(NullPointerException n)
		{
			logger.error("The directory: "+rootFolder+" does not exist ");
			//System.out.println("The directory: "+rootFolder+" does not exist ");
		}
		catch(Exception e)
		{
			logger.error("There are no files in the directory "+rootFolder);
			//System.out.println("There are no files in the directory "+rootFolder);
		}
		
	}
	public String read(String fileName) 
	{
		//rootFolderPath has the root information
		String path=rootFolderPath+fileDelimiter+fileName;
		Scanner scan = null;
		String line ="";
		try {
			scan = new Scanner(new File(path));
			line=scan.nextLine();
			
		} catch (FileNotFoundException e) {
			logger.error("The absolute file path: "+path+" was not found");
			//System.out.println("The absolute file path: "+path+" was not found");
			//e.printStackTrace();
		}
		catch(NoSuchElementException e)
		{
			logger.error("No line found in the file");
			//System.out.println("No line found in the file");
		}
		finally{
			scan.close();
		}
		return line;
		
	}
	
	public void write(String fileName,String data)
	{
		//path of the file
		String filepath=rootFolderPath+fileDelimiter+fileName;
		FileWriter f=null;
		try {
			//Check whether File Exists
			if(new File(filepath).exists())
			{
				f=new FileWriter(filepath);
				//check data standard
				if(data==null)
					try {
						throw new Exception();
					} catch (Exception e) {
						logger.error("Check the data while Writing to a File: "+filepath);
						//System.out.println("Check the data while Writing to a File: "+filepath);
						
					}
				//write to data only if we are done with all check
				f.write(data);
				
			}
			else
				throw new FileNotFoundException();
		
		
		}
		catch (FileNotFoundException e) 
		{
			logger.error("File does not exist for writing at absolute path:"+filepath);
			//System.out.println("File does not exist for writing at absolute path:"+filepath);
		}
		catch (IOException e) {
		
			e.printStackTrace();
		}
		finally{
			try {
				f.close();
			} catch (IOException e) {
				logger.error("File close did not happen properly in finally()");
				//System.out.println("File close did not happen properly in finally()");
				//e.printStackTrace();
			}
		}
	}
	public ArrayList<String> getListOfFile()
	{
		ArrayList<String> list=new ArrayList<String>();
		for(File f: listOfFiles)
			list.add(f.getAbsolutePath());
		return list;
	}
}
