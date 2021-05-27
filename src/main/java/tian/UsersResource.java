package tian;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.cache.NoCache;
import io.quarkus.security.identity.SecurityIdentity;
import tian.books.request.handler.BooksService;
import tian.books.rest.client.OidcClient;

@Path("/api/users")
public class UsersResource {

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    JsonWebToken jwt;

    @Inject
    @RestClient
    OidcClient oidcClient;

    private static final org.jboss.logging.Logger LOGGER = Logger.getLogger(UsersResource.class);

    @GET
    @Path("/me")
    @RolesAllowed("books")
    @NoCache
    public User me() {
        return new User(securityIdentity);
    }

    @GET
    @Path("/jwt-me")
    @RolesAllowed("user")
    @Produces(MediaType.TEXT_PLAIN)
    public String admin() {
        LOGGER.info("get rest client for oidc " + oidcClient.getUserName());
        LOGGER.info("get rest client for oidc " + oidcClient.getUserName());
        LOGGER.info("get rest client for oidc " + securityIdentity.getPrincipal().getName());
        return "Access for subject " + jwt.getSubject() + " is granted";
    }

    public static class User {

        private final String userName;

        User(SecurityIdentity securityIdentity) {
            this.userName = securityIdentity.getPrincipal().getName();
        }

        public String getUserName() {
            return userName;
        }
    }
}