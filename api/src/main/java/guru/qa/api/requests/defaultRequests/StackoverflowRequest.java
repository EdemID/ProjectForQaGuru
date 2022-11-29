package guru.qa.api.requests.defaultRequests;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class StackoverflowRequest {

    /**
     * Confirm previous action
     */
    public static void confirmPreviousAction(Map<String, String> cookies) {
        given()
                .log().uri()
                .contentType("text/plain;charset=UTF-8")
                .cookies(cookies)
                .post("https://stackoverflow.com/gps/event");
    }
}
