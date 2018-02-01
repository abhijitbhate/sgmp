package com.cme.oscar.reports.resources;

import com.cme.oscar.reports.advisor.APIAdvisor;
import com.cme.oscar.reports.delegates.RequestedReportDelegate;
import com.cme.oscar.reports.interceptors.GlobalInterceptor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = {RequestedReportResources.class})
public class RequestedReportResourcesTest {

    private MockMvc mockMvc;

    @Autowired
    private RequestedReportResources requestedReportResources;

    @Autowired
    private GlobalInterceptor globalInterceptor;

    @Autowired
    private APIAdvisor apiAdvisor;

    @MockBean
    private RequestedReportDelegate delegate;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(requestedReportResources)
                .addInterceptors(globalInterceptor)
                .setControllerAdvice(apiAdvisor)
                .build();
    }

    @Test
    public void testGetRequestedReports() throws Exception{

        given(delegate.getAllRequestedReports("")).willReturn(new ArrayList<>(0));
        given(delegate.getRequestedReportsCount("")).willReturn(100);

        mockMvc.perform(get("/requestedReports")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .header("X-AUTH-TOKEN","ABCD")
                        )
                .andExpect(status().isOk());

    }
}
