package guru.qa.api;

import guru.qa.api.models.dto.response.StackoverflowResponseDto;
import guru.qa.api.requests.steps.StackoverflowSteps;
import guru.qa.api.util.StringEditor;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

@Tag("API")
public class StackoverflowTest {

    @ParameterizedTest(name = "Bookmark post on Stackoverflow: {0}")
    @ValueSource(strings = "https://stackoverflow.com/questions/48378897/rest-assured-vs-cucumber")
    void savePost(String postUrl) {
        postUrl = StringEditor.editPostUrl(postUrl);

        Response loginResponse = StackoverflowSteps.logIn();
        Map<String, String> cookies = loginResponse.cookies();

        String fkey = StackoverflowSteps.getKeyFromJavascriptElementOnPage(cookies, postUrl);
        StackoverflowResponseDto saveResponse = StackoverflowSteps.saveBookmarkPost(cookies, fkey, postUrl);

        Assertions.assertTrue(saveResponse.isSuccess());

        StackoverflowSteps.removePostFromBookmark(cookies, fkey, postUrl);
    }
}
