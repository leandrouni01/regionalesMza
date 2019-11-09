package com.example.regionalesMza.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.regionalesMza.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

	List<Company> findByCatalog(String catalog);
}
