package com.jbk.SpringBoot_ProductManagement.customException;

public class ErrorDetails {

	private String errorMsg;
	private String errorInDetail;
	
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(String errorMsg, String errorInDetail) {
		super();
		this.errorMsg = errorMsg;
		this.errorInDetail = errorInDetail;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorInDetail() {
		return errorInDetail;
	}

	public void setErrorInDetail(String errorInDetail) {
		this.errorInDetail = errorInDetail;
	}

	@Override
	public String toString() {
		return "ErrorDetails [errorMsg= " + errorMsg + ", Error In Detail= " + errorInDetail + "]";
	}
}
