package com.neo.springbootdatajpa.repository;

import java.util.List;

import com.neo.springbootdatajpa.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.springbootdatajpa.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);
}