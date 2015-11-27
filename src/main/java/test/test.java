package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by Peonsson on 27/11/15.
 */
@Path("/test")
public class test {

    @GET
    public String getTest() {
        return "Hello World!";
    }
}