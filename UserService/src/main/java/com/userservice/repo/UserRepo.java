package com.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.userservice.model.User;

import feign.Param;
import jakarta.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	public User findByUserId(Long id);

	public User findByEmail(String email);

	@Modifying
	@Transactional
	@Query("UPDATE User e SET e.totalIdeas = e.totalIdeas + 1 WHERE e.userId = :id")
	void incrementValueColumnById(Long id);
	
	
	@Modifying
	@Transactional
	@Query("UPDATE User e SET e.totalIdeas = e.totalIdeas + 1 WHERE e.userId = :id")
	void decrementIdeaTotalCount(Long id);
	
	@Modifying
	@Transactional
	@Query("UPDATE User e SET e.email = :email WHERE e.userId = :id")
	void updateEmail(@Param("email")String email,@Param("id")Long id);
	
	@Modifying
	@Transactional
	@Query("UPDATE User e SET e.password = :password WHERE e.userId = :id")
	void updatePassword(@Param("password")String password,@Param("id")Long id);
	
	
	@Query("SELECT u.totalIdeas FROM User u WHERE u.userId = :userId")
	Integer findTotalIdeasOfUser(@Param("userId")Long userId);
	
	@Modifying
	@Transactional
	public void deleteByUserId(Long id);
}
