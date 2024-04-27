package com.example.carRental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carRental.Model.Carrental;
import com.example.carRental.repo.CarrentalRepository;

@Service
public class CarrentalServiceImpl implements CarrentalService{
	
	@Autowired
	private CarrentalRepository carrentalrepository;
	
	@Override
	public List<Carrental> getAllCars()
	{
		return carrentalrepository.findAll();
	}

	@Override
	public void saveCars(Carrental carrental) {
		// TODO Auto-generated method stub
		this.carrentalrepository.save(carrental);
		
	}

	@Override
	public Carrental getCarrentalById(long id) {
		// TODO Auto-generated method stub
		Optional <Carrental> optional = carrentalrepository.findById(id);
		Carrental carrental = null;
		if(optional.isPresent())
		{
			carrental = optional.get();
		}
		else {
			throw new RuntimeException("Car not found for id :: "+id);
		}
		return carrental;
	}

	@Override
	public void deleteCarrentalById(long id) {
		// TODO Auto-generated method stub
		this.carrentalrepository.deleteById(id);
	}
	
}
