package com.newproject.Helper;

public class descHelper {
	
	public static String get10words(String desc) {
		
		String[] str = desc.split(" ");
		
		if(str.length > 10) {
			String res = "";
			for(int i=0; i<10; i++) {
				res += str[i]+" ";
			}
			return (res+"...");
		}
		
		return (desc+"...");
	}
}
