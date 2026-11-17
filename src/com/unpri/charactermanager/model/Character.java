
package com.unpri.charactermanager.model;

public class Character {

    private int id;
    private String name;
    private int level;
    private CharacterType type;
    private int hitPoints;
    private int attack;
    private int mana;

    // Constructor pertama
    public Character(String name, int level, CharacterType type) {
        this(0, name, level, type);
    }

    // Constructor kedua
    public Character(int id, String name, int level, CharacterType type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.mana = 0;
        setLevel(level);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level tidak boleh kurang dari 1");
        }

        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attack = calculateBaseAttack();
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
        this.hitPoints = calculateBaseHP();
        this.attack = calculateBaseAttack();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh negatif");
        }

        this.mana = mana;
    }

    public int calculateBaseHP() {
        switch (type) {
            case WARRIOR:
                return 150 + (level * 20);

            case MAGE:
                return 90 + (level * 10);

            case ARCHER:
                return 110 + (level * 15);

            case ASSASSIN:
                return 100 + (level * 12);

            default:
                return 100;
        }
    }

    public int calculateBaseAttack() {
        switch (type) {
            case WARRIOR:
                return 20 + (level * 5);

            case MAGE:
                return 35 + (level * 7);

            case ARCHER:
                return 25 + (level * 6);

            case ASSASSIN:
                return 30 + (level * 8);

            default:
                return 10;
        }
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public void levelUp() {
        setLevel(level + 1);
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", type=" + type +
                ", hitPoints=" + hitPoints +
                ", attack=" + attack +
                ", mana=" + mana +
                '}';
    }
}
