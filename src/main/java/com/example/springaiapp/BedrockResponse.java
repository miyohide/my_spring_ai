package com.example.springaiapp;

/**
 * Bedrockからのレスポンスを格納するDTOクラス
 */
public class BedrockResponse {
    private String response;

    /**
     * コンストラクタ
     * @param response 生成されたテキスト
     */
    public BedrockResponse(String response) {
        this.response = response;
    }

    /**
     * レスポンステキストを取得
     * @return 生成されたテキスト
     */
    public String getResponse() {
        return response;
    }
}