package com.shop.projectfiles;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String city;

	private String street;

	@Column(name = "local_no")
	private String localNo;

	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToMany(mappedBy = "company", cascade=javax.persistence.CascadeType.PERSIST, fetch=FetchType.EAGER)
	private Collection<TShirt> tShirts = new ArrayList<TShirt>();

	public Company() {
		super();
	}

	public Company(String name, String city, String street, String localNo,
			String phoneNumber) {
		super();
		this.name = name;
		this.city = city;
		this.street = street;
		this.localNo = localNo;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocalNo() {
		return localNo;
	}

	public void setLocalNo(String localNo) {
		this.localNo = localNo;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Collection<TShirt> gettShirts() {
		return tShirts;
	}

	public void settShirts(Collection<TShirt> tShirts) {
		this.tShirts = tShirts;
	}

	@Override
	public String toString() {

		return "Company " + name + ", address: " + city + ", " + street + " "
				+ localNo + ", phone number: " + phoneNumber;
	}

	public void printTShirts() {
		System.out.println("Wypisanie koszulek ze sklepu: " + name);
		for (TShirt ts : tShirts) {
			System.out.println(ts);
		}
	}

	public void deleteTShirt(TShirt tShirt) {
		tShirts.remove(tShirt);
	}

	public TShirt findTShirt(String catalogNumber) {
		for (TShirt tShirt : tShirts) {
			if (tShirt.getCatalogNumber().equals(catalogNumber)) {
				return tShirt;
			}
		}
		return null;
	}

}
