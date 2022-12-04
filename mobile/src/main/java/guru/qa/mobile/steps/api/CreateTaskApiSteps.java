package guru.qa.mobile.steps.api;

import guru.qa.mobile.models.dto.requests.TaskRequest;
import guru.qa.mobile.models.dto.responses.TaskResponse;
import io.qameta.allure.Step;

import static guru.qa.mobile.helpers.TaskSpecs.*;
import static io.restassured.RestAssured.given;

public class CreateTaskApiSteps {

    @Step("API: Создать новую задачу с параметрами")
    public static TaskResponse createNewTaskViaApi(String content, String description, String due) {
        TaskRequest request = new TaskRequest();
        request.setContent(content);
        request.setDescription(description);
        request.setDueString(due);

        return createNewTaskViaApi(request);
    }

    public static TaskResponse createNewTaskViaApi(TaskRequest request) {

        return given()
                .spec(taskRequestSpec)
                .body(request)
                .when()
                .post()
                .then()
                .spec(taskResponseSpec)
                .extract()
                .as(TaskResponse.class);
    }

    @Step("API: Создать новую задачу без задания обязательного параметра 'content'")
    public static String newTaskCreationWithError(String description, String due) {
        TaskRequest request = new TaskRequest();
        request.setDescription(description);
        request.setDueString(due);

        String response = given()
                .spec(taskRequestSpec)
                .body(request)
                .when()
                .post()
                .then()
                .spec(errorResponseSpec)
                .extract().body().asString();

        return response;
    }
}
