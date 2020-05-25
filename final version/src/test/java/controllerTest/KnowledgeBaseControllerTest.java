package controllerTest;

import cn.edu.zju.bean.Drug;
import cn.edu.zju.bean.DrugLabel;
import cn.edu.zju.dao.DosingGuidelineDao;
import cn.edu.zju.dao.DrugDao;
import cn.edu.zju.dao.DrugLabelDao;
import cn.edu.zju.dbutils.DBUtils;
import cn.edu.zju.web.controller.KnowledgeBaseController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)


public class KnowledgeBaseControllerTest {
    private static final Logger log = LoggerFactory.getLogger(KnowledgeBaseControllerTest.class);

    @Autowired
    private DrugDao drugDao;
    @Autowired
    private DrugLabelDao drugLabelDao;
    @Autowired
    private DosingGuidelineDao dosingGuidelineDao;
    private WebApplicationContext applicationContext;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    public void drugTest() throws Exception {
        String url = "/views/drugs";
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,url));
        MvcResult mvcResult = resultActions.
                andDo(MockMvcResultHandlers.print()).
                andExpect(ResultMatcher.matchAll()).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }
    @Test
    public void drugLabelsTest() throws Exception {
        String url = "/views/drug_labels";
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,url));
        MvcResult mvcResult = resultActions.
                andDo(MockMvcResultHandlers.print()).
                andExpect(ResultMatcher.matchAll()).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }
    @Test
    public void dosingGuidelineTest() throws Exception {
        String url = "/views/dosing_guideline";
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,url));
        MvcResult mvcResult = resultActions.
                andDo(MockMvcResultHandlers.print()).
                andExpect(ResultMatcher.matchAll()).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }
    public void deleteByName(String name){
        DBUtils.execSQL(connection -> {
            try {
                connection.createStatement().execute("DELETE FROM drug_label WHERE name='" + name +"';");
            } catch (SQLException e) {
                e.printStackTrace();
            }});
        log.info("deleted");
    }
}

