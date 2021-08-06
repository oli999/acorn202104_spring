package com.gura.spring05.shop.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.shop.dto.OrderDto;

@Repository
public class OrderDaoImpl implements OrderDao{
	@Autowired
	private SqlSession session;
	//상품 주문 정보를 저장하는 메소드 
	@Override
	public void addOrder(OrderDto dto) {
		session.insert("shop.addOrder", dto);
	}
	
}




