package com.example.Cornacase.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class DATA {
	@JsonPropertyOrder({ "Province", "Country", "Lat", "Long", "date" })
	@JsonProperty("Province")
	String Province;
	@JsonProperty("Country")
	String Country;
	@JsonProperty("Lat")
	String Lat;
	@JsonProperty("Long")
	String Long;
	@JsonProperty("date")
	Integer date;

	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		Province = province;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getLat() {
		return Lat;
	}

	public void setLat(String lat) {
		Lat = lat;
	}

	public String getLong() {
		return Long;
	}

	public void setLong(String aLong) {
		Long = aLong;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public String toString() {
		return "DATA{" +
				"Province='" + Province + '\'' +
				", Country='" + Country + '\'' +
				", Lat='" + Lat + '\'' +
				", Long='" + Long + '\'' +
				", date=" + date +
				'}';
	}
}
