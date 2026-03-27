package com.example.claudepromptservice;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class ClaudePromptServiceApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ClaudePromptServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ChatClient.Builder builder)
    {
        return args ->
        {
            ChatClient chatClient = builder.build();
            Scanner sc = new Scanner(System.in);

            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║       AI Chat — powered by Ollama    ║");
            System.out.println("║       Type 'exit' to quit            ║");
            System.out.println("╚══════════════════════════════════════╝");

            while(true)
            {
                System.out.println("\nYou: ");
                String prompt = sc.nextLine().trim();

                if(prompt.equalsIgnoreCase("exit") || prompt.equalsIgnoreCase("quit"))
                {
                    System.out.println("Goodbye!");
                    break;
                }

                if(prompt.isEmpty())
                {
                    System.out.println("Please enter a prompt.");
                    continue;
                }

                System.out.println("AI: ");
                String response = chatClient
                        .prompt()
                        .user(prompt)
                        .call()
                        .content();
                System.out.println(response);
                System.out.println("-".repeat(50));
            }
            sc.close();
        };
    }

}
