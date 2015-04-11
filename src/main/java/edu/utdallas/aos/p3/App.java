package edu.utdallas.aos.p3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Library Project Template that uses Maven
 * To Compile Library Code:
 * mvn clean compile package
 * This command packages a JAR (see pom.xml -> packaging node) in target directory
 * 
 * To Compile with Dependency JAR's included (Not Necessary for Library code)
 * mvn clean compile assembly:single
 * Creates a runnable JAR with Main class specified in pom.xml (check manifest->mainClass nodes in pom.xml)
 *
 *
 * Your choice to use version control or not (comitting changes to a private Git Repo is always a good idea :)
 */
public class App 
{
	/*
	 * How to use Logger. We are using Log4j2 v4.11 (Prior versions have different Logging API's)
	 */
	static final Logger logger = LogManager.getLogger(App.class);
	
	/*
	 * There will be no main method in Library code, instead use unit testing classes 
	 * check src/test for example. 
	 */
	public static void main( String[] args )
    {
		/*
		 * Running this application prints log messages TWO times to console. ?
		 */
		
		logger.trace("Starting Main method..");
		System.out.println("Hello World!");
		logger.debug("Printed a message to console");
		logger.trace("Exiting..");
    }

}
