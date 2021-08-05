package com.gura.spring05.gallery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.gallery.dto.GalleryDto;

@Repository
public class GalleryDaoImpl implements GalleryDao {

	@Autowired
	private SqlSession session;
	
	/*
	 * Mapper's namespace : gallery
	 * sql's id : getList
	 * parameterType : GalleryDto
	 * resultType : GalleryDto
	 */
	//gallery 의 모든 리스트 가져오기
	@Override
	public List<GalleryDto> getList(GalleryDto dto) {
		
		return session.selectList("gallery.getList", dto);
	}
	
	/*
	 * Mapper's namespace : gallery
	 * sql's id : getCount
	 * resultType : int
	 */
	//row 의 총 개수 구하기
	@Override
	public int getCount() {
		return session.selectOne("gallery.getCount");
	}
	
	/*
	 * Mapper's namespace : gallery
	 * sql's id : insert
	 * parameterType : GalleryDto
	 */
	@Override
	public void insert(GalleryDto dto) {
		session.insert("gallery.insert", dto);
	}
	
	/*
	 * Mapper's namespace : gallery
	 * sql's id : getData
	 * parameterType : int
	 * resultType : GalleryDto
	 */
	@Override
	public GalleryDto getData(int num) {
		return session.selectOne("gallery.getData", num);
	}
	
}
