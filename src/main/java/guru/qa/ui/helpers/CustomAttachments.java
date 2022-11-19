package guru.qa.ui.helpers;

import guru.qa.ui.config.DriverConfig;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static guru.qa.ui.utils.Util.getSessionId;

public class CustomAttachments {

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/html")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideoAsHtml() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getVideoUrl()
                + "' type='video/mp4'></video></body></html>";
    }

    public static URL getVideoUrl() {
        String videoUrl = String.format("https://%svideo/%s.mp4", DriverConfig.config.remoteDriverUrl(), getSessionId());

        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addVideoAsInputStream() {
        URL videoUrl = getVideoUrl();
        if (videoUrl != null) {
            InputStream videoInputStream = null;
            sleep(1000);

            for (int i = 0; i < 20; i++) {
                try {
                    videoInputStream = videoUrl.openStream();
                    break;
                } catch (FileNotFoundException e) {
                    sleep(1000);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (videoInputStream != null) {
                Allure.addAttachment("Video", "video/mp4", videoInputStream, "mp4");

                Allure.addAttachment("Video", "video/webm", videoInputStream, "webm");
            }
        }
    }
}
