package com.hcsc.cssui.model;

import java.util.Date;

import com.hcsc.cssui.model.type.CorporateEntityCode;

public class Liability {
	private Long id;
	private CorporateEntityCode corpEntCd;
	private String hcscSubscriber;
	private String qhpid;
	private Date serviceFrom;
	private Double amount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CorporateEntityCode getCorpEntCd() {
		return corpEntCd;
	}
	public void setCorpEntCd(CorporateEntityCode corpEntCd) {
		this.corpEntCd = corpEntCd;
	}
	public String getHcscSubscriber() {
		return hcscSubscriber;
	}
	public void setHcscSubscriber(String hcscSubscriber) {
		this.hcscSubscriber = hcscSubscriber;
	}
	public String getQhpid() {
		return qhpid;
	}
	public void setQhpid(String qhpid) {
		this.qhpid = qhpid;
	}
	public Date getServiceFrom() {
		return serviceFrom;
	}
	public void setServiceFrom(Date serviceFrom) {
		this.serviceFrom = serviceFrom;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}