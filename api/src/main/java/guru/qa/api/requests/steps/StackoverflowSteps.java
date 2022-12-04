package guru.qa.api.requests.steps;

import guru.qa.api.models.dto.response.StackoverflowResponseDto;
import guru.qa.api.requests.defaultRequests.StackoverflowRequest;
import guru.qa.api.util.JSONParser;
import guru.qa.api.util.JSOUPParser;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class StackoverflowSteps {

    @Step("Log in")
    public static Response logIn() {
        return given()
                .log().uri()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("email", "reset.limbo@gmail.com")
                .formParam("password", "qw12as34zx!@")
                .when()
                .post("https://stackoverflow.com/users/login")
                .then()
                .extract().response();
    }

    @Step("Get Stackoverflow post as HTML")
    private static Response getStackoverflowPostAsHtml(Map<String, String> cookies, String postUrl) {
        return given()
                .log().uri()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookies(cookies)
                .post(postUrl);
    }

    @Step("Get key from javascript element on page")
    public static String getKeyFromJavascriptElementOnPage(Map<String, String> cookies, String postUrl) {
        Response stackoverflowPostAsHtmlResponse = getStackoverflowPostAsHtml(cookies, postUrl);
        String scriptContent = JSOUPParser.parsingJavascriptElement(stackoverflowPostAsHtmlResponse.prettyPrint());

        return JSONParser.getKeyFromScriptContentFormatJson(scriptContent);
    }

    @Step("Bookmark post")
    public static StackoverflowResponseDto saveBookmarkPost(Map<String, String> cookies, String fkey, String postUrl) {
        StackoverflowResponseDto dto = given()
                .log().uri()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookies(cookies)
                .body("fkey=" + fkey)
                .post(postUrl + "/save")
                .then().log().body()
                .extract().as(StackoverflowResponseDto.class);

        StackoverflowRequest.confirmPreviousAction(cookies);

        return dto;
    }

    @Step("Remove post from bookmark")
    public static void removePostFromBookmark(Map<String, String> cookies, String fkey, String postUrl) {
        given()
                .log().uri()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookies(cookies)
                .body("fkey=" + fkey)
                .post(postUrl + "/save?isUndo=true");

        StackoverflowRequest.confirmPreviousAction(cookies);
    }
}
