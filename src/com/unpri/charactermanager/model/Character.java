
package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {

    private int id;
    private String name;
    private int level;
    private CharacterType type;
    private int hitPoints;
    private int attack;
    private int mana;

    private static int totalCharacterCreated = 0;

    // Constructor pertama
    public Character(String name, CharacterType type, int level) {
        this(0, name, type, level);
    }

    // Constructor kedua
    public Character(int id, String name, CharacterType type, int level) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.mana = 0;

        calculateStats();
        totalCharacterCreated++;
    }

    private void calculateStats() {
        this.hitPoints = 100 + (level * 10);
        this.attack = 10 + (level * 2);
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
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama tidak boleh kosong"
            );
        }

        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level minimal 1"
            );
        }

        this.level = level;
        calculateStats();
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif"
            );
        }

        this.mana = mana;
    }

    public void levelUp() {
        setLevel(level + 1);
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    // Membandingkan karakter berdasarkan nama
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return Objects.equals(
            name == null ? null : name.toLowerCase(),
            other.name == null ? null : other.name.toLowerCase()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            name == null ? null : name.toLowerCase()
        );
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
