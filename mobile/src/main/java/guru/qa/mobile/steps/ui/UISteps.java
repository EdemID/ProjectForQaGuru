package guru.qa.mobile.steps.ui;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static guru.qa.mobile.interfaces.Props.PROPS;

public class UISteps {

    @Step("Авторизация в приложении")
    public static void login() {
        String email = PROPS.email();
        String pwd = PROPS.password();
        $(AppiumBy.id("com.todoist:id/btn_welcome_email")).click();
        $(AppiumBy.id("com.todoist:id/email_exists_input")).sendKeys(email);
        $(AppiumBy.id("com.todoist:id/btn_continue_with_email")).click();
        $(AppiumBy.id("com.todoist:id/log_in_password")).sendKeys(pwd);
        $(AppiumBy.id("com.todoist:id/btn_log_in")).click();

        if ($(AppiumBy.id("com.todoist:id/action_bar_root")).exists()) {
            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")).click();
        }
//        $(AppiumBy.id("com.todoist:id/toolbar")).should(Condition.exist);
    }

    @Step("Создать новую задачу")
    public static void createNewTaskStep(String taskTitle, String taskDescription) {
        $(AppiumBy.id("com.todoist:id/fab")).click();
        $(AppiumBy.id("android:id/message")).should(Condition.appear);
        $(AppiumBy.id("android:id/message")).sendKeys(taskTitle);
        $(AppiumBy.id("com.todoist:id/description")).sendKeys(taskDescription);
        $(AppiumBy.id("com.todoist:id/menu_live_notifications")).click();
        $(AppiumBy.id("com.todoist:id/item")).click();
    }
}
