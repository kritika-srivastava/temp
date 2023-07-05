package com.stackroute.userRepository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.stackroute.model.User;

@Repository
public interface userRepository {

	List<User> userList();

	void addUser(User user);

}
