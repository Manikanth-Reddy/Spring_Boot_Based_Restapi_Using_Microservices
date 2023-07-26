package org.mani.Orderservice.service;

import java.util.Date;

import org.mani.Orderservice.dto.OrderDto;
import org.mani.Orderservice.entity.OrderEntity;
import org.mani.Orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private OrderRepository repository;
	
	public OrderEntity processOrder(OrderDto dto) {
		OrderEntity entity = new OrderEntity();
		entity.setPaymentMode(dto.getPaymentMode());
		entity.setQuantity(dto.getQuantity());
		entity.setSoldDate(new Date());
		entity.setProductId(dto.getProductId());
		Long price = template.getForObject("http://localhost:8080/ProductService/findProductPriceById/"+dto.getProductId(), Long.class);
		entity.setTotalprice(price * dto.getQuantity());
		entity.setPrice(price);
		repository.saveOrder(entity);
		return entity;
		
	}
}
