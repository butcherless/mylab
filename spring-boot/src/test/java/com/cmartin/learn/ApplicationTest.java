package com.cmartin.learn;

import com.cmartin.learn.repository.DummyRepository;
import com.cmartin.learn.service.DummyService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by cmartin on 29/04/2017.
 */
public class ApplicationTest {

    @Test
    public void testRepository() {
        DummyRepository repository = new DummyRepository();
        assertThat(repository.getMessageByName("messageName"))
                .isNotBlank()
                .isEqualTo("MESSAGENAME");
    }

    @Test
    public void testService() {
        DummyService service = new DummyService(new DummyRepository());
        assertThat(service.upperMessage("message"))
                .isNotBlank()
                .isEqualTo("MESSAGE");
    }

    @Test
    public void testApplication() throws Exception {
        SimpleApplication.main(new String[]{""});
    }
}
