package guru.qa.api.models.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StackoverflowResponseDto {

    @JsonProperty("Success")
    private boolean success;
    @JsonProperty("IsUndo")
    private boolean isUndo;
    @JsonProperty("NextTooltip")
    private String nextTooltip;
    @JsonProperty("ToastMessage")
    private String toastMessage;

}
