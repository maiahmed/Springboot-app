package com.ntg.SpringBootApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "services")
public class Services implements Serializable{
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique=true, nullable=false)
	private long id;

	@Column(name = "employee_id")
	private long employee_id;

	@Column(name = "calls_bundle")
	private int calls_bundle;
	

	@Column(name = "data_bundle")
	private int data_bundle;
	
	@Column(name = "roaming_bundle")
	private int roaming_bundle;
	
	
	@Column(name = "sms_bundle")
	private int sms_bundle;
	
	
	
	
	public Services() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public int getcalls_bundle() {
		return calls_bundle;
	}
	public void setcalls_bundle(int calls_bundle) {
		this.calls_bundle = calls_bundle;
	}
	public int getsms_bundle() {
		return sms_bundle;
	}
	public void setsms_bundle(int sms_bundle) {
		this.sms_bundle = sms_bundle;
	}
	public int getroaming_bundle() {
		return roaming_bundle;
	}
	public void setroaming_bundle(int roaming_bundle) {
		this.roaming_bundle = roaming_bundle;
	}
	public int getdata_bundle() {
		return data_bundle;
	}
	public void setdata_bundle(int data_bundle) {
		this.data_bundle = data_bundle;
	}
	public Services(long id, long employee_id, int calls_bundle, int sms_bundle,
			int roaming_bundle, int data_bundle) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.calls_bundle = calls_bundle;
		this.data_bundle = data_bundle;
		this.roaming_bundle = roaming_bundle;
		this.sms_bundle = sms_bundle;
	}
	
	
}
