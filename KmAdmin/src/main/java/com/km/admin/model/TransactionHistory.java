package com.km.admin.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class TransactionHistory {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tid;

	@Column(name = "content_id")
	private Integer cId;
	
	@Column(name = "className")
	private String modifiedClass;
	
	 
	 @Column(updatable = false)
	 private String updatedBy;
	 
	 
	 @Column(nullable = false)
	 private Instant updatedAt;


	public TransactionHistory() {
		super();
	}


	public TransactionHistory(Integer cId, String modifiedClass, String updatedBy, Instant updatedAt) {
		super();
		this.cId = cId;
		this.modifiedClass = modifiedClass;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
	}


	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public Integer getcId() {
		return cId;
	}


	public void setcId(Integer cId) {
		this.cId = cId;
	}


	public String getModifiedClass() {
		return modifiedClass;
	}


	public void setModifiedClass(String modifiedClass) {
		this.modifiedClass = modifiedClass;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Instant getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}


	@Override
	public String toString() {
		return "TransactionHistory [tid=" + tid + ", cId=" + cId + ", modifiedClass=" + modifiedClass + ", updatedBy="
				+ updatedBy + ", updatedAt=" + updatedAt + "]";
	}

	

	


}
