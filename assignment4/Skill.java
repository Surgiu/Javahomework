package assignment4;

public class Skill {
    private String name;
    private Type type;
    private int power;
    private int PP;
    private int maxPP;

    enum Type {
        Attack, Heal
    }

    public Skill(String name, Type type, int power, int PP) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.PP = Math.max(PP, 0);
        this.maxPP = Math.max(PP, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPP() {
        return PP;
    }

    public void setPP(int PP) {
        if (PP < 0) {
            this.PP = 0;
        } else {
            this.PP = Math.min(maxPP, PP);
        }
    }

    public int getMaxPP() {
        return maxPP;
    }

    public void setMaxPP(int maxPP) {
        this.maxPP = maxPP;
    }
}

