package com.company.chainofresponsibility;
//处理者
public interface Handler {
	int handleRequest(int n);
	void setNextHandler(Handler next);
}
