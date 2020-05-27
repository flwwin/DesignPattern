package com.company.strategy;
//环境
public class SaveClient {
	private ISaveData saveData;
	SaveClient(ISaveData saveData){
		this.saveData = saveData;
	}
	void setSaveData(ISaveData saveData){
		this.saveData = saveData;
	}
	public void save(Object data){
		saveData.save(data);
	}
}
