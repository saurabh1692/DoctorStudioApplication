package com.ashish.billingapp;

public class GstInsert {
	private String gstid;
	private String gstdesc;
	private double gstper;
	private String gststartdate;
	private String gstenddate;
	private double igst;
	private double cgst;
	private double sgst;
	public String getGstid() {
		return gstid;
	}
	public void setGstid(String gstid) {
		this.gstid=gstid;
	} 
	public String getGstdesc() {
		return gstdesc;
	}
	public void setGstdesc(String gstdesc) {
		this.gstdesc = gstdesc;
	}
	public double getGstper() {
		return gstper;
	}
	public void setGstper(double gstper) {
		this.gstper = gstper;
	}
	public String getGststartdate() {
		return gststartdate;
	}
	public void setGststartdate(String gststartdate) {
		this.gststartdate = gststartdate;
	}
	public String getGstenddate() {
		return gstenddate;
	}
	public void setGstenddate(String gstenddate) {
		this.gstenddate = gstenddate;
	}
	public double getIgst() {
		return igst;
	}
	public void setIgst(double igst) {
		this.igst = igst;
	}
	public double getCgst() {
		return cgst;
	}
	public void setCgst(double cgst) {
		this.cgst = cgst;
	}
	public double getSgst() {
		return sgst;
	}
	public void setSgst(double sgst) {
		this.sgst = sgst;
	}


}
