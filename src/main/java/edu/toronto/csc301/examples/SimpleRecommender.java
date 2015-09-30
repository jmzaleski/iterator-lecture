package edu.toronto.csc301.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SimpleRecommender implements Recommender {


	private Map<User, List<User>> userToPotentialFollowees = new HashMap<User, List<User>>();
	
	
	@Override
	public Iterator<User> recommendPotentialFollowees(User targetUser) {
		Objects.requireNonNull(targetUser);
		return userToPotentialFollowees.getOrDefault(
				targetUser, Collections.emptyList()).iterator();
	}
	
	
	public void addPotentialFollowee(User targetUser, User potentialFollowee){
		if(! userToPotentialFollowees.containsKey(targetUser)){
			userToPotentialFollowees.put(targetUser, new ArrayList<User>());
		}
		List<User> potentialFollowees = userToPotentialFollowees.get(targetUser);
		if(! potentialFollowees.contains(potentialFollowee)){
			potentialFollowees.add(potentialFollowee);
		}
	}
	
	public void removePotentialFollowee(User targetUser, User potentialFollowee){
		if(userToPotentialFollowees.containsKey(targetUser)){
			userToPotentialFollowees.get(targetUser).remove(potentialFollowee);
		}
	}

}
