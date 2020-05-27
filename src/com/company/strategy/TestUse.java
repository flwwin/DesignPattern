package com.company.strategy;

/**
 * 策略模式：定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。一个系统有许多许多类，而区分它们的只是他们直接的行为。
 * 优点： 1、算法可以自由切换。 2、避免使用多重条件判断。3、扩展性良好。
 * 缺点： 1、策略类会增多。 2、所有策略类都需要对外暴露。
 * 应用举例：
 */
public class TestUse {
	public static void main(String args[]){
		Object data = "数据";
		ISaveData saveData = new SaveToRedis();
		SaveClient client = new SaveClient(saveData);
		client.save(data);
		client.setSaveData(new SaveToFile());
		client.save(data);
		client.setSaveData(new SaveToMysql());
		client.save(data);
	}
}