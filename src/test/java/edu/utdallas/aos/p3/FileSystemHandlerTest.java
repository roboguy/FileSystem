package edu.utdallas.aos.p3;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import org.junit.Test;

import edu.utdallas.aos.p3.filesystem.FileInfo;
import edu.utdallas.aos.p3.filesystem.FileSystemHandler;

public class FileSystemHandlerTest {
	
	@Test
	public void testFSHandler(){
		
		FileInfo info = FileInfo.getDefaultInformation(1, 0);
		FileSystemHandler fsHandler = null;
		try {
			fsHandler = new FileSystemHandler("root0", info);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		FileInfo info1 = fsHandler.getReplicatedFiles().get("1.txt");
		System.out.println(info1.getIsQuorumAcquired());
		try {
			System.out.println(fsHandler.getFilesystem().read("1.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
}
