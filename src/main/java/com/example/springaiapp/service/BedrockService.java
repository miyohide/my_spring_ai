package com.example.springaiapp.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

/** Bedrockとの連携処理を行うServiceクラス */
@Service
public class BedrockService {
  private final ChatClient chatClient;

  /**
   * コンストラクタ
   *
   * @param chatClient Spring AIのChatClient
   */
  public BedrockService(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder.build();
  }

  /**
   * メッセージをBedrockに送信してレスポンスを取得
   *
   * @param message 送信するメッセージ
   * @return 生成されたテキスト
   */
  public String generateResponse(String message) {
    return chatClient.prompt().user(message).call().content();
  }
}
