package com.company.proxy;

/**
 * 代理模式，不直接访问对象通过代理对象访问。在代理对象中间层中可以加入需求的操作
 *
 */
public class TestUse {
	public static void main(String args[]){
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}