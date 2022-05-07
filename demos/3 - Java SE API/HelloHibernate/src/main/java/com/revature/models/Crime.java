package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//JPA is the Java Persistence API
//This API allows us access to annotations that can map our fields to DB columns and constraints

@Entity
@Table(name="crimes") //now the table will show up as 'crimes' instead of 'crime' (the name of the class) in the database
public class Crime {
	
	@Id //specifies this field as a primary key
	@Column(name="crime_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //this is equivalent to the SERIAL keyword in SQL
	private int crimeId;
	
	@Column(name="crime_name", unique=true, nullable=false) //similar to adding UNIQUE NOT NULL constraint in SQL
	private String crimeName;
	
	//this will automatically be created as a column called "description" in the database
	private String description;

	public Crime() {
		super();
	}

	public Crime(String crimeName, String description) {
		super();
		this.crimeName = crimeName;
		this.description = description;
	}

	public Crime(int crimeId, String crimeName, String description) {
		super();
		this.crimeId = crimeId;
		this.crimeName = crimeName;
		this.description = description;
	}

	public int getCrimeId() {
		return crimeId;
	}

	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}

	public String getCrimeName() {
		return crimeName;
	}

	public void setCrimeName(String crimeName) {
		this.crimeName = crimeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(crimeId, crimeName, description);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crime other = (Crime) obj;
		return crimeId == other.crimeId && Objects.equals(crimeName, other.crimeName)
				&& Objects.equals(description, other.description);
	}

	@Override
	public String toString() {
		return "Crime [crimeId=" + crimeId + ", crimeName=" + crimeName + ", description=" + description + "]";
	}
}
