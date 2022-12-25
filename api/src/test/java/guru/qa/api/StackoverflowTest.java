package guru.qa.api;

import guru.qa.api.models.dto.response.StackoverflowResponseDto;
import guru.qa.api.requests.steps.StackoverflowSteps;
import guru.qa.api.util.StringEditor;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("API")
public class StackoverflowTest {

    private  StackoverflowSteps steps = new StackoverflowSteps();

    @ParameterizedTest(name = "Bookmark post on Stackoverflow: {0}")
    @ValueSource(strings = {
            "https://stackoverflow.com/questions/74913906/update-ids-values-by-sorted-timestamp-with-sql",
            "https://stackoverflow.com/questions/48378897/rest-assured-vs-cucumber"
    })
    void savePost(String postUrl) {
        postUrl = StringEditor.editPostUrl(postUrl);
        Response loginResponse = steps.logIn();
        steps.setCookies(loginResponse.cookies());
        steps.getKeyFromJavascriptElementOnPage(postUrl);
        StackoverflowResponseDto saveResponse = steps.saveBookmarkPost(postUrl);

        Assertions.assertTrue(saveResponse.isSuccess());

        steps.removePostFromBookmark(postUrl);
    }
}
