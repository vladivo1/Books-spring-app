package com.example.springbootapp.repository;

import com.example.springbootapp.domain.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardRepository extends JpaRepository<Reward, Integer> {
}
