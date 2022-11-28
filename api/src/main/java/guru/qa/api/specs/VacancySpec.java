package guru.qa.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static guru.qa.api.helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class VacancySpec {

    public static RequestSpecification vacancyRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://api.hh.ru")
            .basePath("/vacancies")
            .log().uri();

    public static ResponseSpecification vacancyResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
}
