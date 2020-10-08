package com.NetflixProject.UserService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.NetflixProject.UserService.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
