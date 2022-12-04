package guru.qa.mobile.steps.api;

import guru.qa.mobile.models.dto.responses.TaskResponse;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;

import static guru.qa.mobile.helpers.TaskSpecs.*;
import static io.restassured.RestAssured.given;

public class DeleteTaskApiSteps {

    @Step("API: Удалить все задачи из аккаунта")
    public static void clearAllTasks() {
        JsonPath response = given()
                .spec(taskRequestSpec)
                .when()
                .get()
                .then()
                .spec(taskResponseSpec)
                .extract()
                .body()
                .jsonPath();

        TaskResponse[] tasks = response.getObject("$", TaskResponse[].class);

        for (TaskResponse task : tasks) {
            deleteTask(task.getId());
        }
    }

    @Step("API: Удалить задачу")
    public static void deleteTask(Long id) {
        given()
                .spec(taskRequestSpec)
                .pathParam("id", id)
                .when()
                .delete("{id}")
                .then()
                .spec(taskDeletionResponseSpec);
    }
}
