package com.ideasservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.ideasservice.model.Idea;

import jakarta.transaction.Transactional;

@Repository
public interface IdeaRepo extends JpaRepository<Idea, Long> {

	public List<Idea> findByUserId(Long userId);

	public Idea findByUserIdAndId(Long userId, Long id);
	
	
	@Modifying
	@Transactional
	public void deleteAllByUserId(Long userId);

}
