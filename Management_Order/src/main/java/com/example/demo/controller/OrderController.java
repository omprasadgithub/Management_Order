package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OrderEntity;
import com.example.demo.exception.OrderAlreadyExistException;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveOrder(@RequestBody OrderEntity order) {
		ResponseEntity<String> rese = null;
		try {
			service.saveOrder(order);
			rese = new ResponseEntity<String>("Order saved successfully", HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			rese = new ResponseEntity<String>("Occuring problem in saving", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return rese;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllOrder() {
		ResponseEntity<?> rese = null;
		try {
			List<OrderEntity> list = service.getAllOrder();
			list.stream().forEach((x) -> System.out.println(x));
			if (list == null || list.isEmpty()) {
				rese = new ResponseEntity<String>("No Data Found", HttpStatus.OK);
			} else {
				rese = new ResponseEntity<List<OrderEntity>>(list, HttpStatus.OK);
			}

		} catch (Exception e) {
			rese = new ResponseEntity<String>("Occuring problem in fatching data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return rese;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable(name = "id") Integer orderId) {
		ResponseEntity<String> rese = null;
		try {
			service.deleteOrder(orderId);
			rese = new ResponseEntity<String>("Order Id " + orderId + " is Deleted Successfully", HttpStatus.OK);
		} catch (OrderNotFoundException e) {
			rese = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			rese = new ResponseEntity<String>("Occuring problem in deleting", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return rese;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable(name = "id") Integer orderId) {
		ResponseEntity<?> rese = null;
		try {
			OrderEntity order = service.getOrder(orderId);
			rese = new ResponseEntity<OrderEntity>(order, HttpStatus.OK);
		} catch (OrderNotFoundException e) {
			System.out.println(e.getMessage());
			rese = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			rese = new ResponseEntity<String>("Occuring problem in Getting Order Details",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return rese;
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody OrderEntity order) {
		ResponseEntity<String> rese = null;
		try {
			service.updateOrder(order);
			rese = new ResponseEntity<String>("Order  is updated successfully", HttpStatus.OK);

		} catch (OrderNotFoundException e) {
			System.out.println(e.getMessage());
			rese = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			rese = new ResponseEntity<String>("Occuring problem in Updating", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return rese;
	}
}
