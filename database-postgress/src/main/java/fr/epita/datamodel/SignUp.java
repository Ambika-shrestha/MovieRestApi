package fr.epita.datamodel;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SignUp")
public class SignUp {
   
	
	@Column(name="name")
	private String name;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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

	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@Column(name="createdate")
	private String  createdate;
	
	@Column(name="updatedate")
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
	
  public SignUp() {
	// TODO Auto-generated constructor stub
}
}
