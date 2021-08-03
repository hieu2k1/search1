package com.example.sem4.repository;

import com.example.sem4.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByName(String name);
}
