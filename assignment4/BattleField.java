package assignment4;

import java.lang.reflect.Type;

public class BattleField {
    private Trainer trainerA;
    private Trainer trainerB;
    private int turn = 1;

    public BattleField(Trainer trainerA, Trainer trainerB) {

    }

    public void battle(String skillOfA, String skillOfB) {

    }

    public int checkwin() {

    }

    @Override
    public String toString() {
        return "Turn" + this.turn + "\nTrainer" + trainerA.getName() + "'s " + "Pokemon" +
    }

    public Trainer getTrainerA() {
        return trainerA;
    }

    public void setTrainerA(Trainer trainerA) {
        this.trainerA = trainerA;
    }

    public Trainer getTrainerB() {
        return trainerB;
    }

    public void setTrainerB(Trainer trainerB) {
        this.trainerB = trainerB;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}