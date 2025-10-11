package com.example.springaiapp.controller;

import com.example.springaiapp.BedrockResponse;
import com.example.springaiapp.service.BedrockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Bedrock連携のREST APIを提供するControllerクラス
 */
@RestController
public class BedrockController {
    private final BedrockService bedrockService;

    /**
     * コンストラクタ
     * @param bedrockService BedrockService
     */
    public BedrockController(BedrockService bedrockService) {
        this.bedrockService = bedrockService;
    }

    /**
     * メッセージをBedrockに送信してレスポンスを返す
     * @param message クエリパラメータで指定されたメッセージ
     * @return Bedrockからのレスポンス
     */
    @PostMapping("/")
    public ResponseEntity<BedrockResponse> generateText(
            @RequestParam("message") String message) {
        String response = bedrockService.generateResponse(message);
        return ResponseEntity.ok(new BedrockResponse(response));
    }
}