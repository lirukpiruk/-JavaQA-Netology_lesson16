package ru.netology.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Маша", 50);
    Player player2 = new Player(2, "Ира", 100);
    Player player3 = new Player(3, "Коля", 50);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }


    @Test
    public void shouldSetMessageIfAllNotRegistered() {

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Петя", "Вася");
        });
    }

    @Test
    public void shouldSetMessageIfFirstNotRegistered() {

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Петя", player1.getName());
        });
    }

    @Test
    public void shouldSetMessageIfSecondNotRegistered() {

        assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), "Вася");
        });
    }

    @Test
    public void shouldReturnResultDrawIfAllRegistered() {

        int expected = 0;
        int actual = game.round(player1.getName(), player3.getName());

        assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnResultWonFirstAndAllRegistered() {

        int expected = 1;
        int actual = game.round(player2.getName(), player3.getName());

        assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnResultWonSecondAndAllRegistered() {

        int expected = 2;
        int actual = game.round(player1.getName(), player2.getName());

        assertEquals(expected,actual);
    }


}
