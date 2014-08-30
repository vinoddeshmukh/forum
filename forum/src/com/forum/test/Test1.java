package com.forum.test;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEST1")
public class Test1 {

	@Id
	@Column(name="COLUMN1")
	private String column1;
	
	//@Id
	@Column(name="COLUMN2")
	private String column2;
	
	//@Id
	@Column(name="COLUMN3")
	private String column3;
	
	//@Id
	@Column(name="COLUMN4")
	private String column4;
	
	@Column(name="COLUMN5")
	private String column5;
	
	@Column(name="COLUMN6")
	private String column6;
	
	
	@ManyToMany//(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="TEST1", 
            joinColumns={@JoinColumn(name="COLUMN1")}, 
            inverseJoinColumns={@JoinColumn(name="COLUMN4")})
	private List<Test2> test2;

	public String getColumn1() {
		return column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public String getColumn2() {
		return column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}

	public String getColumn3() {
		return column3;
	}

	public void setColumn3(String column3) {
		this.column3 = column3;
	}

	public String getColumn4() {
		return column4;
	}

	public void setColumn4(String column4) {
		this.column4 = column4;
	}

	public String getColumn5() {
		return column5;
	}

	public void setColumn5(String column5) {
		this.column5 = column5;
	}

	public String getColumn6() {
		return column6;
	}

	public void setColumn6(String column6) {
		this.column6 = column6;
	}

	public List<Test2> getTest2() {
		return test2;
	}

	public void setTest2(List<Test2> test2) {
		this.test2 = test2;
	}

}
