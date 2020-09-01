package fr.epita.DTO;

import fr.epita.datamodel.SignUp;

public class AddressDTO {

	
	private Long id;
	private String country;
	private String area;
	private String city;
	private String street;
	private String pincode;
	private SignUp user;
	private String  createdate;
	private String  updatedate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public SignUp getUser() {
		return user;
	}
	public void setUser(SignUp user) {
		this.user = user;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	public AddressDTO() {
		
	}
	
	
	
}
