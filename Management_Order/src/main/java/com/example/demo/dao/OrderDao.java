package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.OrderEntity;

public interface OrderDao {
	
	public void saveOrder(OrderEntity oe);

	public void deleteOrder(Integer orderId);

	public OrderEntity getOrder(Integer orderId);

	public List<OrderEntity> getAllOrder();

	public void updateOrder(OrderEntity oe);
	
	public boolean isPresent(Integer OrderId);
}
