package com.zpy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Teacher {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String tno;

	public Teacher(){}
	
	public Teacher(String name, String tno) {
		this.name = name;
		this.tno = tno;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}
	
}
