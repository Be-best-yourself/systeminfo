package com.zfw.java8.lambda.Default;

public class test {
	public static void main(String[] args) {
		I1 i1=new I1Imp();
		i1.method1();
		i1.method2();
		System.out.println("---------------------------");
		I1 i2=new I1() {
			@Override
			public void method1() {
				System.err.println("method1");
			}
		};
		i2.method1();
		i2.method2();
	}
}
