package com.stackroute.oops;

import java.util.Objects;

public class Address {

	private String area;
	private String city;

	public Address() {
		area = null;
		city = null;
	}

	public Address(String area, String city) {
		this.area = area;
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
@Override
	public boolean equals(Object add) {
		if(add==this) {
			return true;
		}
		if(add==null || add.getClass()!=this.getClass()) {
			return false;
		}
		Address address2=(Address) add;
		return (((city == null && address2.city == null) || Objects.equals(city,address2.city))
				&& ((area == null && address2.area == null) || Objects.equals(area,address2.area)));
	}
	
	
}
