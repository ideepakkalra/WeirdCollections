/**
 * 
 */
package com.github.ideepakkalra.weirdcollections;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * @author Deepak
 *
 */
class LinkedArrayListTest {
	
	@Test
	void testArrayListFor10MillionElementAdd() {
		ArrayList<String> arrayList = new ArrayList<>();
		
		long startTime = System.currentTimeMillis();
		
		for (int i=0; i<2_000_000; i++) {
			arrayList.add("Old " + i);
		}
		/*arrayList.remove(50);
		arrayList.remove(500);
		arrayList.remove(5000);
		arrayList.remove(50000);
		arrayList.remove(500000);*/
		System.out.println(System.currentTimeMillis() - startTime);
	}

	@Test
	void testLinkedArrayListFor10MillionElementAdd() {
		LinkedArrayList<String> arrayList = new LinkedArrayList<>();
		
		long startTime = System.currentTimeMillis();
		
		for (int i=0; i<2_000_000; i++) {
			arrayList.add("New " + i);
		}
		
		System.out.println(System.currentTimeMillis() - startTime);
	}
}