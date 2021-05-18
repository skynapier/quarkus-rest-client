package tian.rest.client;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.concurrent.CompletionStage;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/v1")
@RegisterRestClient(configKey="google-book-api")
public interface BooksService {

    @GET
    @Path("/volumes")
    @Produces("application/json")
    CompletionStage<Book> getEbooksAsUni(
            @NotNull
            @QueryParam("q")
            String q,

            @QueryParam("filter")
            String filtering,

            @QueryParam("printType")
            String printType,

            @QueryParam("projection")
            String projection,

            @QueryParam("orderby")
            String sorting

    );


}
