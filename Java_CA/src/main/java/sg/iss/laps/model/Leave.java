package sg.iss.laps.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="leave")
public class Leave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer leaveId;
//	one user to many leave
	@ManyToOne
	private User user;
	private LeaveStatus status;	//enum
	private String reason;
	private String workdissem;
	private LeaveType type;

	@FutureOrPresent
	@Column(name = "applieddate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate appliedDate;
	@FutureOrPresent
	@Column(name = "startdate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate startDate;
	@FutureOrPresent
	@Column(name = "enddate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate endDate;
		
	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Leave(LeaveStatus ls) {
		super();
		this.status=ls;
	}
	public Leave(User user, LeaveStatus status, LeaveType type, String reason, String workdissem,
			LocalDate appliedDate, LocalDate startDate, LocalDate endDate) {
		super();
		this.user = user;
		this.status = status;
		this.type=type;
		this.reason = reason;
		this.workdissem = workdissem;
		this.appliedDate = appliedDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Leave(Integer leaveId, User user, LeaveStatus status, LeaveType type, String reason, String workdissem,
			@FutureOrPresent LocalDate appliedDate, @FutureOrPresent LocalDate startDate, @FutureOrPresent LocalDate endDate) {
		super();
		this.leaveId = leaveId;
		this.user = user;
		this.status = status;
		this.type=type;
		this.reason = reason;
		this.workdissem = workdissem;
		this.appliedDate = appliedDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LeaveStatus getStatus() {
		return status;
	}
	public void setStatus(LeaveStatus status) {
		this.status = status;
	}
	public LeaveType getType() {
		return type;
	}
	public void setType(LeaveType type) {
		this.type = type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getWorkdissem() {
		return workdissem;
	}
	public void setWorkdissem(String workdissem) {
		this.workdissem = workdissem;
	}
	public LocalDate getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(@FutureOrPresent LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(@FutureOrPresent LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate( @FutureOrPresent LocalDate endDate) {
		this.endDate = endDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(leaveId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Leave other = (Leave) obj;
		return Objects.equals(leaveId, other.leaveId);
	}
	@Override
	public String toString() {
		return "Leave [leaveId=" + leaveId + ", user=" + user + ", status=" + status + ", reason=" + reason
				+ ", workdissem=" + workdissem + ", type=" + type + ", appliedDate=" + appliedDate + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

	

	



	
}
