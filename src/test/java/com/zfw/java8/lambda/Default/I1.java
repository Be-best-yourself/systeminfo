package com.zfw.java8.lambda.Default;
/**
 * 因为接口有这个语法限制，所以要直接改变/扩展接口内的方法变得非常困难。
 * 我们在尝试强化Java 8 Collections API，让其支持lambda表达式的时候，就面临了这样的挑战。
 * 为了克服这个困难，Java 8中引入了一个新的概念，叫做default方法，也可以称为Defender方法，或者虚拟扩展方法（Virtual extension methods)。
 * Default方法是指，在接口内部包含了一些默认的方法实现（也就是接口中可以包含方法体，这打破了Java之前版本对接口的语法限制），从而使得接口在进行扩展的时候，不会破坏与接口相关的实现类代码
 * 
 * 如果一个类实现了两个接口（可以看做是“多继承”），这两个接口又同时都包含了一个名字相同的default方法
 * 
 * 会得到一个编译器错误，因为编译器不知道应该在两个同名的default方法中选择哪一个，因此产生了二义性。
 * 
 * @author zhang
 *
 */
public interface I1 {
	public void method1();
	default void method2(){
		System.out.println("测试java8接口新特性:default");
	}
}
