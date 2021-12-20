package sg.iss.laps.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.laps.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	@Query("SELECT u FROM User u WHERE u.email = :email")
	List<User> findByUserEmail(@Param("email") String email);
	
	@Query("SELECT u FROM User u where u.userId =:id")
	User findById(@Param("id") Long id);
	
//	@Modifying
//	@Query("UPDATE User u SET u.lastLoginDate = :date WHERE u.userId = :id")
//	int updateUserLoginDate(@Param("date") Date date, @Param("id") UUID id);
	
	@Modifying
	@Query("update User u set u.lastLoginDate = ?1 where u.userId = ?2")
	void updateLoginDate(Date date, UUID userId);
}
