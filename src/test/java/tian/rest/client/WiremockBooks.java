package tian.rest.client;

import java.util.Collections;
import java.util.Map;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WiremockBooks implements QuarkusTestResourceLifecycleManager{
    private WireMockServer wireMockServer;

    @Override
    public Map<String, String> start() {
        wireMockServer = new WireMockServer();
        wireMockServer.start();

        stubFor(get(urlEqualTo("/v1/volumes?q=f280CwAAQBAJ&printType=all&projection=full&orderby=relevance"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(
                                "{" +
                                        "\"kind\": \"books#volumes\"," +
                                        "\"totalItems\": 1," +
                                        "\"items\": [{" +
                                        "\"volumeInfo\":{  " +
                                        "\"title\": \"Harry Potter: The Complete Collection (1-7)\"" +
                                        "}" +
                                        "}]" +
                                        "}"
                        )));

//        stubFor(get(urlMatching(".*")).atPriority(10).willReturn(aResponse().proxiedFrom("https://www.googleapis.com/books")));

        return Collections.singletonMap("google-book-api/mp-rest/url", wireMockServer.baseUrl());
    }

    @Override
    public void stop() {
        if (null != wireMockServer) {
            wireMockServer.stop();
        }
    }
}
