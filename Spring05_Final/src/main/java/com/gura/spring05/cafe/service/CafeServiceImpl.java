package com.gura.spring05.cafe.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gura.spring05.cafe.dao.CafeCommentDao;
import com.gura.spring05.cafe.dao.CafeDao;
import com.gura.spring05.cafe.dto.CafeCommentDto;
import com.gura.spring05.cafe.dto.CafeDto;

@Service
public class CafeServiceImpl implements CafeService{
	
	@Autowired 
	private CafeDao cafeDao;
	@Autowired 
	private CafeCommentDao cafeCommentDao;
	
	@Override
	public void getList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDetail(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveContent(CafeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContent(CafeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContent(int num, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveComment(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComment(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComment(CafeCommentDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moreCommentList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

}
