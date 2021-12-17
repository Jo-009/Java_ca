package sg.iss.laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.laps.model.Leave;
import sg.iss.laps.model.LeaveStatus;

public interface LeaveRepo extends JpaRepository<Leave, Integer> {

	@Query("SELECT l FROM Leave l where l.leaveId = :Id")
	Leave findLeaveById(@Param("Id") Long d);

//this is for checking EMPL LEAVE HISTORY
//	@Query("SELECT l FROM Leave l where l.user.userid = :Id")
//	Leave findLeaveByUserId(@Param("Id") Long d);
	ArrayList<Leave> findLeaveByUser_UserIdLike(Long userId);
	
	@Query("SELECT l FROM Leave l" 
			+ " WHERE l.status=:APPLIED " 
			+ "AND l.status= :UPDATED")
	public ArrayList<Leave> findLeaveToApprove(@Param("APPLIED") LeaveStatus a, 
			@Param("UPDATED") LeaveStatus u);
}