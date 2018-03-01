package com.kodigo.weightlogger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@WebMvcTest
@RunWith(SpringRunner.class)
public class WeightDataRestControllerTest {

    @MockBean
    private WeightDataRepository weightDataRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getWeightData() throws Exception {

        List<WeightData> weightDataList = Arrays.asList(new WeightData(1L, 72.15D, LocalDate.now()));

        Mockito.when(this.weightDataRepository.findAll()).thenReturn(weightDataList);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/weights"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].weight").value(72.15D))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
