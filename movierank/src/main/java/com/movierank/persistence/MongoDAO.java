package com.movierank.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.movierank.domain.MovieDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MongoDAO {
		
		// MongoDB에서는 종류가 다른 일꾼이 두명이 있다
		// MongoDB에서 sqlSession같은 녀석이다.
		// MongoOperations: sql문 안쓰고 사용할때 많이 사용
		// MongoTemplate: 쿼리를 직접 다 날릴 수 있는 녀석(디테일하게 설정)
	@Autowired
	private MongoOperations mongoOper;	//MongoDB에서 sqlSession같은 녀석이다.
	
	public void save (MovieDTO mDto) {
		
		
		log.info("■■■■■■■■■■■■■ 영화 랭킹 정보 MongoDB에 저장");
		mongoOper.save(mDto);
	}
	
	
	public void dropCol() {
		log.info("■■■■■■■■■■■■■ Collection Drop");
		mongoOper.dropCollection("movie");  //mongoOper : sql문 안쓰고 사용할때 많이 사용
	}
	
	
	public List<MovieDTO> movieList() {
		log.info(">>>>> 영화 랭킹정보 MongoDB에서 Select");
		Criteria cri = new Criteria();
		Query query = new Query(cri);
		                                   //쿼리를 날려서 조회할껀데, MovieDTO.class 에 있는 타입으로 할꺼고, 이걸 몽고DB의 movie 에다가 넣어줘라.
		List<MovieDTO> list = mongoOper.find(query, MovieDTO.class, "movie");
		for(MovieDTO one : list) {
			log.info(one.toString());
		}
		return list;
	}
}
