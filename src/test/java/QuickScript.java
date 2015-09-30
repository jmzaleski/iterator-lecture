import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
			// Get all elements into a list
			List<User> potentialFollowees = new ArrayList<User>();
			while (recommendation.hasNext()) {
				potentialFollowees.add(recommendation.next());
			}
			
			// Shuffle ...
			Collections.shuffle(potentialFollowees);
			// Keep only the first 3 users
			while(potentialFollowees.size() > 3){
				potentialFollowees.remove(0);
			}
			System.out.println("  " + potentialFollowees);
		}
		
	}

}
