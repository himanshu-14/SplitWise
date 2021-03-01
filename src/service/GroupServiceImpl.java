package service;

import java.util.ArrayList;
import java.util.Arrays;

import billsharing.model.UserGroup;
import billsharing.repository.GroupRepository;

public class GroupServiceImpl {
	public static void createGroup(String groupName, String... userList) {
		GroupRepository.groupMap.put(groupName,
				new UserGroup(groupName, new ArrayList<String>(Arrays.asList(userList))));
	}

}
