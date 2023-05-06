package assignment4;

public class BattleField {
    private Trainer trainerA;
    private Trainer trainerB;
    private int turn = 1;

    public BattleField(Trainer trainerA, Trainer trainerB) {
        this.trainerA = trainerA;
        this.trainerB = trainerB;
    }

    public void battle(String skillOfA, String skillOfB) {
        Pokemon p1 = trainerA.getActivatePokemon();
        Pokemon p2 = trainerB.getActivatePokemon();
        if (p1.getSpeed() >= p2.getSpeed()) {
            exe(skillOfB, skillOfA, p2, p1, trainerA, trainerB);
        } else {
            exe(skillOfA, skillOfB, p1, p2, trainerB, trainerA);
        }
        this.turn++;
    }

    void exe(String skillOfA, String skillOfB, Pokemon p1, Pokemon p2, Trainer trainerB, Trainer trainerA) {
        execute(p2, p1, findSkill(p2, skillOfB));
        if (p1.isAlive()) {
            execute(p1, p2, findSkill(p1, skillOfA));
            if (!(p2.isAlive())) {
                trainerB.removePokemon(trainerB.getActivatePokemon().getName());
                trainerB.summon();
            }
        } else {
            trainerA.removePokemon(trainerA.getActivatePokemon().getName());
            trainerA.summon();
        }
    }

    void execute(Pokemon pokemon1, Pokemon pokemon2, Skill p1skill) {
        if (pokemon1.isAlive() && p1skill.getPP() > 0) {
            switch (p1skill.getType()) {
                case Heal -> pokemon1.useSkillTo(pokemon1, p1skill);
                case Attack -> pokemon1.useSkillTo(pokemon2, p1skill);
            }
        }
        p1skill.setPP(p1skill.getPP() - 1);
    }

    Skill findSkill(Pokemon pokemon, String name) {
        for (int i = 0; i < pokemon.getSkills().size(); i++) {
            if (pokemon.getSkills().get(i).getName().equals(name)) {
                return pokemon.getSkills().get(i);
            }
        }
        return null;
    }

    public int checkWin() {
        if (trainerA.getPokemons().size() > trainerB.getPokemons().size() && trainerB.getPokemons().size() == 0) {
            return 1;
        } else if (trainerA.getPokemons().size() < trainerB.getPokemons().size() && trainerA.getPokemons().size() == 0) {
            return 2;
        } else {
            return 0;
        }
    }

    String winner = "";

    @Override
    public String toString() {
        String turns = "Turn " + (this.turn - 1) + ":";
        String tA = "\nTrainer " + trainerA.getName() + "'s Pokemon " + trainerA.getActivatePokemon().getName() + ": " + trainerA.getActivatePokemon().getHP() + "/" + trainerA.getActivatePokemon().getMaxHP();
        String tB = "\nTrainer " + trainerB.getName() + "'s Pokemon " + trainerB.getActivatePokemon().getName() + ": " + trainerB.getActivatePokemon().getHP() + "/" + trainerB.getActivatePokemon().getMaxHP();
        String win = "";
        if (checkWin() == 1) {
            win = "\nWinner: " + trainerA.getName();
        } else if (checkWin() == 2) {
            win = "\nWinner: " + trainerB.getName();
        }
        System.out.println();
        return turns + tA + tB + win;
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