package com.loong.okhttputils;

/**
 * CityId entity. @author MyEclipse Persistence Tools
 */

public class City implements java.io.Serializable {

	// Fields

	private Double id;
	private Double cityId;
	private Double provinceId;
	private String cityName;
	private String back;

	// Constructors

	/** default constructor */
	public City() {
	}

	/** full constructor */
	public City(Double id, Double cityId, Double provinceId, String cityName,
				String back) {
		this.id = id;
		this.cityId = cityId;
		this.provinceId = provinceId;
		this.cityName = cityName;
		this.back = back;
	}

	// Property accessors

	public Double getId() {
		return this.id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	public Double getCityId() {
		return this.cityId;
	}

	public void setCityId(Double cityId) {
		this.cityId = cityId;
	}

	public Double getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Double provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getBack() {
		return this.back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof City))
			return false;
		City castOther = (City) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getCityId() == castOther.getCityId()) || (this
						.getCityId() != null
						&& castOther.getCityId() != null && this.getCityId()
						.equals(castOther.getCityId())))
				&& ((this.getProvinceId() == castOther.getProvinceId()) || (this
						.getProvinceId() != null
						&& castOther.getProvinceId() != null && this
						.getProvinceId().equals(castOther.getProvinceId())))
				&& ((this.getCityName() == castOther.getCityName()) || (this
						.getCityName() != null
						&& castOther.getCityName() != null && this
						.getCityName().equals(castOther.getCityName())))
				&& ((this.getBack() == castOther.getBack()) || (this.getBack() != null
						&& castOther.getBack() != null && this.getBack()
						.equals(castOther.getBack())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getCityId() == null ? 0 : this.getCityId().hashCode());
		result = 37
				* result
				+ (getProvinceId() == null ? 0 : this.getProvinceId()
						.hashCode());
		result = 37 * result
				+ (getCityName() == null ? 0 : this.getCityName().hashCode());
		result = 37 * result
				+ (getBack() == null ? 0 : this.getBack().hashCode());
		return result;
	}

}