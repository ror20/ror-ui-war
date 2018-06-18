package com.ror.model;

public class StoreRORUser {
	
	private String storeStatus;
	private boolean storeFlag;

	public StoreRORUser(){
		
	}
	
	public StoreRORUser(String storeStatus, boolean storeFlag) {
		super();
		this.storeStatus = storeStatus;
		this.storeFlag = storeFlag;
	}

	public String getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(String storeStatus) {
		this.storeStatus = storeStatus;
	}

	public boolean isStoreFlag() {
		return storeFlag;
	}

	public void setStoreFlag(boolean storeFlag) {
		this.storeFlag = storeFlag;
	}

	@Override
	public String toString() {
		return "StoreRORUser [storeStatus=" + storeStatus + ", storeFlag=" + storeFlag + "]";
	}

}
