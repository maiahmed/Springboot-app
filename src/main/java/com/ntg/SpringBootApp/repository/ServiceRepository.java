package com.ntg.SpringBootApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ntg.SpringBootApp.model.Services;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {

}
