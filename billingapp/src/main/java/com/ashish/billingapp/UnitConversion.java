package com.ashish.billingapp;

public class UnitConversion {
	private int convid;
	private String fromconv;
	private String toconv;
	public int getConvid() {
		return convid;
	}
	public void setConvid(int convid) {
		this.convid = convid;
	}
	public String getFromconv() {
		return fromconv;
	}
	public void setFromconv(String fromconv) {
		this.fromconv = fromconv;
	}
	public String getToconv() {
		return toconv;
	}
	public void setToconv(String toconv) {
		this.toconv = toconv;
	}
	public double getMultiplicationfactor() {
		return multiplicationfactor;
	}
	public void setMultiplicationfactor(double multiplicationfactor) {
		this.multiplicationfactor = multiplicationfactor;
	}
	private double multiplicationfactor;
	
/*public UnitConversion(int convid,String fromconv,String toconv,double multiplicationfactor) {
	this.convid=convid;
	this.fromconv=fromconv;
	this.toconv=toconv;
	this.multiplicationfactor=multiplicationfactor;
}
*/
}
