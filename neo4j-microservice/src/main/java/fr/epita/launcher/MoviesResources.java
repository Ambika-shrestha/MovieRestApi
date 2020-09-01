package fr.epita.launcher;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.epita.datamodel.Movie;
import fr.epita.services.data.Neo4jMoviesDAO;

@RestController
public class MoviesResources {
	@Inject
	Neo4jMoviesDAO dao;
	
	@CrossOrigin(origins="*")
	@GetMapping("/movies")
	public List<Movie> listMovies() {
	
		return dao.listAll();
		
	}
	@CrossOrigin(origins="*")
	@GetMapping("/movies/{id}")
	public Movie getMovieById(@PathVariable int id) {
		return dao.getMovieById(id);
		
	}
	@CrossOrigin(origins="*")
	@PostMapping("/movies")
	public Movie createMovies(@RequestBody Movie movie){
		return dao.createMovies(movie);
		
	}
	@CrossOrigin(origins="*")
	@DeleteMapping("/movies/{id}")
	public Boolean delete(@PathVariable int id) {
		return dao.delete(id);	
	}
	@CrossOrigin(origins="*")
	@PutMapping("/movies/{id}")
	public Movie Update(@RequestBody Movie movie, @PathVariable int id) {
		return dao.updateMovie(movie, id);
		
	}
}
