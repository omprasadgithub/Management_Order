package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.OrderEntity;

public interface OrderService {
	
	public void saveOrder(OrderEntity oe);

	public void deleteOrder(Integer orderId);

	public OrderEntity getOrder(Integer orderId);

	public List<OrderEntity> getAllOrder();

	public void updateOrder(OrderEntity oe);
	
	public boolean isPresent(Integer OrderId);
}
