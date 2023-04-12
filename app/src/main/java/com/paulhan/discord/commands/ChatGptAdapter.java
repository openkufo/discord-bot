package com.paulhan.discord.commands;

import java.util.Arrays;

import com.paulhan.discord.App;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ChatGptAdapter extends ListenerAdapter {
    private final String GPT = "```GPT";
    private final String CONTROL = "CONTROL";
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String user = event.getAuthor().getName();

        StringBuilder message = new StringBuilder(event.getMessage().getContentRaw());


        boolean isCommand;
        
        try{
            isCommand = message.substring(0, 6).toUpperCase().equals(GPT);
        } catch(StringIndexOutOfBoundsException e){
            isCommand = false;
        }

        if(!isCommand){
            return;
        }
        
        
        boolean isControlCommand;
        try{
            isControlCommand = message.substring(6, 13).toUpperCase().equals(CONTROL);
        } catch(StringIndexOutOfBoundsException e){
            isControlCommand = false;
        }

        message.setLength(0);
        message.append(event.getMessage().getContentStripped());
        
        boolean isOnwer = user.equals(App.OWNER);
        if(isControlCommand && isOnwer){
            if(message.toString().toUpperCase().equals("ALL")){
                
            }
            return;
        }
        
        
        System.out.println("message length : " + message.length());
        System.out.println("gpt : " + message);
        if(event.getMessage().getContentDisplay().equals("test")){

        }
    }
}
