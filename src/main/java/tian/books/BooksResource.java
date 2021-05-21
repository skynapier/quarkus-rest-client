package tian.books;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tian.books.rest.client.BooksClient;

@Path("/books")
public class BooksResource {

    @Inject
    @RestClient
    BooksClient booksClient;

    private static final Logger LOGGER = Logger.getLogger(BooksResource.class);

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
            ){

//        booksClient.getGoogleEbooks(query, filtering,printType, projection,sorting);
        return Response.ok( booksClient.getGoogleEbooks(query, filtering, printType, projection,sorting)).build();
//        return  Response.ok().build();
    }




}
