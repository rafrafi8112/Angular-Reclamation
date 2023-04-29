package com.example.mobilite_internationale.repositories;

import com.example.mobilite_internationale.entities.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpCenterRepository extends JpaRepository<FAQ, Long> {
}
