package com.company.adapter;

/**
 * 适配器模式：适配器作为两个不兼容的接口之间的桥梁，有类适配器，和对象适配器
 * 主要解决在软件系统中，常常要将一些"现存的对象"放到新的环境中，而新环境要求的接口是现对象不能满足的。
 * 适配器继承或依赖已有的对象，实现想要的目标接口
 */
public class TestUse {
	public static void main(String args[]){
		Adaptee adaptee = new Adaptee();
		adaptee.playMp3("mp3");
		Target target = new ClassAdapter();
		target.playFlac("flac");
		target = new ObjectAdapter();
		target.playFlac("flac");
	}
}