package com.paulhan.discord.openai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.paulhan.discord.config.PropertiesReader;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ChatGpt {
    public static String generate(){
        OpenAiService service = new OpenAiService(PropertiesReader.getProperty("OPENAI_TOKEN"));
        
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("바울:1+1과 2+2를 더하면 답은 뭐야?")
                .model("text-davinci-003")
                .temperature(1D)
                .maxTokens(50)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .bestOf(1)                
                .build();
        List<CompletionChoice> serviceList = service.createCompletion(completionRequest).getChoices();
        serviceList.forEach(System.out::println);

        // System.out.println("serviceList start --");
        // System.out.println(serviceList.toString());
        // System.out.println("serviceList end --");
        
        return "";
    }
}
