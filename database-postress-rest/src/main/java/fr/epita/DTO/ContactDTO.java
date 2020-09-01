package fr.epita.DTO;

import fr.epita.datamodel.SignUp;

public class ContactDTO {
	
	
	public ContactDTO() {
		
	}
	private Long id;
	private String birthdate;
	private String gender;
	private String email;
	private SignUp user;
	private String  createdate;
	private String  updatedate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	
	
	
}
