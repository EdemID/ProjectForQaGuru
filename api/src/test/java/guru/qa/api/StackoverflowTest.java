package guru.qa.api;

import guru.qa.api.models.pojo.response.StackoverflowResponse;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

@Tag("API")
public class StackoverflowTest {

    @Test
    void savePost() {
        String postUrl = "https://stackoverflow.com/questions/48378897".replace("questions", "posts");

        Response loginResponse = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("email", "reset.limbo@gmail.com")
                .formParam("password", "qw12as34zx!@")
                .when()
                .log().uri()
                .post("https://stackoverflow.com/users/login")
                .then()
                .extract().response();

        var stackoverflowPostAsHtmlResponse = given()
                .log().uri()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookies(loginResponse.cookies())
                .post(postUrl);

        Document DOM = Jsoup.parse(stackoverflowPostAsHtmlResponse.prettyPrint());
        Element element = DOM.body().selectXpath("//script[@data-module-name='Shared/options.mod']").first();
        List<Node> childNodes = element.childNodes();
        String valueFromScript = childNodes.get(0).toString();

        JSONObject jsonpObject = new JSONObject(valueFromScript);
        String fkey = jsonpObject.getJSONObject("options").getJSONObject("user").getString("fkey");

        StackoverflowResponse saveResponse = given()
                .log().uri()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("fkey=" + fkey)
                .cookies(loginResponse.cookies())
                .post(postUrl + "/save")
                .then().log().body()
                .extract().as(StackoverflowResponse.class);

        given()
                .log().uri()
                .contentType("text/plain;charset=UTF-8")
                .cookies(loginResponse.cookies())
                .post("https://stackoverflow.com/gps/event")
                .then().log().headers().log().body();

        Assertions.assertTrue(saveResponse.isSuccess());
    }
}
