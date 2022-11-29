package guru.qa.api.util;

public class StringEditor {

    public static String editPostUrl(String postUrl) {
        postUrl = postUrl.replace("questions", "posts");
        int lastIndex = postUrl.lastIndexOf("/");
        return postUrl.substring(0, lastIndex);
    }
}
