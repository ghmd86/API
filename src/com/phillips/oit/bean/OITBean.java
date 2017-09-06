package com.phillips.oit.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "oitdata")
public class OITBean {
	@Id
	@Column(name = "sno")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int id;
	@Column(name = "SrNo")
	private int sNo;
	@Column(name = "OITMonth")
	private String month;
	@Column(name = "OrderWeek")
	private String orderWeek;
	@Column(name = "SAP")
	private String sap;
	@Column(name = "PONo")
	private String pONo;
	@Column(name = "PODate")
	private String pODate;
	@Column(name = "EQ")
	private double eQ;
	@Column(name = "3rdParty")
	private double thirdParty;
	@Column(name = "Extwarranty")
	private double extWarranty;
	@Column(name = "BU")
	private String bu;
	@Column(name = "payingCustomer")
	private String payingCustomer;
	@Column(name = "AccMgr")
	private String accManager;
	@Column(name = "Comments")
	private String comments;
	@Column(name = "OrderType")
	private String orderType;
	@Column(name = "Sofon")
	private String sofon;
	@Column(name = "SFDC")
	private String sfdc;
	@Column(name = "RDD")
	private String RDD;
	@Column(name = "CDD")
	private String cdd;
	@Column(name = "comment")
	private String comment;	
	@Column (name="status")
	private boolean status;
	@Column(name="orderby")
	private int order;
	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getOrderWeek() {
		return orderWeek;
	}

	public void setOrderWeek(String orderWeek) {
		this.orderWeek = orderWeek;
	}

	public String getSap() {
		return sap;
	}

	public void setSap(String sap) {
		this.sap = sap;
	}

	public String getpONo() {
		return pONo;
	}

	public void setpONo(String pONo) {
		this.pONo = pONo;
	}

	public String getpODate() {
		return pODate;
	}

	public void setpODate(String pODate) {
		this.pODate = pODate;
	}

	public double geteQ() {
		return eQ;
	}

	public void seteQ(double eQ) {
		this.eQ = eQ;
	}

	public double getThirdParty() {
		return thirdParty;
	}

	public void setThirdParty(double thirdParty) {
		this.thirdParty = thirdParty;
	}

	public double getExtWarranty() {
		return extWarranty;
	}

	public void setExtWarranty(double extWarranty) {
		this.extWarranty = extWarranty;
	}

	public String getBu() {
		return bu;
	}

	public void setBu(String bu) {
		this.bu = bu;
	}

	public String getPayIngCustomer() {
		return payingCustomer;
	}

	public void setPayIngCustomer(String payIngCustomer) {
		this.payingCustomer = payIngCustomer;
	}

	public String getAccManager() {
		return accManager;
	}

	public void setAccManager(String accManager) {
		this.accManager = accManager;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getSofon() {
		return sofon;
	}

	public void setSofon(String sofon) {
		this.sofon = sofon;
	}

	public String getSfdc() {
		return sfdc;
	}

	public void setSfdc(String sfdc) {
		this.sfdc = sfdc;
	}

	public String getRDD() {
		return RDD;
	}

	public void setRDD(String rDD) {
		RDD = rDD;
	}

	public String getCdd() {
		return cdd;
	}

	public void setCdd(String cdd) {
		this.cdd = cdd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayingCustomer() {
		return payingCustomer;
	}

	public void setPayingCustomer(String payingCustomer) {
		this.payingCustomer = payingCustomer;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
}
