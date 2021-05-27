package tian.books.rest.client;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import io.quarkus.oidc.client.filter.OidcClientFilter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RegisterRestClient(configKey="oidc-client")
@OidcClientFilter
@Path("/")
public interface OidcClient {

    @GET
    String getUserName();

    @GET
    String getAccessToken();
}
