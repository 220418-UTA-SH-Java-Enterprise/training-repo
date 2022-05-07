package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="super_villains")
public class SuperVillain {
	@Id
	@Column(name = "svill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int svillId;

	@Column(name = "svill_name", unique = true, nullable = false)
	private String svillName;

	@Column(name = "super_power")
	private String superPower;

	private double bounty; // this will automatically be generated as a column called "bounty"

	// separate joins table would best describe this relationship
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Lazy fetching means that the data won't be loaded
																	// into memory until we call getCrimes();
	private List<Crime> crimes;

	// This will be a foreign key pointing ot some record of a SuperPrison in our
	// SuperPrisons table
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "prison_fk")
	private SuperPrison superPrisonHolder; // this is a foreign key pointing to the super prison where the super villain

	public SuperVillain() {

	}

	public SuperVillain(String svillName, String superPower, double bounty, List<Crime> crimes,
			SuperPrison superPrisonHolder) {
		super();
		this.svillName = svillName;
		this.superPower = superPower;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}

	public SuperVillain(int svillId, String svillName, String superPower, double bounty, List<Crime> crimes,
			SuperPrison superPrisonHolder) {
		super();
		this.svillId = svillId;
		this.svillName = svillName;
		this.superPower = superPower;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}

	public int getSvillId() {
		return svillId;
	}

	public void setSvillId(int svillId) {
		this.svillId = svillId;
	}

	public String getSvillName() {
		return svillName;
	}

	public void setSvillName(String svillName) {
		this.svillName = svillName;
	}

	public String getSuperPower() {
		return superPower;
	}

	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}

	public double getBounty() {
		return bounty;
	}

	public void setBounty(double bounty) {
		this.bounty = bounty;
	}

	public List<Crime> getCrimes() {
		return crimes;
	}

	public void setCrimes(List<Crime> crimes) {
		this.crimes = crimes;
	}

	public SuperPrison getSuperPrisonHolder() {
		return superPrisonHolder;
	}

	public void setSuperPrisonHolder(SuperPrison superPrisonHolder) {
		this.superPrisonHolder = superPrisonHolder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bounty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((crimes == null) ? 0 : crimes.hashCode());
		result = prime * result + ((superPower == null) ? 0 : superPower.hashCode());
		result = prime * result + svillId;
		result = prime * result + ((svillName == null) ? 0 : svillName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperVillain other = (SuperVillain) obj;
		if (Double.doubleToLongBits(bounty) != Double.doubleToLongBits(other.bounty))
			return false;
		if (crimes == null) {
			if (other.crimes != null)
				return false;
		} else if (!crimes.equals(other.crimes))
			return false;
		if (superPower == null) {
			if (other.superPower != null)
				return false;
		} else if (!superPower.equals(other.superPower))
			return false;
		if (svillId != other.svillId)
			return false;
		if (svillName == null) {
			if (other.svillName != null)
				return false;
		} else if (!svillName.equals(other.svillName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SuperVillain [svillId=" + svillId + ", svillName=" + svillName + ", superPower=" + superPower
				+ ", bounty=" + bounty + ", crimes=" + crimes + "]";
	}
}
