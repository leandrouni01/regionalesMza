package com.example.regionalesMza.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.regionalesMza.dtos.CompanyDTO;
import com.example.regionalesMza.services.CompanyService;

@Controller
@RestController
@RequestMapping(path = "/regionalesMza/V1.0/companies")
public class CompanyController implements ObjectController<CompanyDTO> {

	private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/")
	public List<CompanyDTO> getAll() {

		return ResponseEntity.status(200).body(companyService.getAll()).getBody();
	}

	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/{id}")
	public CompanyDTO getOne(@PathVariable int id) {

		return ResponseEntity.status(204).body(companyService.getOne(id)).getBody();

	}

	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/catalogs/{catalog}")
	public List<CompanyDTO> getByCatalog(@PathVariable String catalog) {

		return ResponseEntity.status(204).body(companyService.getByCatalog(catalog)).getBody();
	}

	@Override
	public ResponseEntity save(CompanyDTO t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity update(CompanyDTO t, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
