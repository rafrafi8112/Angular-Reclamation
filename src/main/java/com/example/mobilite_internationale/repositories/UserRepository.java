package com.example.mobilite_internationale.repositories;

import com.example.mobilite_internationale.entities.Restoration;
import com.example.mobilite_internationale.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,Integer> {
}
