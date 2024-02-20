package testCases.Demos.DemoPractice.Collections;

import java.util.HashMap;
import java.util.Map;

/*
 * declare HASHMAP
add pairs to hashmap
remove pairs from hashmap
read pairs from hashmap
 */

public class HashMapdemo {

	public static void main(String[] args) {
		
		HashMap <Integer,String>hm=new HashMap<Integer,String>(); //Declaration

		//adding pairs to HashMap
		hm.put(101,"John");
		hm.put(102,"David");
		hm.put(103,"Smith");
		hm.put(104,"Scott");
		hm.put(105,"Kim");
		
		System.out.println(hm);
		
		//Remove a pair from Hashmap
		hm.remove(103);
		System.out.println(hm);//new pairs after deletion
		
		//How to read pairs from HashMap
		for(Map.Entry m:hm.entrySet())
		{
			System.out.println(m.getKey()+"   "+m.getValue());
			
		}
		
		
	}

}
