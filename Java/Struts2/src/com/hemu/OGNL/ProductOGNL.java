package com.hemu.OGNL;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class ProductOGNL implements RequestAware, SessionAware {
	private Integer productId;
	private String productName;
	private String productDesc;
	private Double productPrice;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", productPrice=" + productPrice + "]";
	}

	public String testTag(){
		this.productId = 1001;
		this.productDesc="Intel";
		this.productName="CPU";
		this.productPrice = 1200.00;
		return "success";
	}

	public String save(){
		System.out.println("save" + this);

		ValueStack valueStack = ActionContext.getContext().getValueStack();
		Test object = new Test();
		object.setProductName("aaa");
		object.setProductDesc("bbb");

		valueStack.push(object);

		sessionMap.put("product", this);
		requestMap.put("test", object);

//		int a = 10/0;

		return "details";
	}

	private Map<String, Object> sessionMap;
	private Map<String, Object> requestMap;
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.requestMap = arg0;

	}

}
