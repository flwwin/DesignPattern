package com.company.chainofresponsibility;

/**
 * 责任链模式：避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求，将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。
 * 优点：
 * 1、降低耦合度。它将请求的发送者和接收者解耦。
 * 2、简化了对象。使得对象不需要知道链的结构。
 * 3、增强给对象指派职责的灵活性。通过改变链内的成员或者调动它们的次序，允许动态地新增或者删除责任。
 * 4、增加新的请求处理类很方便。
 *
 * 缺点： 1、不能保证请求一定被接收。
 *       2、系统性能将受到一定影响，而且在进行代码调试时不太方便，可能会造成循环调用。
 *       3、可能不容易观察运行时的特征，有碍于除错。
 */
public class TestUse {
	public static void main(String args[]){
		Handler h1,h2,h3;
		h1 = new Handler1();
		h2 = new Handler2();
		h3 = new Handler3();
		h1.setNextHandler(h2);
		h2.setNextHandler(h3);
		System.out.println(h1.handleRequest(-1));
		System.out.println(h1.handleRequest(5));
		System.out.println(h1.handleRequest(9999));
	}
}