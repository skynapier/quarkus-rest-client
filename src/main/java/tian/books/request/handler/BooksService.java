package tian.books.request.handler;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/google-books")
public interface BooksService {

    @GET
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
