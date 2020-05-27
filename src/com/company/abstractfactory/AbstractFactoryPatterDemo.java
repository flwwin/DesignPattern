package com.company.abstractfactory;

/**
 * 抽象工厂模式：
 *  主要解决：接口的选择问题
 *  何时使用：系统中有多个产品族，只需使用其中一个产品族
 *  优点：当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。
 *	缺点：产品族扩展非常困难，要增加一个系列的某一产品，既要在抽象的 producer 里加代码，又要在具体的里面加代码。
 *	应用举例：
 */
//抽象工厂模式
public class AbstractFactoryPatterDemo {
	public static void main(String args[]){
		AbstractFactory phonefactory = FactoryProducer.getFactory("phone");
		AbstractFactory headSetfactory = FactoryProducer.getFactory("headSet");
		phonefactory.producePhone("mx5").run();
		phonefactory.producePhone("PRO5").run();
		headSetfactory.produceHeadset("EP21").play();
		headSetfactory.produceHeadset("EP30").play();
	}
}

//抽象产品*2
interface Headset{
	void play();
}

//抽象产品
interface MeizuPhone{
	void run();
}

//具体产品*2*2
class PRO5 implements MeizuPhone{
	@Override
	public void run() {
		System.out.println("我是一台PRO5");
	}
}

class MX5 implements MeizuPhone{
	@Override
	public void run() {
		System.out.println("我是一台MX5");
	}
}

class EP21 implements Headset{
	@Override
	public void play() {
		System.out.println("我是一副EP21");
	}
}

class EP30 implements Headset{
	@Override
	public void play() {
		System.out.println("我是一副EP30");
	}
}

//抽象工厂
 abstract class AbstractFactory{
	abstract MeizuPhone producePhone(String type);
	abstract Headset produceHeadset(String type);
}

//具体工厂(手机)
class PhoneFactory extends AbstractFactory{
	@Override
	MeizuPhone producePhone(String type) {
		if (type == null) return  null;
		if (type.equalsIgnoreCase("MX5")) return new MX5();
		else if (type.equalsIgnoreCase("PRO5")) return new PRO5();
		return null;
	}

	@Override
	Headset produceHeadset(String type) {
		return null;
	}
}

//具体工厂（耳机）
class HeadSetFactory extends AbstractFactory{
	@Override
	MeizuPhone producePhone(String type) {
		return null;
	}

	@Override
	Headset produceHeadset(String type) {
		if (type == null) return  null;
		if (type.equalsIgnoreCase("EP21")) return new EP21();
		else if (type.equalsIgnoreCase("EP30")) return new EP30();
		return null;
	}
}

//工厂创造类
class FactoryProducer{
	public static AbstractFactory getFactory(String choice){
		if ("phone".equalsIgnoreCase(choice)){
			return new PhoneFactory();

		}else if ("headSet".equalsIgnoreCase(choice)){
			return new HeadSetFactory();
		}
		return null;
	}
}