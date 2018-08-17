package com.bootshop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bootshop.model.Product;
import com.bootshop.repository.ProductRepository;
import com.bootshop.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	public ProductRepository productRepository;
	
	
	public void addProduct(Product product) {
		productRepository.save(product);
		
	}

	public Product getProductById(int id) {
		return productRepository.findOne(id);
	}

	public void deleteProduct(Product product) {
		productRepository.delete(product);
		
	}

	public void editProduct(Product product) {
		productRepository.save(product);
	}

	public List<Product> getProductList() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findAllBySubCatetoryId(Integer id) {
		return productRepository.findAllBySubCatetoryId(id);
	}


	public Page<Product> getProductList(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	

}