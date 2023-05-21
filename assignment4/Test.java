package assignment4;

public class Test {
    public static void main(String[] args) {
//        Skill attack = new Skill("Beat", Skill.Type.Attack, 25, 10);
//        Skill heal = new Skill("Heal", Skill.Type.Heal, 2, 10);
//        Pokemon pokemon1 = new Pokemon("p1", 50, 2, 20, attack, heal);
//        Pokemon pokemon2 = new Pokemon("p2", 50, 2, 20, attack, heal);
//        pokemon1.setHP(0);
//        Trainer s = new Trainer("s", pokemon1);
//        Trainer i = new Trainer("i", pokemon2);
//        BattleField battleField = new BattleField(s, i);
//        battleField.battle("Beat","Beat");
//        System.out.println(battleField);

        battlePokemonSummon();
   }

    static void battlePokemonSummon() {
        Skill heal = new Skill("heal", Skill.Type.Heal, 40, 10);
        Skill attack = new Skill("attack", Skill.Type.Attack, 20, 10);
        Pokemon cuphead = new Pokemon("cuphead", 50, 2, 1, attack, heal);
        Pokemon charmander = new Pokemon("charmander", 1, 1, 9, attack, heal);
        Pokemon squirtle = new Pokemon("squirtle", 1, 1, 9, attack, heal);
        Trainer trainer1 = new Trainer("Ash", cuphead);
        Trainer trainer2 = new Trainer("Misty", charmander, squirtle);
        BattleField bf = new BattleField(trainer1, trainer2);
        trainer2.summon("squirtle");
        bf.battle("attack", "attack");
        System.out.println(bf);
        //Turn 1:
        //Trainer Ash's Pokemon cuphead: 30/50
        //Trainer Misty's Pokemon charmander: 1/1
    }

}
