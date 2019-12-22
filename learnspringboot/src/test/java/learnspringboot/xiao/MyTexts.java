package learnspringboot.xiao;

import learnspringboot.xiao.controller.AsSimpleController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author xzy
 * @date 2019-11-27 14:43
 * 说明：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class MyTexts {

    private MockMvc mockMvc;

    @Before
    public void setMockMvc() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AsSimpleController()).build();
    }

    @Test
    public void text() throws Exception {
        System.out.println("------head------");
        mockMvc.perform(MockMvcRequestBuilders.get("http://127.0.0.1:8080/test/hello").accept(MediaType.APPLICATION_JSON));
        System.out.println("------end------");
    }
}
