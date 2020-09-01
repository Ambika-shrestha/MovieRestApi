package fr.epita.Resources;

import javax.inject.Inject;
import javax.ws.rs.Path;

import fr.epita.dao.SeenMovieDao;

@Path("/seenMovies")
public class SeenMoviesResources {

	@Inject
	SeenMovieDao seenMoviesDao;
	
	
}
