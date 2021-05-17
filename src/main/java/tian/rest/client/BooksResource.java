package tian.rest.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/books")
public class BooksResource {

    @Inject
    @RestClient
    BooksService booksService;


    @GET
    @Path("/volume/{query}")
    public Book name(@PathParam String query) {
        System.out.println("test");
        return booksService.getByName(query);
    }


}
