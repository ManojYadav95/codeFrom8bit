package com.Stream.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Test2 {

	public static void main(String[] args) {

		List<String> nums = Arrays.asList(new String[] {"10","50","13","16"});
	
		int n = nums.size();
		OptionalInt res = nums.stream().mapToInt(d->Integer.parseInt(d)).sorted().skip(n-2).findFirst();
		if(res.isPresent()) {
			System.out.println(res.getAsInt());
			
		} else {
			System.out.println("No Number Found");
		}
		//nums.stream().map(n->n+"").filter(n->n.startsWith("1")).forEach(System.out::println);
	}

}
