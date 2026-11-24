package com.unpri.charactermanager.model;

public class Character {

    private final int id;
    private final String name;
    private int level;
    private final CharacterType type;

    private int hitPoints;
    private int attack;
    private int mana;

    private static int nextId = 1;

    public Character(String name, CharacterType type, int level) {
        this(nextId++, name, level, type);
    }

    public Character(String name, int level, CharacterType type) {
        this(name, type, level);
    }

    public Character(int id, String name, int level, CharacterType type) {

        String cleanedName = name == null ? "" : name.trim();

        if (cleanedName.isEmpty()) {
            throw new IllegalArgumentException(
                "Nama karakter tidak boleh kosong."
            );
        }

        if (cleanedName.length() < 3 ||
            cleanedName.length() > 20) {
            throw new IllegalArgumentException(
                "Nama karakter harus terdiri dari 3 sampai 20 karakter."
            );
        }

        if (cleanedName.matches(".*\\s{2,}.*")) {
            throw new IllegalArgumentException(
                "Nama tidak boleh memiliki dua spasi berurutan."
            );
        }

        if (type == null) {
            throw new IllegalArgumentException(
                "Role karakter harus dipilih."
            );
        }

        if (level < 1 || level > 99) {
            throw new IllegalArgumentException(
                "Level karakter harus berada antara 1 sampai 99."
            );
        }

        if (type == CharacterType.MAGE && level > 60) {
            throw new IllegalArgumentException(
                "Karakter MAGE tidak boleh memiliki level di atas 60."
            );
        }

        this.id = id;
        this.name = cleanedName;
        this.level = level;
        this.type = type;

        updateStatistics();
    }

    private void updateStatistics() {
        this.hitPoints = calculateBaseHP();
        this.attack = calculateBaseAttack();
        this.mana = calculateBaseMana();
    }

    public int calculateBaseHP() {
        int base = 100 + (level * 10);

        if (type == CharacterType.WARRIOR) {
            base += 40;
        }

        return base;
    }

    public int calculateBaseAttack() {
        int base = 10 + (level * 3);

        if (type == CharacterType.ASSASSIN) {
            base += 15;
        } else if (type == CharacterType.WARRIOR) {
            base += 10;
        }

        return base;
    }

    public int calculateBaseMana() {
        int base = 20 + (level * 5);

        if (type == CharacterType.MAGE) {
            base += 50;
        }

        return base;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public void levelUp() {

        if (level >= 99) {
            throw new IllegalStateException(
                "Level karakter sudah mencapai batas maksimum."
            );
        }

        if (type == CharacterType.MAGE && level >= 60) {
            throw new IllegalStateException(
                "Level MAGE sudah mencapai batas maksimum 60."
            );
        }

        level++;
        updateStatistics();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public CharacterType getType() {
        return type;
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

    @Override
    public String toString() {
        return "Character{id=" + id
                + ", name='" + name + '\''
                + ", level=" + level
                + ", type=" + type
                + ", hitPoints=" + hitPoints
                + ", attack=" + attack
                + ", mana=" + mana
                + '}';
    }
}