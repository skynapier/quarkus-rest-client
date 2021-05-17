package tian.rest.client;

import java.util.Set;
import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/v1")
@RegisterRestClient(configKey="google-book-api")
public interface BooksService {

    @GET
    @Path("/volumes")
    @Produces("application/json")
    Book getByName(@QueryParam("q") String q);

//    @GET
//    @Path("/name/{name}")
//    @Produces("application/json")
//    CompletionStage<Set<Book>> getByNameAsync(@PathParam String name);
//
//    @GET
//    @Path("/name/{name}")
//    @Produces("application/json")
//    Uni<Set<Book>> getByNameAsUni(@PathParam String name);

}
