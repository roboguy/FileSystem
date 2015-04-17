package edu.utdallas.aos.p3.filesystem;

import java.util.concurrent.ConcurrentHashMap;

/*
 * Replication Handler For the fileSystem
 */

public class FileSystemHandler {
	
	FileSystem filesystem;
	ConcurrentHashMap<String, FileInfo> replicatedFiles = new ConcurrentHashMap<>();
	
	public FileSystemHandler(String root, FileInfo defaultInformation){
		filesystem = new FileSystem(root);
		for(String fileName : filesystem.getListOfFile()){
			replicatedFiles.put(fileName, defaultInformation);
		}
	}
	
}
