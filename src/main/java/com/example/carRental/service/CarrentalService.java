package com.example.carRental.service;

import java.util.List;

import com.example.carRental.Model.Carrental;


public interface CarrentalService {
	List < Carrental > getAllCars();
    void saveCars(Carrental carrental);
    Carrental getCarrentalById(long id);
    void deleteCarrentalById(long id);
}
