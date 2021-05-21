package tian.rest.client;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.json.*;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(WiremockBooks.class)
public class BooksTest {


    @Test
    public void testGetBookEndpoint() {
        given()
                .when().get("/google-books/volume/f280CwAAQBAJ")
                .then()
                .statusCode(200)

                .body("kind", is("books#volumes"),
                        "totalItems", is(1),
                        "items[0].volumeInfo.title", is("Harry Potter: The Complete Collection (1-7)")

                ) ;

    }
}
