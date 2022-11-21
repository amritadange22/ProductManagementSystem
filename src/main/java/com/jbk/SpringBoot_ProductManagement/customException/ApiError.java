package com.jbk.SpringBoot_ProductManagement.customException;

import java.util.List;

public class ApiError {
	private String errorMsg;
	private List<String> list;
	
	public ApiError() {
		// TODO Auto-generated constructor stub
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
	

}
