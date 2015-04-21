package edu.utdallas.aos.p3;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import edu.utdallas.aos.p3.filesystem.P;

@SuppressWarnings("all")
public class PTest {
	
	@Test
	public void testEqualsHashCode(){
		P p1 = new P("1", 0, 5, "Some Content");
		Map<String, P> pMap = new LinkedHashMap<>();
		pMap.put("1", p1);
		
		P p2 = new P("1", 2, 10, "Some other content");
		
		boolean contains = pMap.containsKey("1");
		assertEquals(true, contains);
		
		P p3 = new P("2", 3, 7, "Invalid content");
		boolean notContains = pMap.containsKey("2");
		assertEquals(false, notContains);
	}

}
