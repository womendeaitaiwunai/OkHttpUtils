package com.loong.okhttputils;

import java.util.List;

public class ProvinceCityDto {

    private List<City> citys;
    private List<Province> provinces;

	public ProvinceCityDto(List<City> citys, List<Province> provinces) {
		this.citys = citys;
		this.provinces = provinces;
	}

	public ProvinceCityDto() {
		super();
	}

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}
}
