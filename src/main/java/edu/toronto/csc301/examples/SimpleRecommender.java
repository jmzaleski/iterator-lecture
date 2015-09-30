package edu.toronto.csc301.examples;

import java.util.List;
import java.util.Objects;

public class SimpleRecommender implements Recommender {


	@Override
	public List<User> recommendPotentialFollowees(User targetUser) {
		Objects.requireNonNull(targetUser);
		return null;
	}
	
	
	public void addPotentialFollowee(User targetUser, User potentialFollowee){
		// TODO: Implement
	}
	
	public void removePotentialFollowee(User targetUser, User potentialFollowee){
		// TODO: Implement
	}

}
