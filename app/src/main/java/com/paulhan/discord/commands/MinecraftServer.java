package com.paulhan.discord.commands;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.Executors;

import com.paulhan.discord.App;

import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MinecraftServer extends ListenerAdapter {
    

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if(event.getAuthor().getName().equals(App.OWNER)){
            System.out.println(event.getAuthor().getName());
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                        event.getChannel().getName(), event.getMember().getEffectiveName(),
                        event.getMessage().getContentDisplay());
            if(event.getMessage().getContentDisplay().equals("!start")){
                try{    
                    String path = "cmd /c start C:/Users/openk/Desktop/minecraft/1.19.4/server.bat";
                    App.SERVER_PROCESS = Runtime.getRuntime().exec(path);
                }catch( IOException ex ){
                    System.out.println("IOException Error");
                }
            }
        }
    }
}
