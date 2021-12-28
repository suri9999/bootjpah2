package com.example.bootjpah2.DAO;

import com.example.bootjpah2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
