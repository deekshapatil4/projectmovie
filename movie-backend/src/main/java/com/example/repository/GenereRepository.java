package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Genere;

@Repository
public interface GenereRepository extends JpaRepository<Genere,Long> {

}
