import java.util.Iterator;

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
	
	
	
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Recommender r = createRecommender();
		// Let's try to make things interesting ...
		
		// Display (possibly) different recommendations every time 
		for (int i = 1; i < 6; i++) {
			System.out.println("Recommendation " + i);
			
			// Get a list of recommended user
			Iterator<User> recommendation = r.recommendPotentialFollowees(targetUser);
			
			// Need to get 3 arbitrary users from the iterator ...
			System.out.println("  Not implemented   )-:");
		}
		
	}

}
