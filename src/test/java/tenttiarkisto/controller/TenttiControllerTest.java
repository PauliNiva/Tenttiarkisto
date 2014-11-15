package tenttiarkisto.controller;

import java.util.Calendar;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tenttiarkisto.Application;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.domain.Tentti;
import tenttiarkisto.domain.Tyyppi;
import tenttiarkisto.repo.TenttiRepo;
import tenttiarkisto.service.TenttiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TenttiControllerTest {

    @Autowired
    private TenttiService tenttiService;

    @Autowired
    private TenttiRepo tenttiRepo;

    @Autowired
    private WebApplicationContext webAppContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }

    @Test
    public void postOk() throws Exception {
        mockMvc.perform(post("/tentit"))
                .andExpect(status().is3xxRedirection())
                .andReturn();
    }

    @Test
    public void getOk() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(redirectedUrl("/kurssit"));
    }

    @Test
    public void getPalauttaaOikeanNakyman() throws Exception {
        mockMvc.perform(get("/tentit/1"))
                .andExpect(forwardedUrl("/WEB-INF/views/tentin-tiedot.jsp"));
    }

    @Test
    public void modelissaOikeaAtribuutti() throws Exception {
        mockMvc.perform(get("/tentit/1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("tentti"))
                .andReturn();
    }
}
