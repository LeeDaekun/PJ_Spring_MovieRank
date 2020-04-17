package com.movierank.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.movierank.domain.MovieDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MongoDAO {

	@Autowired
	private MongoOperations mongoOper;	//MongoDB에서 sqlSession같은 녀석이다.
	
	public void save (MovieDTO mDto) {
		log.info("■■■■■■■■■■■■■ 영화 랭킹 정보 MongoDB에 저장");
		mongoOper.save(mDto);
	}
	
	
	public void dropCol() {
		log.info("■■■■■■■■■■■■■ Collection Drop");
		mongoOper.dropCollection("movieDTO");
	}
	
	
	public List<MovieDTO> movieList() {
		log.info("■■■■■■■■■■■■■ 영화 랭킹 정보 MongoDB에 저장");
		log.info("■■■■■■■■■■■■■ 깃허브 테스트");
		// List<MovieDTO> list = mongoOper.find(query, entityClass);
		
		return null;
	}
}
