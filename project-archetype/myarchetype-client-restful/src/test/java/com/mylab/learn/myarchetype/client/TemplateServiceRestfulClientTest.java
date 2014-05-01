package com.mylab.learn.myarchetype.client;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.mylab.learn.myarchetype.service.TemplateResponse;

public class TemplateServiceRestfulClientTest {

    private MockRestServiceServer mockServer;
    private RestTemplate restTemplate;
    private TemplateServiceRestfulClient client;

    @Before
    public void setup() {
        this.restTemplate = new RestTemplate();
        this.mockServer = MockRestServiceServer.createServer(this.restTemplate);
        this.client = new TemplateServiceRestfulClient();
        this.client.setRestTemplate(this.restTemplate);
    }

    @Test
    public void testTemplate() {
        String responseBody = "{\"dummyResult\":true}";

        this.mockServer.expect(
                requestTo("/templateOperation/MAIN_FLOW"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON));

        @SuppressWarnings("unused")
        TemplateResponse templateResponse = restTemplate.getForObject(
                "/templateOperation/{requestId}",
                TemplateResponse.class, "MAIN_FLOW");

        this.mockServer.verify();
    }

    @Test
    public void testCallTemplateOperation() {
        this.client.setServiceUrl("");
        String responseBody = "{\"dummyResult\":true}";

        this.mockServer.expect(
                requestTo("/templateOperation/MAIN_FLOW"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON));

        String dummyProperty = null;
        this.client.callTemplateOperation(dummyProperty);

        this.mockServer.verify();
    }

    @Test
    public void testCallTemplatePostOperation() {
        this.client.setServiceUrl("");
        String responseBody = "{\"dummyResult\":true}";

        this.mockServer.expect(
                requestTo("/templatePutOperation"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON));

        String dummyProperty = null;
        this.client.callTemplatePostOperation(dummyProperty);

        this.mockServer.verify();
    }
}

/*
 * https://github.com/spring-projects/spring-framework/blob/master/spring-test/src
 * /test/java/org/springframework/test/web/client/samples/SampleTests.java
 */