package com.jsp.medlife.Model.Entities;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int user_id;
	
	private String username;
    private String email;
	private String password;
	private int age;
	private String gender;
	private long phno;
	private String intrested;
	
	@OneToOne( cascade =CascadeType.ALL )
	@JoinColumn(name="add_Id")
	private Address address;

}
