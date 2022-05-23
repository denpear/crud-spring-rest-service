package com.example.crudspringrestservice;

import com.example.crudspringrestservice.entity.TelephoneEntity;
import com.example.crudspringrestservice.entity.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CrudSpringRestServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/users/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }

    @Test
    void contextLoads(ApplicationContext context) {
        assertThat(context).isNotNull();
        assertThat(context.containsBean("crudSpringRestServiceApplication")).isNotNull();
    }

    @Test
    public void givenBidirectionalRelation_whenUsingJsonIgnore_thenCorrect()
            throws JsonProcessingException {

        UserEntity user = new UserEntity(1L, "John", "Fouls", null, null);
        TelephoneEntity phone = new TelephoneEntity(2L, "book", "5674380-211", user);
        user.setPhones(Collections.singletonList(phone));

        String result = new ObjectMapper().writeValueAsString(user);

        assertThat(result, containsString("John"));
        assertThat(result, not(containsString("userItems")));
    }

}
