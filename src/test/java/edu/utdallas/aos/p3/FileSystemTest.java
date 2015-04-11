package edu.utdallas.aos.p3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class FileSystemTest {
	
	/*
	 * A Test Case
	 */
	@Test
	public void testSomething(){
		FileSystem fs=new FileSystem("root0");
		String output=fs.read("1.txt");
		System.out.println(output);
		assertEquals(output, "Hello");
		/*
		 * Create some mock objects
		 * Check if one or two methods work correctly 
		 * use assertEquals();
		 */
	}

	@Test
	public void testSomethingElse(){
		/*
		 * Create some mock objects
		 * Check some other methods work correctly 
		 * use assertEquals();
		 */
		FileSystem fs=new FileSystem("root0");
		fs.write("2.txt","abc");
	}
	@Test
	public void testListOfFiles()
	{
		FileSystem f=new FileSystem("root1");
		ArrayList<String> output=f.getListOfFile();
		for(String s:output)
			System.out.println(s);
		
	}
}
