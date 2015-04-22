package edu.utdallas.aos.p3;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.utdallas.aos.p3.filesystem.FileInfo;
import edu.utdallas.aos.p3.filesystem.FileSystemHandler;

public class KeySetTest {
	@Test
	public void testKeySet(){
		FileInfo defaultInformation = FileInfo.getDefaultInformation(2, 0);
		FileSystemHandler fsHandler = null;
		try {
			fsHandler = new FileSystemHandler("root0", defaultInformation);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int size = fsHandler.getReplicatedFiles().size();
		String[] files = fsHandler.getReplicatedFiles().keySet().toArray(new String[size]);
		for(String name : files){
			System.out.println(name);
		}
	}
}
