package edu.utdallas.aos.p3.filesystem;

import java.io.FileNotFoundException;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Replication Handler For the fileSystem
 */

public class FileSystemHandler {
	
	FileSystem filesystem;
	ConcurrentHashMap<String, FileInfo> replicatedFiles = new ConcurrentHashMap<>();
	
	public FileSystemHandler(String root, FileInfo defaultInformation) throws FileNotFoundException{
		filesystem = new FileSystem(root);
		for(String fileName : filesystem.getListOfFile()){
			replicatedFiles.put(fileName, defaultInformation);
		}
	}

	public FileSystem getFilesystem() {
		return filesystem;
	}

	public ConcurrentHashMap<String, FileInfo> getReplicatedFiles() {
		return replicatedFiles;
	}
	
	
}
