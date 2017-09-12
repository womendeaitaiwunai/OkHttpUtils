package com.loong.okhttputils;

/**
 * ProvinceId entity. @author MyEclipse Persistence Tools
 */

public class Province implements java.io.Serializable {

	// Fields

	private Double id;
	private Double provinceId;
	private Double nationId;
	private String provinceName;
	private String back;

	// Constructors

	/** default constructor */
	public Province() {
	}

	/** full constructor */
	public Province(Double id, Double provinceId, Double nationId,
					String provinceName, String back) {
		this.id = id;
		this.provinceId = provinceId;
		this.nationId = nationId;
		this.provinceName = provinceName;
		this.back = back;
	}

	// Property accessors

	public Double getId() {
		return this.id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	public Double getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Double provinceId) {
		this.provinceId = provinceId;
	}

	public Double getNationId() {
		return this.nationId;
	}

	public void setNationId(Double nationId) {
		this.nationId = nationId;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
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
		if (!(other instanceof Province))
			return false;
		Province castOther = (Province) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getProvinceId() == castOther.getProvinceId()) || (this
						.getProvinceId() != null
						&& castOther.getProvinceId() != null && this
						.getProvinceId().equals(castOther.getProvinceId())))
				&& ((this.getNationId() == castOther.getNationId()) || (this
						.getNationId() != null
						&& castOther.getNationId() != null && this
						.getNationId().equals(castOther.getNationId())))
				&& ((this.getProvinceName() == castOther.getProvinceName()) || (this
						.getProvinceName() != null
						&& castOther.getProvinceName() != null && this
						.getProvinceName().equals(castOther.getProvinceName())))
				&& ((this.getBack() == castOther.getBack()) || (this.getBack() != null
						&& castOther.getBack() != null && this.getBack()
						.equals(castOther.getBack())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getProvinceId() == null ? 0 : this.getProvinceId()
						.hashCode());
		result = 37 * result
				+ (getNationId() == null ? 0 : this.getNationId().hashCode());
		result = 37
				* result
				+ (getProvinceName() == null ? 0 : this.getProvinceName()
						.hashCode());
		result = 37 * result
				+ (getBack() == null ? 0 : this.getBack().hashCode());
		return result;
	}

}