package com.manage.student.bean;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/* 
 * It is not allowed to have @NotNull for a field which is also annotated to
 * auto increment using @GeneratedValue. Also we need to use integer as data type we cannot use String
 * 
 * @NotNull: The CharSequence, Collection, Map or Array object is not null, but
 * can be empty.
 * 
 * @NotEmpty: The CharSequence, Collection, Map or Array object is not null and
 * size > 0.
 * 
 * @NotBlank: The string is not null and the trimmed length is greater than
 * zero.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tab_student_detail")
public class Student {
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer registrationId;

	@NotBlank
	@Column(name = "student_name")
	@JsonProperty("sname")
	String name;

	@NotEmpty
	@Column(name = "student_email") 
	@JsonProperty("semail")
	@Email
	String email;

	@NotNull
	@Column(name = "student_contact_no")
	@JsonProperty("sphone")
	BigInteger phoneNo;

	@Column(name = "student_current_city")
	@JsonProperty("sccity")
	String currentCity;

	@Column(name = "student_hometown")
	@JsonProperty("shometown")
	String homeTown;
	
	@Column(name = "student_guide")
	@JsonProperty("sguide")
	String studentGuide;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable=false, updatable=false)
	@JsonProperty("createdAt")
	Date createdTimestamp;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	@JsonProperty("updatedAt")
	Date updatedTimestamp;
	
}
