package com.diancan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diancan.mapper.OrderMapper;

@Service
public class OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	
}
