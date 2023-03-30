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
    private final String OWNER = "한바울";

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        // if (event.isFromType(ChannelType.PRIVATE))
        // {
        //     System.out.printf("event.isFromType(ChannelType.PRIVATE) -> ");
        //     System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),
        //                             event.getMessage().getContentDisplay());
        // }
        // else
        // {
        //     System.out.printf("event.isFromType(ChannelType.PRIVATE) else -> ");
        if(event.getAuthor().getName().equals(OWNER)){
            System.out.println(event.getAuthor().getName());
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                        event.getChannel().getName(), event.getMember().getEffectiveName(),
                        event.getMessage().getContentDisplay());
            // event.getChannel().sendMessage("hello my name is Republic bot .... ! ! !").queue();
            if(event.getMessage().getContentDisplay().equals("!start")){
                try{    
                    String path = "cmd /c start C:/Users/openk/Desktop/minecraft/1.19.4/server.bat";
                    Process p = Runtime.getRuntime().exec(path);
                    p.waitFor();
                    App.SERVER_PROCESS = p;
                }catch( IOException ex ){
                    //Validate the case the file can't be accesed (not enought permissions)
                    System.out.println("IOException Error");
                }catch( InterruptedException ex ){
                    //Validate the case the process is being stopped by some external situation     
                    System.out.println("InterruptedException Error");
                }
            } else if(event.getMessage().getContentDisplay().equals("!exit")){
                System.out.println("!eixt!!!");
                Executors.newCachedThreadPool().execute(() -> {

                    try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(App.SERVER_PROCESS.getOutputStream()))){
                        bw.write("stop\n");
                        bw.flush();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                });
                System.out.println("Exit END!!!");
            }
        }
        // }
    }
}
