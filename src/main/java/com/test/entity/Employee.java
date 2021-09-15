package com.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "EMPLOYEES")

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3821786915676097367L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "DESIGNATION")
	private String designation;
}
