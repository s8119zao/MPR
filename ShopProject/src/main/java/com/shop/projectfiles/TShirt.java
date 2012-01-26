package com.shop.projectfiles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TShirt {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	@Column(name = "catalog_number")
	private String catalogNumber;

	private Size size;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	private double prize;

	public TShirt() {
		super();
	}

	public TShirt(String name, String catalogNumber, Size size, double prize)
			throws PrizeException {
		super();

		if (prize < 0) {
			throw new PrizeException("cena musi byæ wieksza od zera");
		}

		this.name = name;
		this.catalogNumber = catalogNumber;
		this.size = size;
		this.prize = prize;
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

	public String getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(String catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {

		return "T-Shirt name " + name + " (" + catalogNumber + "), size "
				+ size;
	}

	public void setPrize(double prize) throws PrizeException {
		if (prize < 0) {
			throw new PrizeException("cena musi byæ wieksza od zera");
		}
		this.prize = prize;
	}

	public double getPrize() {
		return prize;
	}

}
