package com.example.MovieApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.MovieApp.entities.Movies;
import com.example.MovieApp.service.MovieServiceImpl;

import jakarta.validation.Valid;

@Controller
public class MovieController {

    @Autowired
    MovieServiceImpl movieServiceImpl;

    // 🏠 Welcome Page
    @RequestMapping("/greet")
    public ModelAndView processGreet() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "Welcome to Movie App");
        mv.setViewName("welcome");
        return mv;
    }

    // 📌 Show Movie Page (Add + List)
    @RequestMapping("/movies")
    public ModelAndView showMovies() throws Exception {

        ModelAndView mv = new ModelAndView();
        mv.addObject("movies", movieServiceImpl.searchAllMovies());

        mv.addObject("movie", new Movies());   // ✅ THIS LINE IS MISSING

        mv.setViewName("movie");
        return mv;
    }

    // ➕ Add Movie
    @RequestMapping("/addMovie")
    public ModelAndView addMovie(@Valid @ModelAttribute("movie") Movies movie,
                                BindingResult result) throws Exception {

        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("movie");
            mv.addObject("movies", movieServiceImpl.searchAllMovies());
            return mv;
        }

        movieServiceImpl.addMovie(movie);
        return new ModelAndView("redirect:/movies");
    }

    @RequestMapping("/searchMovie")
    public ModelAndView searchMovie(String genre) throws Exception {

        ModelAndView mv = new ModelAndView("movie");

        if (genre == null || genre.isEmpty()) {
            mv.addObject("movies", movieServiceImpl.searchAllMovies());
        } else {
            mv.addObject("movies", movieServiceImpl.searchByGenre(genre));
        }

        mv.addObject("movie", new Movies());   // ✅ ADD THIS

        return mv;
    }
    
 
    
    // ✏️ Edit Page Load
    @RequestMapping("/editMovie")
    public ModelAndView editMovie(@RequestParam String name) throws Exception {

        Movies movie = movieServiceImpl.findByName(name);

        ModelAndView mv = new ModelAndView();
        mv.addObject("movie", movie);
        mv.addObject("isEdit", true);
        mv.addObject("movies", movieServiceImpl.searchAllMovies());
        mv.setViewName("movie");
        

        return mv;
    }

    // ✏️ Update
    @RequestMapping("/updateMovie")
    public ModelAndView updateMovie(@Valid @ModelAttribute("movie") Movies movie,
                                   BindingResult result) throws Exception {

        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("movie");
            mv.addObject("movies", movieServiceImpl.searchAllMovies());
            mv.addObject("isEdit", true);
            return mv;
        }
        movieServiceImpl.updateMovie(movie.getMovieName(),
                movie.getRating(),
                movie.getGenre());

return new ModelAndView("redirect:/movies");
}
    
    
    
    

    // ❌ Delete Movie (using name for simplicity)
    @RequestMapping("/deleteMovie")
    public ModelAndView deleteMovie(@RequestParam String name) throws Exception {

    	movieServiceImpl.deleteMovie(name);

        return new ModelAndView("redirect:/movies");
    }
}
