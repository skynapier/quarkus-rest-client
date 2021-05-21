package tian.books.request.handler;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import tian.books.BooksResource;
import tian.books.rest.client.BooksClient;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class BooksServiceImpl implements BooksService{

    @Inject
    @RestClient
    BooksClient booksClient;

    private static final Logger LOGGER = Logger.getLogger(BooksService.class);

    @Override
    public Response getBooks(String query, String filtering, String printType, String projection, String sorting) {
        return Response.ok( booksClient.getGoogleEbooks(query, filtering, printType, projection,sorting)).build();

    }
}
