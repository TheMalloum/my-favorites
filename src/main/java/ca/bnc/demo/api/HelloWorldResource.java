package ca.bnc.demo.api;

import org.jboss.resteasy.annotations.cache.Cache;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;


/**
 * Hello World rest api using resteasy
 *
 * @author Ramesh Fadatare
 */

//

//The max-age directive states the maximum amount of time in seconds that fetched responses
// are allowed to be used again (from the time when a request is made).
// For instance, max-age=90 indicates that an asset can be reused
// (remains in the browser cache) for the next 90 seconds


@Path("hello")
public class HelloWorldResource {


    @PermitAll
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") String id, HelloWorld helloWorld) {


        UserDatabase.update(id, helloWorld);
        return Response.ok(helloWorld).build();
    }

    @PermitAll
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Cache(maxAge=10, sMaxAge = 10)
    public Response get(@PathParam("id") String id) {


        HelloWorld helloWorld = UserDatabase.get(id);

        if (helloWorld == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(helloWorld).build();
    }


    @PermitAll
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        return Response.ok(UserDatabase.users).build();
    }


    @PermitAll
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(HelloWorld helloWorld) {
        return put(UUID.randomUUID().toString(), helloWorld);
    }


    @PermitAll
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id) {

        HelloWorld helloWorld = UserDatabase.get(id);

        if (helloWorld == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        UserDatabase.remove(id);
        return Response.ok().build();
    }
}