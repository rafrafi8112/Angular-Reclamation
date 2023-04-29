package com.example.mobilite_internationale.repositories;

import com.example.mobilite_internationale.entities.Publication;
import com.example.mobilite_internationale.entities.Reclamation;
import com.example.mobilite_internationale.entities.Reservation;
import com.example.mobilite_internationale.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Integer> {
    List<Reclamation> findByUserAndPublication(User u1, Publication p1);
}
