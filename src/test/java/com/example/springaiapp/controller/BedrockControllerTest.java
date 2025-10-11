package com.example.springaiapp.controller;

import com.example.springaiapp.service.BedrockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * BedrockControllerのテストクラス
 */
@WebMvcTest(BedrockController.class)
class BedrockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BedrockService bedrockService;

    /**
     * 正常系：メッセージ送信とレスポンス確認
     */
    @Test
    void generateText_正常系() throws Exception {
        String testMessage = "こんにちは";
        String expectedResponse = "こんにちは！元気ですか？";
        
        when(bedrockService.generateResponse(testMessage)).thenReturn(expectedResponse);

        mockMvc.perform(post("/")
                .param("message", testMessage))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.response").value(expectedResponse));
    }

    /**
     * 異常系：パラメータ不正時のエラーハンドリング
     */
    @Test
    void generateText_パラメータなし() throws Exception {
        mockMvc.perform(post("/"))
                .andExpect(status().isBadRequest());
    }
}