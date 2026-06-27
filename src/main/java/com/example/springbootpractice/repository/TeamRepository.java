package com.example.springbootpractice.repository;

import com.example.springbootpractice.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}