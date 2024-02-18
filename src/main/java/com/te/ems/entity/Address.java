package com.te.ems.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data   -> doesn't contain no arg & all arg constructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@EqualsAndHashCode
//@ToString
@Builder
@Entity
@Table(name = "address_tbl")
public class Address {
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int addressId;
	
	@Column(name = "address_city")
	private String addressCity;
	
	@Column(name = "addres_state")
	private String addressState;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_fk")
	private Employee employee;
	
}
