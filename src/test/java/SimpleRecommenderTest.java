import static org.junit.Assert.*;

import java.util.Iterator;

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
		assertFalse(recommender.recommendPotentialFollowees(testUsers[0]).hasNext());
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
		
		Iterator<User> result = recommender.recommendPotentialFollowees(targetUser);
		
		assertTrue(result.hasNext());
		assertEquals(potentialFollowee, result.next());
		assertFalse(result.hasNext());
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
		
		Iterator<User> result = recommender.recommendPotentialFollowees(targetUser);
		
		assertTrue(result.hasNext());
		assertEquals(potentialFollowee1, result.next());
		assertTrue(result.hasNext());
		assertEquals(potentialFollowee2, result.next());
		assertTrue(result.hasNext());
		assertEquals(potentialFollowee3, result.next());
		assertFalse(result.hasNext());
	}
	
	
	@Test
	public void testAddRemoveSingleFollowee() {
		User targetUser = testUsers[0];
		User potentialFollowee = testUsers[1];
		
		recommender.addPotentialFollowee(targetUser , potentialFollowee);
		recommender.removePotentialFollowee(targetUser, potentialFollowee);
		
		assertFalse(recommender.recommendPotentialFollowees(targetUser).hasNext());
	}
	
	
}
