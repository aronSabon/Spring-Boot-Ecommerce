package com.broadway.springbootEMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broadway.springbootEMS.model.ShippingAddress;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Integer>{

}
