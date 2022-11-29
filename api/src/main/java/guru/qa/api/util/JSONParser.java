package guru.qa.api.util;

import org.json.JSONObject;

public class JSONParser {

    public static String getKeyFromScriptContentFormatJson(String scriptContent) {
        JSONObject jsonpObject = new JSONObject(scriptContent);
        return jsonpObject.getJSONObject("options").getJSONObject("user").getString("fkey");
    }
}
