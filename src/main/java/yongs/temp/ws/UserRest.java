package yongs.temp.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import yongs.temp.vo.User;

public interface UserRest {
	@GET
    @Path("/{username}")
	public User get(@PathParam("username") String username);
}
