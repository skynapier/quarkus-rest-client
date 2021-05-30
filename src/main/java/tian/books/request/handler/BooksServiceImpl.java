package tian.books.request.handler;

import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import tian.books.rest.client.BooksClient;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class BooksServiceImpl implements BooksService{

    @Inject
    @RestClient
    BooksClient booksClient;

    @Inject
    SecurityIdentity securityIdentity;


    private static final Logger LOGGER = Logger.getLogger(BooksService.class);

    @Override
    @RolesAllowed("books")
    public Response getBooks(String query, String filtering, String printType, String projection, String sorting) {
        LOGGER.info("access with role " + securityIdentity.getRoles());

        return Response.ok( booksClient.getGoogleEbooks(query, filtering, printType, projection,sorting)).build();

    }
}
