package com.broadway.springbootEMS.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadway.springbootEMS.model.DeliveryAddress;
import com.broadway.springbootEMS.repository.DeliveryAddressRepository;
import com.broadway.springbootEMS.service.DeliveryAddressService;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService{
@Autowired
DeliveryAddressRepository dar;
	@Override
	public void addBillingAddress(DeliveryAddress deliveryAddress) {
		// TODO Auto-generated method stub
		dar.save(deliveryAddress);
	}
	@Override
	public List<DeliveryAddress> getAllAddress() {
		// TODO Auto-generated method stub
		return dar.findAll();
	}
	@Override
	public DeliveryAddress getAddressById(int dId) {
		// TODO Auto-generated method stub
		return dar.findById(dId);
	}

}
