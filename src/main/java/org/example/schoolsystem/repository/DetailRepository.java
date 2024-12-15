package org.example.schoolsystem.repository;

import org.example.schoolsystem.entity.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Details, Long> {

  Details findByUsername(String username);
}


