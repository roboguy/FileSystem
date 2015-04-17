package edu.utdallas.aos.p3;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.Test;

import edu.utdallas.aos.p3.filesystem.FileSystem;

/**
 * Unit test for simple App.
 */
public class FileSystemTest {

	/*
	 * A Test Case
	 */
	@Test
	public void testRead() {
		FileSystem fs = new FileSystem("root0");
		String output = null;
		try {
			output = fs.read("1.txt");
		} catch (FileNotFoundException | NoSuchElementException e) {

			e.printStackTrace();
		}
		System.out.println(output);
		assertEquals(output, "Hello");
	}

	@Test
	public void testWrite() {

		FileSystem fs = new FileSystem("root0");
		String readLine = null;
		try {
			fs.write("2.txt", "abc");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			readLine = fs.read("2.txt");
		} catch (FileNotFoundException | NoSuchElementException e) {
			e.printStackTrace();
		}
		readLine = readLine.trim();
		System.out.println(readLine);
		assertEquals("abc", readLine);
	}

	@Test
	public void testListOfFiles() {
		FileSystem f = new FileSystem("root0");
		ArrayList<String> output = f.getListOfFile();
		for (String s : output)
			System.out.println(s);

	}
}
