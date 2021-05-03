package de.viadee.parkhaus.manager.resource;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;

@QuarkusTest
@Tag("integration")
@QuarkusTestResource(H2DatabaseTestResource.class)
public class ParkticketResourceTest {

    @Inject
    ParkticketResource parkticketResource;

    @Test
    public void testCreateEndpoint() {
        given().queryParam("entered", "2020-01-31T18:00")
                .post("/parkticket")
                .then().statusCode(200);
    }
}
