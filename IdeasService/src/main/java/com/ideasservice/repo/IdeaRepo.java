package com.ideasservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideasservice.model.Idea;

@Repository
public interface IdeaRepo extends JpaRepository<Idea, Long> {

	public List<Idea> findByUserId(Long userId);

	public Idea findByUserIdAndId(Long userId, Long id);

}