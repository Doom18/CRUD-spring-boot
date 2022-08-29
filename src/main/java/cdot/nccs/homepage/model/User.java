package cdot.nccs.homepage.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="users")
public class User{
	
	@NaturalId
	private String name;
	
	@Id
	private String mail;
	
	private String password;
	
	private String real_name;
	
	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public User() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", mail=" + mail + ", password=" + password + ", real_name=" + real_name + "]";
	} 
	
}
