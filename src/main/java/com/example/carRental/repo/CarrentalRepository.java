package com.example.carRental.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carRental.Model.Carrental;

@Repository
public interface CarrentalRepository extends JpaRepository<Carrental,Long> {

}
