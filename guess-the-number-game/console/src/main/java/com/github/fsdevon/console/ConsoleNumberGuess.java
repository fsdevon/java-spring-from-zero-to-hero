package com.github.fsdevon.console;

import com.github.fsdevon.Game;
import com.github.fsdevon.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess {

    // == fields ==
    private final Game game;

    private final MessageGenerator messageGenerator;

    // == constructors ==
    //@Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @EventListener
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("start() -> Container ready to use.");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");

                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }
                game.reset();
            }
        }
    }
}
