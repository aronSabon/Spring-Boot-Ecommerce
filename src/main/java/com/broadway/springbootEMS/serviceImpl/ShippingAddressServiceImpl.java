package com.broadway.springbootEMS.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadway.springbootEMS.model.ShippingAddress;
import com.broadway.springbootEMS.repository.ShippingAddressRepository;
import com.broadway.springbootEMS.service.ShippingAddressService;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService{
@Autowired
private ShippingAddressRepository sar;
	@Override
	public void addShippingAddress(ShippingAddress shippingAddress) {
		// TODO Auto-generated method stub
		sar.save(shippingAddress); 
	}

}
