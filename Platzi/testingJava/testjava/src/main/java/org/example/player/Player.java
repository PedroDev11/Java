package org.example.player;

// Test 2
public class Player {
    private Dice dice;
    private int minNumToWin;

    public Player(Dice dice, int minNumToWin) {
        this.dice = dice;
        this.minNumToWin = minNumToWin;
    }

    public boolean play() {
        int diceNum = dice.rol();
        return diceNum > minNumToWin;
    }
}
