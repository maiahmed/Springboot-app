package com.ntg.SpringBootApp.serviceLayer;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntg.SpringBootApp.model.Services;
import com.ntg.SpringBootApp.repository.EmployeeRepository;
import com.ntg.SpringBootApp.repository.ServiceRepository;

@Service
public class ServiceServLayerImpl implements ServiceSerLayer{

	@Autowired
	ServiceRepository serviceRepository;
	
	@Override
	public Services save(Services entity) {
		return serviceRepository.save(entity);
				}

	@Override
	public Services getById(Serializable id) {
		return serviceRepository.findOne((Long) id);
	}

	@Override
	public List<Services> getAll() {
		return serviceRepository.findAll();
	}

	@Override
	public void delete(Serializable id) {
		serviceRepository.delete((Long) id);
		
	}

	
}
