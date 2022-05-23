package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderDao;
import com.example.demo.entity.OrderEntity;
import com.example.demo.exception.OrderAlreadyExistException;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao dao;

	@Override
	public void saveOrder(OrderEntity oe) {
		dao.saveOrder(oe);
	}

	@Override
	public void deleteOrder(Integer orderId) {
		if(!dao.isPresent(orderId)) {
			throw new OrderNotFoundException("No Order Details Exist With this Order Id '"+orderId+"'");
		}
		dao.deleteOrder(orderId);
	}

	@Override
	public OrderEntity getOrder(Integer orderId) {
		if(!dao.isPresent(orderId)) {
			throw new OrderNotFoundException("No Order Details Exist With this Order Id '"+orderId+"'");
		}
		return dao.getOrder(orderId);
	}

	@Override
	public List<OrderEntity> getAllOrder() {
		return dao.getAllOrder();
	}

	@Override
	public void updateOrder(OrderEntity oe) {
		if (!dao.isPresent(oe.getOrder_id())) {
			throw new OrderNotFoundException("No Order Details Exist With this Order Id '" + oe.getOrder_id() + "'");
		}
		dao.saveOrder(oe);
	}

	@Override
	public boolean isPresent(Integer OrderId) {
		return dao.isPresent(OrderId);
	}

}
