package yongs.temp.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import yongs.temp.dao.UserDao;
import yongs.temp.vo.User;

@WebService(targetNamespace="http://soap.yongs")
public class UserSoapEndpoint {
	private static final Logger logger = LoggerFactory.getLogger(UserSoapEndpoint.class);
	@Autowired
	private UserDao userDao;

    @WebMethod
    public User get(@WebParam(name="username") String username) {
    	logger.debug("UserSoapEndpoint ==> " + username);
        return userDao.findUser(username);
    }
}
