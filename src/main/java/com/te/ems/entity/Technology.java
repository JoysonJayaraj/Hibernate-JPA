package com.te.ems.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@EqualsAndHashCode
//@ToString
@Builder
@Entity
@Table(name = "technology_tbl")
public class Technology {
	@Column(name = "technology_name")
	@Id
	private String technologyName;
	
	@ManyToMany(mappedBy = "technologies",cascade = CascadeType.ALL)
	private List<Employee> employees;
}
