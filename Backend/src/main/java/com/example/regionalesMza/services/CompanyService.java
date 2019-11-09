package com.example.regionalesMza.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.regionalesMza.dtos.CompanyDTO;
import com.example.regionalesMza.entities.Company;
import com.example.regionalesMza.repositories.CompanyRepository;

@Service
public class CompanyService implements ObjectService<CompanyDTO> {

	private CompanyRepository companyRepository;

	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<CompanyDTO> getAll() {

		List<CompanyDTO> result = new ArrayList<>();

		for (Company company : companyRepository.findAll()) {
			CompanyDTO temp = new CompanyDTO();
			temp.setId(company.getId());
			temp.setName(company.getName());
			temp.setPhone(company.getPhone());
			temp.setCuit(company.getCuit());
			temp.setFull_addres(company.getFull_addres());
			temp.setLatitude(company.getLatitude());
			temp.setLongitude(company.getLongitude());
			result.add(temp);
		}
		return result;
	}

	@Override
	public CompanyDTO getOne(int id) {
		Optional<Company> aOptional = companyRepository.findById(id);

		CompanyDTO temp = new CompanyDTO();

		try {
			Company company = aOptional.get();

			temp.setId(company.getId());
			temp.setName(company.getName());
			temp.setPhone(company.getPhone());
			temp.setCuit(company.getCuit());
			temp.setFull_addres(company.getFull_addres());
			temp.setLatitude(company.getLatitude());
			temp.setLongitude(company.getLongitude());

		} catch (Exception e) {
			System.out.println("Non existing id");
		}
		return temp;
	}

	@Override
	public List<CompanyDTO> getByCatalog(String catalog) {

		List<CompanyDTO> result = new ArrayList<>();

		for (Company company : companyRepository.findByCatalog(catalog)) {
			CompanyDTO temp = new CompanyDTO();
			temp.setId(company.getId());
			temp.setName(company.getName());
			temp.setPhone(company.getPhone());
			temp.setCuit(company.getCuit());
			temp.setCatalog(company.getCatalog());
			temp.setFull_addres(company.getFull_addres());
			temp.setLatitude(company.getLatitude());
			temp.setLongitude(company.getLongitude());
			
			result.add(temp);
		}
		
		return result;

	}

	@Override
	public CompanyDTO save(CompanyDTO t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyDTO update(CompanyDTO t, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
