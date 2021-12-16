package sg.iss.laps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.laps.model.LeaveBalance;

public interface LeaveBalanceRepo extends JpaRepository<LeaveBalance, Integer> {

}
