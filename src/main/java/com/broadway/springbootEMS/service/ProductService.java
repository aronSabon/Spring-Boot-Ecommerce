package com.broadway.springbootEMS.service;

import java.util.List;

import com.broadway.springbootEMS.model.Product;

public interface ProductService {
List<Product> pListByCategory(String category);
List<Product> getAll();
Product getById(int id);
List<Product> pListForSearch(String sData);
void deleteById(int id);
}
