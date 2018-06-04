package cucumber.examples.java.calculator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/*
TODO
- crear helpers para los tests
 */
public class ApiStepdefs {
    private static final String BASE_URL = "http://localhost:8081/api-nodatabase/api/v1/";

    private String resource;
    private String name;

    private RestTemplate rest = new RestTemplate();

    @Given("^the resource (\\w+)$")
    public void given_(String resource) {
        System.out.println("given_" + resource); //TODO eliminar
        this.resource = resource;
    }

    // GET method
    @When("^request departamento by name ([a-z0-9\\-]+)$")
    public void when_get(String name) {
        System.out.println("when_" + name);
        this.name = name;
    }

    // get method
    @Then("^the get http code should be (\\d+)$")
    public void then_(Integer code) {
        System.out.println("then_" + code);//TODO eliminar

        ResponseEntity<String> response = rest.getForEntity(BASE_URL + this.resource, String.class);

        Assert.assertEquals(code, Integer.valueOf(response.getStatusCodeValue()));

        // TODO json path
    }


    // POST method
    @When("^I supply the departamento name ([a-z0-9\\-]+)$")
    public void when_post(String name) {
        System.out.println("when_" + name);//TODO eliminar
        this.name = name;
    }

    // post method
    @Then("^the create http code should be (\\d+)$")
    public void then_create(Integer code) {
        System.out.println("then_create_" + code);//TODO eliminar
        String body = "{\"nombre\": \"" + this.name + " \"}";
/*
        ResponseEntity<?> response = rest.postForEntity(BASE_URL + this.resource,
                "{\"alias\": \"invalid data\"}", ResponseEntity.class);
*/


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<String> entity = new HttpEntity<String>(body, headers);
        ResponseEntity<?> response = rest.postForEntity(BASE_URL + this.resource, entity, String.class);

        Assert.assertEquals(code, Integer.valueOf(response.getStatusCodeValue()));

        // TODO json path
    }

    // TODO UPDATE

    // TODO DELETE
}
