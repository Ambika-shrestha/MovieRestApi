package fr.epita.DTO;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class SignUpDTO {
 
	private Long id;
	private String name;
	private String email;
	private String password;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedon(String createdate) {
		this.createdate = createdate;
	}
	public String getUpdatedon() {
		return updatedate;
	}
	public void setUpdatedon(String updatedon) {
		this.updatedate = updatedate;
	}

	private String birthdate;
	private String gender;
	private String country;
	private String area;
	private String city;
	private String street;
	private String pincode;
	private String role;
	private String  createdate;
	private String  updatedate;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public SignUpDTO() {
		
	}
	public SignUpDTO(Long id, String name, String password, String birthdate, String gender, String email,
			String country, String area, String city, String street, String pincode, String role, String createdate,
			String updatedate) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.birthdate = birthdate;
		this.gender = gender;
		this.email = email;
		this.country = country;
		this.area = area;
		this.city = city;
		this.street = street;
		this.pincode = pincode;
		this.role = role;
		
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("dd/mm/yyyy HH:mm:ss");
		System.out.println(ft.format(dNow));
		this.createdate = ft.format(dNow);
		this.updatedate = ft.format(dNow);
	}

	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String encrypt() {
		try {	
	         // Encode using basic encoder
	         String base64encodedString = Base64.getEncoder().encodeToString(this.password.getBytes("utf-8"));
	         return base64encodedString;
		}catch(Exception e){
			return this.password;
		}
	}
	
	public String decrypt() {
		 // Decode
        byte[] base64decodedBytes = Base64.getDecoder().decode(this.password);
		try {
			return new String(base64decodedBytes, "utf-8");
		} catch (UnsupportedEncodingException e) {
			return this.password;
		}
	}
}
