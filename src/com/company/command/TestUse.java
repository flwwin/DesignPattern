package com.company.command;

/**
 * 命令模式：将一个请求封装成一个对象，从而使您可以用不同的请求对客户进行参数化。
 * 通过调用者调用接受者执行命令，顺序：调用者→接受者→命令。
 * 将命令调用者和命令执行者通过接受命令解耦合，增加系统的可拓展性
 *
 *
 */
public class TestUse {
	public static void main(String args[]) throws Exception{
		//接收者
		MakeFile makeFile = new MakeFile();
		//命令
		CommandCreate create = new CommandCreate(makeFile);
		CommandDelete delete = new CommandDelete(makeFile);
		//请求者
		Client client = new Client();
		//执行命令
		client.setCommand(create).executeCommand("d://test1.txt");
		client.setCommand(create).executeCommand("d://test2.txt");
		client.setCommand(delete).executeCommand("d://test2.txt");
	}
}