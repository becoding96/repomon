package com.repomon.rocketdan.domain.user.repository;


import com.repomon.rocketdan.domain.user.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUserName(String userName);

	Page<UserEntity> findByUserNameContaining(String search, Pageable pageable);

}
