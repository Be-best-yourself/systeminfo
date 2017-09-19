package com.zfw.test;

import java.util.Properties;
import java.util.Set;

public class TestPath {
	public static void main(String[] args) {
		Properties pros = System.getProperties();
		Set<Object> keySet = pros.keySet();
		for (Object object : keySet) {
			System.out.println(object+"======="+pros.get(object));;
		}
		System.out.println(System.getProperty("java.library.path"));
	}
}
