package com.shop.listeners;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.shop.projectfiles.TShirt;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	@Transient
	private List<ProcessTShirtListener> listeners = new ArrayList<ProcessTShirtListener>();

	@Transient
	private TShirt tShirt;
	
	public Customer(){
		super();
	}
	
	public Customer(String name){
		this.name = name;
	}

	public synchronized void addTShirtProcessListener(
			ProcessTShirtListener listener) {
		listeners.add(listener);
	}

	public synchronized void removeTShirtProcessListener(
			ProcessTShirtListener listener) {
		listeners.remove(listener);
	}

	public synchronized void processTShirt() {
		TShirtEvent tShirtEvent = new TShirtEvent(this, tShirt);
		Iterator iterator = listeners.iterator();
		while (iterator.hasNext()) {
			((ProcessTShirtListener) iterator.next()).processCar(tShirtEvent);
		}
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void settShirt(TShirt tShirt) {
		this.tShirt = tShirt;
	}

	public TShirt gettShirt() {
		return tShirt;
	}

}
