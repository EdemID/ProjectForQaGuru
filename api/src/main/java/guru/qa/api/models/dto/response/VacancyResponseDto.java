package guru.qa.api.models.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.HashMap;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VacancyResponseDto {

    private String name;
    private HashMap<String, String> area;
    @JsonProperty("alternate_url")
    private String alternateUrl;
}
