package fr.epita.services.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;
import org.neo4j.driver.Value;
import org.springframework.stereotype.Repository;

import fr.epita.datamodel.Movie;

@Repository
public class Neo4jMoviesDAO {
	Driver driver;
	public Neo4jMoviesDAO() {
		driver = GraphDatabase.driver("bolt://192.168.0.48:10687", 
				AuthTokens.basic("neo4j", "admin"));

	}
	
	public List<Movie> listAll(){
		Session session = driver.session();
		Transaction tx = session.beginTransaction();
		List<Movie> movies = new ArrayList<Movie>();
		
		//Result result = tx.run("MATCH (n {name: $varName }) RETURN n", parameters("varName", name));
		Result result = tx.run("MATCH (n:Movie) RETURN n, id(n) as ID");
		while (result.hasNext()) {
			Record row = result.next();
			Value value = row.get("n");
			Map<String, Object> properties = value.asEntity().asMap();
			Movie movie = new Movie();
			movie.setId(row.get("ID").asInt());
			movie.setName(String.valueOf(properties.get("title")));
			movie.setTagline(String.valueOf(properties.get("tagline")));
			movie.setReleased(Long.valueOf(String.valueOf(properties.get("released"))));
			movies.add(movie);
		}
		return movies;
	}
	
	public Movie getMovieById(int id) {
		Session session = driver.session();
		Transaction tx = session.beginTransaction();
		Result result = tx.run("MATCH (n:Movie) WHERE id(n)="+id+" RETURN n, id(n) as ID");
		Record record = result.single();
		Value value = record.get("n");
		Map<String, Object> properties = value.asEntity().asMap();
		Movie movie = new Movie();
		movie.setId(record.get("ID").asInt());
		movie.setName(String.valueOf(properties.get("title")));
		movie.setTagline(String.valueOf(properties.get("tagline")));
		movie.setReleased(Long.valueOf(String.valueOf(properties.get("released"))));
		return movie;
	}
	
	public boolean delete(final int id) {
		Session session = driver.session();
		boolean res = session.writeTransaction(new TransactionWork<Boolean>() {

			public Boolean execute(Transaction tx) {
				Result result = tx.run("MATCH (n:Movie) WHERE id(n)="+id+" DETACH DELETE n RETURN count(n) as deleted");
				Record record = result.single();
				
				int deleted = record.get("deleted").asInt();
				if(deleted>0) {
					return true;
				}
				tx.commit();
				return false;
			}	
		});
		return res;
		
	}
	
	public Movie createMovies(final Movie movie) {
		Session session = driver.session();
		Movie res = session.writeTransaction(new TransactionWork<Movie>() {

			public Movie execute(Transaction tx) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("released", movie.getReleased());
				params.put("tagline", movie.getTagline());
				params.put("title", movie.getName());
				Result result = tx.run(("CREATE (n:Movie {released:$released, tagline: $tagline, title: $title}) RETURN n, id(n) as ID"),params);
				Record record = result.single();
				Value value = record.get("n");
				Map<String, Object> properties = value.asEntity().asMap();
				Movie movie = new Movie();
				movie.setId(record.get("ID").asInt());
				movie.setName(String.valueOf(properties.get("title")));
				movie.setTagline(String.valueOf(properties.get("tagline")));
				movie.setReleased(Long.valueOf(String.valueOf(properties.get("released"))));
				tx.commit();
				return movie;
			}
			
		});
		return res;
	}
	
	public Movie updateMovie(final Movie movie , final int id) {
		Session session = driver.session();
		Movie res = session.writeTransaction(new TransactionWork<Movie>() {

			public Movie execute(Transaction tx) {
				Result result = tx.run(("MATCH (n:Movie) WHERE id(n) = "+id+" SET n.released= "+movie.getReleased()+", n.tagline= '"+movie.getTagline()+"', n.title= '"+movie.getName()+"' RETURN n, id(n) as ID"));
				Record record = result.single();
				Value value = record.get("n");
				Map<String, Object> properties = value.asEntity().asMap();
				Movie movie = new Movie();
				movie.setId(record.get("ID").asInt());
				movie.setName(String.valueOf(properties.get("title")));
				movie.setTagline(String.valueOf(properties.get("tagline")));
				movie.setReleased(Long.valueOf(String.valueOf(properties.get("released"))));
				tx.commit();
				return movie;
			}
			
		});
		return res;
	}
}
