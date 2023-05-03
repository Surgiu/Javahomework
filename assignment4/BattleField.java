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
        Pokemon p1 = trainerA.summon();
        Pokemon p2 = trainerB.summon();
        Skill sa = findSkill(p1, skillOfA);
        Skill sb = findSkill(p2, skillOfB);
        if (p1.getSpeed() >= p2.getSpeed()) {
            execute(p1, p2, sa);
            if (p2.isAlive()) {
                execute(p2, p1, sb);
            } else {
                trainerB.summon();
            }
        } else {
            execute(p2, p1, sb);
            if (p1.isAlive()) {
                execute(p1, p2, sa);
            } else {
                trainerA.summon();
            }
        }
        this.turn++;
    }

    void execute(Pokemon pokemon1, Pokemon pokemon2, Skill skill) {
        if (pokemon1.getSkills().get(0).getPP() > 0) {
            switch (skill.getType()) {
                case Heal:
                    pokemon1.useSkillTo(pokemon1, skill);
                case Attack:
                    pokemon1.useSkillTo(pokemon2, skill);
            }
        }
        pokemon1.getSkills().get(0).setPP(pokemon1.getSkills().get(0).getPP() - 1);

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
    String winner="";
    @Override
    public String toString() {
        String turns = "Turn " + (this.turn - 1) + ":";
        String tA = "\nTrainer " + trainerA.getName() + "'s Pokemon " + trainerA.getActivatePokemon().getName() + ": " + trainerA.getActivatePokemon().getHP() + "/" + trainerA.getActivatePokemon().getMaxHP();
        String tB = "\nTrainer " + trainerB.getName() + "'s Pokemon " + trainerB.getActivatePokemon().getName() + ": " + trainerB.getActivatePokemon().getHP() + "/" + trainerB.getActivatePokemon().getMaxHP();
        String win = "";
        switch (checkWin()) {
            case 1:
                win = "\nWinner: " + trainerA.getName();
            case 2:
                win = "\nWinner: " + trainerB.getName();
            case 3:
                win = null;
        }
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