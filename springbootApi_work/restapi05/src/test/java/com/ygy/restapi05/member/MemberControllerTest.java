package com.ygy.restapi05.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // MockMvc 를 사용하기 위한 어노테이션
class MemberControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void member() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/member"));

        resultActions
                .andDo(print())  // 어떻게 행했는지 출력을 해달라
                .andExpect(status().isOk())  // 상태값이 ok 면
                .andExpect(content().string("member"));
    }
}