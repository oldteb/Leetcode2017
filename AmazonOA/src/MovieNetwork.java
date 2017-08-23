package oldteb.leetcode2017.amazonOA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class MovieNetwork {
	
	public List<Movie> getNearest(Movie movie, int numSimilar){
		List<Movie> rst = new ArrayList<Movie>();
		if(movie == null || numSimilar == 0)  return rst;
		
		Set<Integer> visited = new HashSet<Integer>();
		PriorityQueue<Movie> minHeap = new PriorityQueue<Movie>(numSimilar, new Comparator<Movie>(){
			public int compare(Movie m1, Movie m2){
				if(m1.rating == m2.rating)  return 0;
				else if(m1.rating < m2.rating)  return -1;
				else return 1;
			}
		});
		
		dfs(movie, movie, numSimilar, visited, minHeap);
		
		while(minHeap.size() != 0){
			rst.add(minHeap.poll());
		}
		
		return rst;
	}
	
	
	public void dfs(Movie movie, Movie root, int numSimilar, Set<Integer> visited, PriorityQueue<Movie> minHeap){
		if(movie == null)  return;
		if(visited.contains(movie.movieId))  return;
		visited.add(movie.movieId);
		if(root != movie){
			minHeap.offer(movie);
			if(minHeap.size() > numSimilar)
				minHeap.poll();
		}
		for(Movie mv : movie.similarMovies){
			dfs(mv, root, numSimilar, visited, minHeap);
		}
		return;
	}
	
	
	public class Movie {
		int movieId;
		float rating;
		List<Movie> similarMovies = new ArrayList<Movie>();
		
		public Movie(){
		}
		
		public Movie(int movieId, float rating){
			this.movieId = movieId;
			this.rating = rating;
		}
		
		public void addSimilarMovie(Movie mv){
			similarMovies.add(mv);
		}
		
	}
}
