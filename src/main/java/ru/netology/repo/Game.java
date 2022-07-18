package ru.netology.repo;

import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;

public class Game {

    protected ArrayList<Player> players = new ArrayList<>();


    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }


    public int round(String playerName1, String playerName2) {
        Player player1 = this.findByName(playerName1);
        Player player2 = this.findByName(playerName2);
        if (player1 == null | player2 == null) {
            throw new NotRegisteredException(
                    "Все игроки должны быть зарегистрированы"
            );
        }
        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else return 2;

    }

}
