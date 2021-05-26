package tian.books.request.handler;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
//import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
//import io.quarkus.oidc.client.filter.OidcClientFilter;


//@RegisterRestClient
//@OidcClientFilter
@Path("/google-books")
public interface BooksService {

    @GET
    @Produces("application/json")
    @APIResponse(responseCode = "200")
    @APIResponse(responseCode = "400", description = "Unable to process input")
    @APIResponse(responseCode = "401", description = "Unauthorized")
    @APIResponse(responseCode = "500", description = "Server Error")
    @Path("/volume/{query}")
    public Response getBooks(
            @PathParam
                    String query,

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
