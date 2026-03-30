package com.example.MovieApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MovieApp.entities.Movies;

@Repository
public interface IMoviesRepo extends JpaRepository<Movies, Integer>{
	List<Movies> findByGenre(String genre);
	
	Movies findBymovieName(String name);

}

