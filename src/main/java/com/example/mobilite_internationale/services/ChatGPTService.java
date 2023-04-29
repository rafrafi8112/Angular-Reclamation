package com.example.mobilite_internationale.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class ChatGPTService {
    private final String apiKey = "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";
    private final String apiUrl = "https://api.openai.com/v1/";

    private OkHttpClient client = new OkHttpClient();

    public String askQuestion(String question) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "{\"model\": \"text-davinci-002\", \"prompt\": \"" + question + "\", \"temperature\": 0.7}");
        Request request = new Request.Builder()
                .url(apiUrl + "completions")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = mapper.readValue(responseBody, Map.class);

        return jsonMap.get("choices").toString();
    }
}
