package com.paulhan.discord.commands;

import java.util.Arrays;

import com.paulhan.discord.App;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ChatGptAdapter extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        
        StringBuilder message = new StringBuilder(event.getMessage().getContentRaw());
        boolean isCommand = message.substring(0, 6).equals("```gpt");
        boolean isControlCommand = message.substring(0, 9).equals("```gptControl");
        if(!isCommand){
            return;
        }

        message.setLength(0);
        message.append(event.getMessage().getContentStripped());
        
        System.out.println("message length : " + message.length());
        System.out.println("gpt : " + message);
        if(event.getMessage().getContentDisplay().equals("test")){

        }
    }
}
