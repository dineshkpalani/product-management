package com.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.pojo.Product;
//import com.products.pojo.Train;
import com.products.service.ProductService;

@RestController
@RequestMapping("/product")//handles base request
public class ProductController {
	
	@Autowired// object create & inject
	private ProductService service;
	
	@GetMapping("/list")
	public List<Product> listProduct() {
		System.out.println("Product Controller");
		return service.getProductList();
	}
	
	@GetMapping("/")
	public List<Product> filterID(@PathVariable int id) {
		return service.getFilterID();
	}
	
	@GetMapping("/listByCategory/{category}")
	public List<Product> listByCategory(@PathVariable String category) {
		System.out.println("List by Category = "+category);
		return service.getProductListByCategory(category);
	}
	
	@GetMapping("/{id}")
	public Product listByID(@PathVariable int id) {
		System.out.println("List by ID = "+id);
		return service.getProductListByID(id);
	}

	@PostMapping("")
	public String add(@RequestBody Product platform) {
		return service.add(platform);
	}
//
	@PutMapping("/{id}")//update
	public String update(@PathVariable int id,@RequestBody Product platform) {
		return service.update(id,platform);
	}
	
	@PutMapping("/purchase/{id}")//update
	public String purchaseUpdate(@PathVariable int id,@RequestBody Product platform) {
		return service.purchaseUpdate(id,platform);
	}
	
	@DeleteMapping("/delete/{id}")//delete
	public String delete(@PathVariable int id) {
		return service.delete(id);
	}
	
}
