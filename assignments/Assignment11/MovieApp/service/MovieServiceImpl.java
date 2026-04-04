package com.example.MovieApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieApp.entities.Movies;
import com.example.MovieApp.repository.IMoviesRepo;

@Service
public class MovieServiceImpl implements IMovieService {

	@Autowired
	private IMoviesRepo movieRepo;

	@Override
	public void addMovie(Movies movie) throws Exception {
		movieRepo.save(movie);
		System.out.println("Movie added successfully");

	}

	@Override
	public void deleteMovie(String name) throws Exception {
		Movies movie = movieRepo.findBymovieName(name);

		if (movie == null) {
			throw new Exception("Movie not found");
		}

		movieRepo.delete(movie);
		System.out.println("Movie deleted successfully");

	}

	@Override
	public List<Movies> searchAllMovies() throws Exception {
		List<Movies> list = movieRepo.findAll();
		return list;
	}

	@Override
	public List<Movies> searchByGenre(String genre) throws Exception {
		return movieRepo.findByGenre(genre);
	}

	
	
	  // ✏️ Update
    @Override
    public void updateMovie(String name, double rating, String genre) throws Exception {

        Movies movie = movieRepo.findBymovieName(name);

        if (movie == null) {
            throw new Exception("Movie not found");
        }

        movie.setRating(rating);
        movie.setGenre(genre);

        movieRepo.save(movie);
    }

    // 🔎 Find for Edit
    @Override
    public Movies findByName(String name) {
        return movieRepo.findBymovieName(name);
    }
}



