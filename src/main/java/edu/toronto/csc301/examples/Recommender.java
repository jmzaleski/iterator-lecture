package edu.toronto.csc301.examples;

import java.util.Iterator;

public interface Recommender {

	
	Iterator<User> recommendPotentialFollowees(User targetUser);
	
}
