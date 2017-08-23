package oldteb.leetcode2017.amazonOA;

import java.util.List;

import org.junit.*;
import oldteb.leetcode2017.amazonOA.MovieNetwork.Movie;

public class TestMovieNetwork {
	
	MovieNetwork instance = new MovieNetwork();
	
	@Test
	public void testSample1(){
		Movie mv0 = instance.new Movie(0,(float)2);
		Movie mv1 = instance.new Movie(1,(float)3);
		Movie mv2 = instance.new Movie(2,(float)4);
		Movie mv3 = instance.new Movie(3,(float)5);
		Movie mv4 = instance.new Movie(4,(float)6);
		
		mv0.addSimilarMovie(mv1);
		mv0.addSimilarMovie(mv2);
		mv1.addSimilarMovie(mv3);
		mv2.addSimilarMovie(mv4);
		
		List<Movie> rst = instance.getNearest(mv0, 5);
		
		for(Movie mv : rst){
			System.out.println(mv.movieId);
		}

		
		
		
	}
	
}
