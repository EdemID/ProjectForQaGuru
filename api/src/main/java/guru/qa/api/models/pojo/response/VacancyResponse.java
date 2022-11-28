package guru.qa.api.models.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.HashMap;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VacancyResponse {

    private String name;
    private HashMap<String, String> area;
    @JsonProperty("alternate_url")
    private String alternateUrl;
}
