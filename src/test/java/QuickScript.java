import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.toronto.csc301.examples.FilteringIterator;
import edu.toronto.csc301.examples.Recommender;
import edu.toronto.csc301.examples.SimpleRecommender;
import edu.toronto.csc301.examples.User;


public class QuickScript {

	private static User targetUser = new User("alice", "alice@test.com");
	
	private static Recommender createRecommender(){
		SimpleRecommender r = new SimpleRecommender();
		for (int i = 1; i < 21; i++) {
			r.addPotentialFollowee(targetUser, new User("test-user-" + i, "user-" + i + "@test.com"));
		}
		return r;
	}
	
	
	

	public static void main(String[] args) {
		
		Recommender r = createRecommender();
		// Let's try to make things interesting ...
		
		// Display (possibly) different recommendations every time 
		for (int i = 1; i < 6; i++) {
			System.out.println("Recommendation " + i);
			
			// Get an iterator of recommended users
			Iterator<User> recommendation = r.recommendPotentialFollowees(targetUser);
			
			// Wrap it in another iterator that selects 3 arbitrary items
			recommendation = new FilteringIterator<User>(recommendation, 3);
			
			// Now, get all the elements into a list and print the list
			List<User> potentialFollowees = new ArrayList<User>();
			while (recommendation.hasNext()) {
				potentialFollowees.add(recommendation.next());
			}
			System.out.println("  " + potentialFollowees);
		}
		
	}

}
