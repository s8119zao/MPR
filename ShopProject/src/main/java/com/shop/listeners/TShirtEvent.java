package com.shop.listeners;

import java.util.EventObject;

import com.shop.projectfiles.TShirt;

public class TShirtEvent  extends EventObject {

	private static final long serialVersionUID = 1L;

	private TShirt shirt;
	
	public TShirt getTShirt() {
		return shirt;
	}

	public TShirtEvent(Object source, TShirt shirt) {
		super(source);
		this.shirt=shirt;
	}

}
