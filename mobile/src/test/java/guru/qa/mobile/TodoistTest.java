package guru.qa.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import guru.qa.mobile.steps.api.CreateTaskApiSteps;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static guru.qa.mobile.steps.api.DeleteTaskApiSteps.clearAllTasks;
import static guru.qa.mobile.steps.ui.UISteps.createNewTaskStep;
import static guru.qa.mobile.steps.ui.UISteps.login;
import static io.qameta.allure.Allure.step;

@Tag("Mobile")
@Epic("Mobile testing todoist")
@Feature("Задачи на 'Сегодня'")
public class TodoistTest extends BaseTest{

    @Test
    @Story("Создание задач")
    @DisplayName("Создание новой задачи")
    public void taskCreationTest() {
        login();
        String taskTitle = "title";
        String taskDescription = "description";

        createNewTaskStep(taskTitle, taskDescription);

        step("Проверить создание задачи", () -> {
            $(AppiumBy.id("com.todoist:id/text")).shouldHave(Condition.text(taskTitle));
            $(AppiumBy.id("com.todoist:id/description")).shouldHave(Condition.text(taskDescription));
        });
    }

    @Test
    @Story("Завершение задач")
    @DisplayName("Завершение существующей задачи")
    public void taskCompletionTest() {
        String taskTitle = "title";
        String taskDescription = "description";
        String taskDue = "Сегодня";

        CreateTaskApiSteps.createNewTaskViaApi(taskTitle, taskDescription, taskDue);

        login();
        step("Завершаем задачу", () -> {
            $(AppiumBy.id("com.todoist:id/checkmark")).click();
        });

        step("Проверяем, что задача исчезла из списка задач на Сегодня", () -> {
            $(AppiumBy.id("com.todoist:id/item")).shouldNot(Condition.exist);
        });
    }

    @Test
    @Story("Удаление задач")
    @DisplayName("Удаление существующей задачи")
    public void taskDeletionTest() {
        String taskTitle = "title";
        String taskDescription = "description";
        String taskDue = "Сегодня";

        CreateTaskApiSteps.createNewTaskViaApi(taskTitle, taskDescription, taskDue);

        login();
        step("Удаляем задачу", () -> {
            $(AppiumBy.id("com.todoist:id/text")).click();
            $(AppiumBy.id("com.todoist:id/item_overflow")).click();
            $(AppiumBy.id("com.todoist:id/delete")).click();
            $(AppiumBy.id("android:id/button1")).click();
        });

        step("Проверяем, что задача исчезла из списка задач на Сегодня", () -> {
            $(AppiumBy.id("com.todoist:id/item")).shouldNot(Condition.exist);
        });
    }

    @Test
    @Story("Редактирование задач")
    @DisplayName("Редактирование существующей задачи")
    public void taskEditionTest() {
        String taskTitle = "title";
        String taskDescription = "description";
        String taskDue = "Сегодня";

        CreateTaskApiSteps.createNewTaskViaApi(taskTitle, taskDescription, taskDue);

        login();
        String title2 = "title2";
        String description2 = "description2";

        step("Редактируем задачу", () -> {
            $(AppiumBy.id("com.todoist:id/text")).click();
            $(AppiumBy.id("com.todoist:id/item_content")).click();
            $(AppiumBy.id("com.todoist:id/item_content")).sendKeys(title2);
            $(AppiumBy.id("com.todoist:id/item_description")).sendKeys(description2);
            $(AppiumBy.id("com.todoist:id/item_submit")).click();
        });

        step("Проверяем, что задача отредактирована", () -> {
            $(AppiumBy.id("com.todoist:id/item_content")).shouldHave(Condition.text(title2));
            $(AppiumBy.id("com.todoist:id/item_description")).shouldHave(Condition.text(description2));
            Selenide.back();
            $(AppiumBy.id("com.todoist:id/text")).shouldHave(Condition.text(title2));
            $(AppiumBy.id("com.todoist:id/description")).shouldHave(Condition.text(description2));
        });
    }

    @AfterEach
    void cleanup() {
        clearAllTasks();
    }
}
