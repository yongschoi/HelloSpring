package yongs.temp.ws;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import yongs.temp.dao.UserDao;
import yongs.temp.vo.User;
@Path("/user")
@Produces("application/json")
@Service("userService")
public class UserRestImpl implements UserRest {
	private static final Logger logger = LoggerFactory.getLogger(UserRestImpl.class);
	@Autowired
	private UserDao userDao;

	public User get(String username) {
		User user = null;
		try {
			user = userDao.findUser(username);
		} catch (EmptyResultDataAccessException erda) {
			user = new User("null", "null", 0);
		}
		return user;
	}
}
