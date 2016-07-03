package com.cmartin.learn.mybank.service;

import com.cmartin.learn.mybank.dto.AccountDTO;
import com.cmartin.learn.mybank.dto.DomainFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.math.BigDecimal;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.text.MatchesPattern.matchesPattern;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by cmartin on 19/06/16.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
public class ApiDocumentation {

    protected static final ResultMatcher statusOk = status().isOk();
    protected static final ResultMatcher statusCreated = status().isCreated();
    protected static final ResultMatcher contentTypeJson = content().contentType(MediaType.APPLICATION_JSON);

    private static final String DECIMAL_NUMBER_PATTERN = "^[0-9]+.[0-9]{2}";
    private static final String NUMBER_PATTERN = "^[0-9]+";
    private static final String IBAN_PATTERN = "^[A-Z]{2}[0-9]{22}";
    //    private static final String WORD_PATTERN = "^[a-zA-Z0-9_-]+";
    private static final String WORD_PATTERN = "\\p{Print}+";

    public static final String DESC_NÚMERO_CUENTA = "número de cuenta";
    public static final String DESC_ALIAS_CUENTA = "alias para la cuenta";
    public static final String DESC_SALDO_CUENTA = "saldo de la cuenta";

    protected ResponseFieldsSnippet responseFieldsSnippet = responseFields(
            fieldWithPath("[].number").description(DESC_NÚMERO_CUENTA),
            fieldWithPath("[].alias").description(DESC_ALIAS_CUENTA),
            fieldWithPath("[].balance").description(DESC_SALDO_CUENTA));

    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    private final ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    private PrettyPrintConverter prettyPrintConverter = new PrettyPrintConverter(true);

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new MyBankController()).setMessageConverters(this.prettyPrintConverter)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void testGetAccountList() throws Exception {

        this.mockMvc.perform(get("/accounts/").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(statusOk)
                .andExpect(contentTypeJson)
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$[0].number").exists())
                .andExpect(jsonPath("$[0].alias").exists())
                .andExpect(jsonPath("$[0].balance").exists())
                .andExpect(jsonPath("$[0].number").value(matchesPattern(IBAN_PATTERN)))
                .andExpect(jsonPath("$[0].alias").value(matchesPattern(WORD_PATTERN)))
                .andExpect(jsonPath("$[0].balance").value(matchesPattern(DECIMAL_NUMBER_PATTERN)))
                /*
                 * API Documentation
                 */
                .andDo(document("account-list", this.responseFieldsSnippet));

    }

    @Test
    public void testGetAccountListWithPagination() throws Exception {
        final Integer paginationSize = 7;
        this.mockMvc.perform(get("/accounts/").param("paginationSize", paginationSize.toString()))
                .andDo(print())
                .andExpect(statusOk)
                .andExpect(contentTypeJson)
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(lessThanOrEqualTo(paginationSize))))
                /*
                 * API Documentation
                 */
                .andDo(document("account-list-page",
                        requestParameters(
                                parameterWithName("paginationSize").description("tamaño de página solicitado")),
                        this.responseFieldsSnippet));
    }

    @Ignore
    @Test
    public void testGetAccountListWithPaginationLimit() {
/*
        given()
                .standaloneSetup(new MyBankController()).
                when()
                .get("/accounts/?paginationSize=20").
                then().
                statusCode(200);
        //body("entity-1.entity-2", equalTo(3));
        */
    }

    @Test
    public void testGetAccount() throws Exception {
        this.mockMvc.perform(get("/accounts/AB1122223333441234567890"))
                .andDo(print())
                .andExpect(statusOk)
                .andExpect(contentTypeJson)
                /*
                 * API Documentation
                 */
                .andDo(document("account-get",
                        responseFields(
                                fieldWithPath("number").description(DESC_NÚMERO_CUENTA),
                                fieldWithPath("alias").description(DESC_ALIAS_CUENTA),
                                fieldWithPath("balance").description(DESC_SALDO_CUENTA))));
    }


    @Test
    public void testGetNotFound() throws Exception {
        this.mockMvc.perform(get("/notFound/").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }


    @Test
    public void testGetAccountTransactionList() throws Exception {
        this.mockMvc.perform(get("/accounts/1234567890/accountTransactions").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(statusOk)
                .andExpect(contentTypeJson)
                /*
                 * API Documentation
                 */
                .andDo(document("accountTransaction-list",
                        responseFields(
                                fieldWithPath("list.[].id").description("identificador único del movimiento"),
                                fieldWithPath("list.[].amount").description("cantidad monetaria del movimiento"),
                                fieldWithPath("list.[].amount.value").description("cuantía del movimiento"),
                                fieldWithPath("list.[].amount.currency").description("divisa del movimiento"),
                                fieldWithPath("list.[].transactionDate").description("fecha del movimiento"),
                                fieldWithPath("list.[].date").description("fecha de consolidación del movimiento"),
                                fieldWithPath("list.[].description").description("descripción del movimiento"),
                                fieldWithPath("paginationKey").description("clave de paginación para recuperar la siguiente página de resultados"),
                                fieldWithPath("hasNextPage").description("indicador de datos adicionales disponibles"))));
    }


    @Test
    public void testPostCreateAccount() throws Exception {
        AccountDTO accountDTO = DomainFactory.newAccountDTO(
                DomainFactory.makePseudoIBANAccount(), "account-alias", new BigDecimal(0).setScale(2));
        this.mockMvc.perform(post("/users/1234567890/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToJsonString(accountDTO)))
                .andDo(print())
                .andExpect(statusCreated)
                /*
                 * API Documentation
                 */
                .andDo(document("account-create",
                        requestFields(
                                fieldWithPath("number").description(DESC_NÚMERO_CUENTA),
                                fieldWithPath("alias").description(DESC_ALIAS_CUENTA),
                                fieldWithPath("balance").description(DESC_SALDO_CUENTA))));
    }

    @Test
    public void testFactory() {
        new DomainFactory();
    }

    // H E L P E R S
    private final class PrettyPrintConverter extends MappingJackson2HttpMessageConverter {
        public PrettyPrintConverter(Boolean prettyPrint) {
            super();
            this.setPrettyPrint(prettyPrint);
        }
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.prettyPrintConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

    protected String objectToJsonString(final Object object) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(object);
    }
}
