package ru.netology.domain;

import java.util.HashMap;
import java.util.Map;


public class Game {

    Map<Integer, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getId(), player);
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        }
        if (findByName(playerName1) == findByName(playerName2)) {
            throw new NotRegisteredException("Игрок не может сражаться сам с собой");
        }

        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            System.out.println("Победа " + playerName1 + "!");
            return 1;
        }
        if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            System.out.println("Победа " + playerName2 + "!");
            return 2;
        }
        System.out.println("Ничья!");
        return 0;
    }

    public Player findByName(String playerName) {
        for (Player player : players.values()) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }
}
