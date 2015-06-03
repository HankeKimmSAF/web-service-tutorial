package org.hanke.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Column(name="firstName", columnDefinition="VarChar(45)")
	private String firstName;
	
	@NotNull
	@Column(name="lastName", columnDefinition="VarChar(45)")
	private String lastName;
	
	public Employee() {
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}