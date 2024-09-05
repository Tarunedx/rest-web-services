package com.tarun.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static Integer usercount =0;
	
	static {
		users.add(new User("Mich",++usercount,LocalDate.now().minusYears(30)));
		users.add(new User("Bryan",++usercount,LocalDate.now().minusYears(50)));
		users.add(new User("Jamie",++usercount,LocalDate.now().minusYears(45)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		user.setId(++usercount);
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		// TODO Auto-generated method stub
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
}
