package com.join.one2one;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import antlr.collections.List;

@RestController
public class LaptopController 
{
	@Autowired
	private LaptopRepo lRepo;
	
	@Autowired
	private BrandRepo bRepo;
	
	@PostMapping("/laptops/save")
	public ResponseEntity<Laptop> saveData (@RequestBody LaptopRequest req) {
		
		Brand brand = new Brand();
		brand.setBrandName(req.getBrand());
		
		brand = bRepo.save(brand);
		
		Laptop laptop = new Laptop(req);
		laptop.setBrand(brand);
		
		laptop = lRepo.save(laptop);
		
		return new ResponseEntity<Laptop>(laptop, HttpStatus.CREATED);
	}
	
	@GetMapping("/laptop/get/{id}")
	public Laptop getlapList(@PathVariable Long id)
	{
		Optional<Laptop> list = lRepo.findById(id);
		return list.get();
	}	
	@GetMapping("/laptop/get")
	public List<Brand> getlapList()
	{
		List<Brand>list = bRepo.findAll();
		return list;
	}
}
