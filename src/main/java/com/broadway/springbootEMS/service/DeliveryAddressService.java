package com.broadway.springbootEMS.service;

import java.util.List;

import com.broadway.springbootEMS.model.DeliveryAddress;

public interface DeliveryAddressService {
void addBillingAddress(DeliveryAddress deliveryAddress);
List<DeliveryAddress> getAllAddress();
DeliveryAddress getAddressById(int dId);
}
