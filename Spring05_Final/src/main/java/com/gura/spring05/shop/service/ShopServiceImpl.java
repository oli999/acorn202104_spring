package com.gura.spring05.shop.service;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import com.gura.spring05.shop.dao.OrderDao;
import com.gura.spring05.shop.dao.ShopDao;
import com.gura.spring05.shop.dto.OrderDto;
import com.gura.spring05.shop.dto.ShopDto;

@Service
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void getList(ModelAndView mView) {
		//상품 목록
		List<ShopDto> list=shopDao.getList();
		//ModelAndView  객체에 list 라는 키값으로 담는다.
		mView.addObject("list", list);
	}
	/*
	 *  - Spring 트랜젝션 설정 방법
	 *  1. pom.xml 에 spring-tx dependency 추가
	 *  2. servlet-context.xml 에 transaction 설정추가
	 *  3. 트랜젝션을 관리할 서비스의 메소드에 @Transactional 어노테이션 붙이기 
	 *  
	 *  - 프로그래머의 의도 하에서 트랜젝션에 영향을 주는 Exception 을 발생 시키는 방법
	 *  
	 *  DataAccessException 클래스를 상속받은 클래스를 정의하고 
	 *  
	 *  예)  class  MyException extends DataAccessExecption{ }
	 *       throw new MyException("예외 메세지"); 
	 *       
	 *  예외를 발생시킬 조건이라면 위와 같이 예외를 발생시켜서
	 *  트랜젝션이 관리 되도록 한다. 
	 */
	@Transactional
	@Override
	public void buy(HttpServletRequest request, ModelAndView mView) {
		
		//구입자의 아이디
		String id=(String)request.getSession().getAttribute("id");
		//1. 파라미터로 전달되는 구입할 상품 번호
		int num=Integer.parseInt(request.getParameter("num"));
		//2. 상품의 가격을 얻어온다.
		int price=shopDao.getPrice(num);
		//3. 상품의 가격만큼 계좌 잔액을 줄인다.
		ShopDto dto=new ShopDto();
		dto.setId(id);
		dto.setPrice(price);
		shopDao.minusMoney(dto);
		//4. 가격의 10% 를 포인트로 적립한다.
		shopDao.plusPoint(dto);
		//5. 재고의 갯수를 1 줄인다.
		shopDao.minusCount(num);
		//6. 주문 테이블(배송) 에 정보를 추가 한다. 
		OrderDto dto2=new OrderDto();
		dto2.setId(id); //누가
		dto2.setCode(num); //어떤 상품을 
		dto2.setAddr("강남구 삼원빌딩 5층");//어디로 배송할지
	
		
		orderDao.addOrder(dto2);
	}
	
}










