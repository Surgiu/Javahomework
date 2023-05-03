package assignment4;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private int HP;
    private int maxHP;
    private int attack;
    private int speed;
    private ArrayList<Skill> skills = new ArrayList<>();

    public Pokemon(String name, int maxHP, int attack, int speed, Skill... skills) {
        this.name = name;
        this.maxHP = maxHP;
        this.HP = maxHP;
        this.attack = attack;
        this.speed = speed;
        ArrayList<Skill>skills1=new ArrayList<>();
        for (Skill skill : skills) {
            skills1.add(skill);
        }
        for (Skill skill : skills1) {
            skill.setPP(skill.getMaxPP());
            this.skills.add(skill);
        }
    }

    public boolean isAlive() {
        return HP > 0;
    }

    public void useSkillTo(Pokemon target, Skill skill) {
        if (skill.getType().equals(Skill.Type.Heal)) {
            target.HP += skill.getPower();
            if (target.HP > maxHP) {
                target.HP = maxHP;
            }
        } else if (skill.getType().equals(Skill.Type.Attack)) {
            target.HP -= skill.getPower() * this.attack;
            if (target.HP < 0) {
                target.HP = 0;
            }
        }
    }

    public String toString() {
        return name + ": " + this.HP + "/" + maxHP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        if (HP < 0) {
            this.HP = 0;
        } else {
            this.HP = Math.min(HP, maxHP);
        }
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

}

