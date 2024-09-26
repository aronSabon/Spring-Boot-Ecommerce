package com.broadway.springbootEMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broadway.springbootEMS.model.DeliveryAddress;
import java.util.List;


public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Integer>{
DeliveryAddress findById(int dId);
}
