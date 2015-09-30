import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.toronto.csc301.examples.SimpleRecommender;
import edu.toronto.csc301.examples.User;


public class SimpleRecommenderTest {

	private static User[] testUsers = {
		new User("Alice",   "alice@test.com"),
		new User("Bob",     "bob@test.com"),
		new User("Charlie", "charlie@test.com"),
		new User("David",   "david@test.com"),
		new User("Eva",     "eva@test.com"),
		new User("Frank",   "frank@test.com")
	};
	
	
	private SimpleRecommender recommender;
	

	@Before
	public void setup(){
		recommender = new SimpleRecommender();
	}
	
	
	// Sanity tests ...
	
	@Test
	public void testEmptyRecommender() {
		assertEquals(0, recommender.recommendPotentialFollowees(testUsers[0]).size());
	}
	
	@Test(expected=NullPointerException.class)
	public void testNullHandling() {
		recommender.recommendPotentialFollowees(null);
	}

	
	// Basic tests ...
	
	@Test
	public void testAddSingleFollowee() {
		User targetUser = testUsers[0];
		User potentialFollowee = testUsers[1];
		
		recommender.addPotentialFollowee(targetUser , potentialFollowee);
		
		List<User> result = recommender.recommendPotentialFollowees(targetUser);
		
		assertEquals(1, result.size());
		assertEquals(potentialFollowee, result.get(0));
	}
	
	
	@Test
	public void testAddingMultipleFollowees() {
		User targetUser = testUsers[0];
		User potentialFollowee1 = testUsers[1];
		User potentialFollowee2 = testUsers[2];
		User potentialFollowee3 = testUsers[3];
		
		recommender.addPotentialFollowee(targetUser , potentialFollowee1);
		recommender.addPotentialFollowee(targetUser , potentialFollowee2);
		recommender.addPotentialFollowee(targetUser , potentialFollowee3);
		
		List<User> result = recommender.recommendPotentialFollowees(targetUser);
		
		assertEquals(3, result.size());
		assertEquals(potentialFollowee1, result.get(0));
		assertEquals(potentialFollowee2, result.get(1));
		assertEquals(potentialFollowee3, result.get(2));
	}
	
	
	@Test
	public void testAddRemoveSingleFollowee() {
		User targetUser = testUsers[0];
		User potentialFollowee = testUsers[1];
		
		recommender.addPotentialFollowee(targetUser , potentialFollowee);
		recommender.removePotentialFollowee(targetUser, potentialFollowee);
		
		assertEquals(0, recommender.recommendPotentialFollowees(targetUser).size());
	}
	
	
}
