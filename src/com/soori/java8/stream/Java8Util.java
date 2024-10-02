package com.soori.java8.stream;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Java8Util {
	
	public static BiConsumer<Integer, List<Address>> eIdAdressConsumer = (eId, addressList) -> {
		System.out.println("Empid=" + eId + " && Address PinCodes:"
				+ addressList.stream().map(Address::getPincode).collect(Collectors.joining(", ")));
	};
	
	
	
}
