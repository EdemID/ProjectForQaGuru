package guru.qa.api;

import guru.qa.api.models.dto.response.VacancyResponseDto;
import guru.qa.api.specs.VacancySpec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("API")
public class HeadHunterTest {

    @Test
    @DisplayName("Check vacancy name and area")
    void getVacancies() {
        List<VacancyResponseDto> vacancies = given()
                .spec(VacancySpec.vacancyRequestSpec)
                .when()
                .get("?text=qa&search_field=name&experience=between1And3&area=1")
                .then()
                .spec(VacancySpec.vacancyResponseSpec)
                .extract()
                .body()
                .jsonPath().getList("items", VacancyResponseDto.class);

        vacancies.forEach(vacancy -> {
            assertThat(vacancy.getName()).contains("QA");

            assertThat(vacancy.getArea().get("name")).contains("Москва");
        });
    }
}
