package com.example.sem4.repository;

import com.example.sem4.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);


    @Query("select b from UserEntity b where b.fullName like %:name%")
    List<UserEntity> findByFullName(String name);

    List<UserEntity> findAllByName(String username, Pageable pageable);
}
