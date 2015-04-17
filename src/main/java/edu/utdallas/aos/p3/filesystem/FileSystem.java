package edu.utdallas.aos.p3.filesystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileSystem {

	static final Logger logger = LogManager.getLogger(FileSystem.class);
	File[] listOfFiles = null;
	String rootFolderPath = "";

	// gets the OS based delimiter
	String fileDelimiter = System.getProperty("file.separator");

	public FileSystem(String root) {
		File rootFolder = new File(root);
		boolean rootFolderExists = rootFolder.exists();

		if (rootFolderExists) {
			listOfFiles = rootFolder.listFiles();
			this.rootFolderPath = root;
		} else {
			logger.error("The directory: " + rootFolder + " does not exist ");
		}
		if (listOfFiles.length < 1) {
			logger.error("There are no files in the directory " + rootFolder);
		}

	}

	public String read(String fileName) throws FileNotFoundException, NoSuchElementException {
		// rootFolderPath has the root information
		String path = rootFolderPath + fileDelimiter + fileName;
		Scanner scanner = null;
		String line = "";
		scanner = new Scanner(new File(path));
		line = scanner.nextLine();
		scanner.close();
		return line;

	}

	public void write(String fileName, String data) throws IOException {
		// path of the file
		String filepath = rootFolderPath + fileDelimiter + fileName;
		File file = new File(filepath);
		
		if(!file.exists()){
			logger.error("File Not found.");
			throw new FileNotFoundException("File at " + filepath + " not found.");
		}
		
		if(data == null){
			data = "";
			logger.warn("Writing empty line to file.");
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
		try{
			writer.write(data);
		} catch(IOException execption) {
			throw execption;
		} finally {
			writer.close();
		}
	}

	public ArrayList<String> getListOfFile() {
		ArrayList<String> list = new ArrayList<String>();
		for (File f : listOfFiles)
			list.add(f.getAbsolutePath());
		return list;
	}
}
