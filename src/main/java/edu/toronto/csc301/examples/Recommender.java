package edu.toronto.csc301.examples;

import java.util.List;

public interface Recommender {

	
	List<User> recommendPotentialFollowees(User targetUser);
	
}
