package org.mani.Orderservice.controller;

import org.mani.Orderservice.dto.OrderDto;
import org.mani.Orderservice.entity.OrderEntity;
import org.mani.Orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class OrderController {
	@Autowired
	private OrderService service;
	@PostMapping(value = "/processOrder")
	public @ResponseBody OrderEntity processOrder(@RequestBody OrderDto dto) {
		OrderEntity processOrder = service.processOrder(dto);
		return processOrder;
	}

}
