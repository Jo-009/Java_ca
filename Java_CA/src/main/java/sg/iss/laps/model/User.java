package sg.iss.laps.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

@Entity
@DynamicUpdate
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String email;
	private String firstName;
	private String lastName;
	private LocalDate lastLoginDate;
	private String department;
	@Length(min = 8, message = "Must be more than 8 char")
	private String password;
//	@OneToOne
//	private User coveringOfficer;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Collection<Leave> leave = new HashSet<Leave>();
	
	public User() {
		super();
	}

//	Test constructor
	public User(Long id, String firstname) {
		super();
		this.userId=id;
		this.firstName=firstname;
	}
//	Test constructor with Collection leave
	public User(Long id, String firstname, HashSet<Leave> leave) {
		super();
		this.userId=id;
		this.firstName=firstname;
		this.leave=leave;
	}

	public User(Long userId, String email, String firstName, String lastName, LocalDate lastLoginDate, String department,
			@Length(min = 8, message = "Must be more than 8 char") String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastLoginDate = lastLoginDate;
		this.department = department;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(LocalDate lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public User getCoveringOfficer() {
//		return coveringOfficer;
//	}
//
//	public void setCoveringOfficer(User coveringOfficer) {
//		this.coveringOfficer = coveringOfficer;
//	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", lastLoginDate=" + lastLoginDate + ", department=" + department + ", password=" + password
				+ ", leave=" + leave + "]";
	}
	

	
}