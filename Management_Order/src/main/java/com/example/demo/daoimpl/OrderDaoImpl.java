package com.example.demo.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.OrderDao;
import com.example.demo.entity.OrderEntity;
import com.example.demo.repo.OrderRepository;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private OrderRepository repo;
	@Override
	public void saveOrder(OrderEntity oe) {
		repo.save(oe);
	}

	@Override
	public void deleteOrder(Integer orderId) {
		repo.deleteById(orderId);
	}

	@Override
	public OrderEntity getOrder(Integer orderId) {
		OrderEntity oe=repo.findById(orderId).get();
		return oe;
	}

	@Override
	public List<OrderEntity> getAllOrder() {
		List<OrderEntity> listOe=repo.findAll();
		return listOe;
	}

	@Override
	public void updateOrder(OrderEntity oe) {
		repo.save(oe);
	}

	@Override
	public boolean isPresent(Integer OrderId) {
		boolean isExist=repo.existsById(OrderId);
		return isExist;
	}

}
