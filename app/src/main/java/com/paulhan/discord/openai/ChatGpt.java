package com.paulhan.discord.openai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.paulhan.discord.config.PropertiesReader;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ChatGpt {
    public static String generate(String userQuestion){
        OpenAiService service = new OpenAiService(PropertiesReader.getProperty("OPENAI_TOKEN"));
        
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(userQuestion)
                .model("text-davinci-003")
                .temperature(0D)
                .maxTokens(100)
                .topP(1D)
                .bestOf(1)
                .build();
        List<CompletionChoice> serviceList = service.createCompletion(completionRequest).getChoices();

        return serviceList.get(0).getText().trim();
    }
}
