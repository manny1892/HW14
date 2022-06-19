package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player first = new Player(1, "Alex", 50);
    Player second = new Player(2, "Mike", 50);
    Player third = new Player(3, "Robert", 56);
    Player fourth = new Player(4, "Oleg", 99);


    @Test
    public void shouldViewRegisterAndDrawRound() {

        game.register(first);
        game.register(second);


        int actual = game.round("Alex", "Mike");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldViewRegisterAndFirstWinRound() {

        game.register(third);
        game.register(first);


        int actual = game.round("Robert", "Alex");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldViewRegisterAndSecondWinRound() {

        game.register(second);
        game.register(fourth);


        int actual = game.round("Mike", "Oleg");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldViewNotRegisteredExceptionEqualsName() {

        game.register(second);
        game.register(fourth);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Mike", "Mike");
            ;
        });

    }

    @Test
    public void shouldViewNotRegisteredExceptionPlayerOneNotFound() {

        game.register(second);
        game.register(fourth);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Oleg", "MikeMike");
            ;
        });

    }

    @Test
    public void shouldViewNotRegisteredExceptionPlayerTwoNotFound() {

        game.register(second);
        game.register(fourth);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("OlegOleg", "Mike");
            ;
        });

    }
}
