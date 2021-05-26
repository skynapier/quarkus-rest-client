package tian.books.rest.client;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import tian.books.Book;

@Path("/v1")
@RegisterRestClient(configKey="google-book-api")
public interface BooksClient {

    @GET
    @Path("/volumes")
    @Produces("application/json")
    @APIResponse(responseCode = "200")
    @APIResponse(responseCode = "400", description = "Unable to process input")
    @APIResponse(responseCode = "401", description = "Unauthorized")
    @APIResponse(responseCode = "500", description = "Server Error")
    Book getGoogleEbooks(
            @NotNull
            @QueryParam("q")
                    String q,

            @QueryParam("filter")
                    String filtering,

            @DefaultValue("all")
            @QueryParam("printType")
                    String printType,

            @DefaultValue("full")
            @QueryParam("projection")
                    String projection,

            @DefaultValue("relevance")
            @QueryParam("orderby")
                    String sorting

    );


}
