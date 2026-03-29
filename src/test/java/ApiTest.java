import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiTest {

    @Test
    public void testAccountsResponseMatchesSchema() {
        RestAssured.given()
                .when()
                .get("http://localhost:9999/api/v1/demo/accounts")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }
}
