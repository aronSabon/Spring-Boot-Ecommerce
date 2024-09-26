package com.broadway.springbootEMS.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadway.springbootEMS.model.Product;
import com.broadway.springbootEMS.repository.ProductRepository;
import com.broadway.springbootEMS.service.ProductService;
@Service
public class ProductServiceImpl  implements ProductService{
	@Autowired
	ProductRepository pr;

	
	
	

	@Override
	public List<Product> pListByCategory(String category) {
		// TODO Auto-generated method stub
		List<Product> jList= pr.findByCategory(category);
		return jList;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id);
	}


	@Override
	public List<Product> pListForSearch(String sData) {
		// TODO Auto-generated method stub
		List<Product> sList= pr.findByTitle(sData);
		return sList;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}

}
