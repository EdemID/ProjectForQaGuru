package guru.qa.mobile.helpers;

import static guru.qa.mobile.interfaces.Props.PROPS;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    public static String videoUrlFromBrowserstack(String sessionId) {
        String url = format("%s/%s.json", PROPS.browserstackSessionsUrl(), sessionId);

        return given()
                .log().all()
                .auth().basic(PROPS.browserstackUserName(), PROPS.browserstackPassword())
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }

}
