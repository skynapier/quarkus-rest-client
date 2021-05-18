package tian.rest.client;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.concurrent.CompletionStage;
import io.smallrye.mutiny.Uni;

@Path("/books")
public class BooksResource {

    @Inject
    @RestClient
    BooksService booksService;


    @GET
    @Path("/volume/{query}")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType
            .APPLICATION_JSON, schema = @Schema(implementation = Book.class, type = SchemaType
            .ARRAY)))
    public CompletionStage<Book> getBooks(
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


//        return Response.ok( booksService.getEbooksAsUni(query, filtering, printType, projection,sorting)).build();
        return  booksService.getEbooksAsUni(query, filtering, printType, projection,sorting) ;
    }



}
