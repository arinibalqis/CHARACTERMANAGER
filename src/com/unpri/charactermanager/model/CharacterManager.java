package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharacterManager {

    private final List<Character> characters = new ArrayList<>();

    public void addCharacter(Character character) {

        if (character == null) {
            throw new IllegalArgumentException(
                "Karakter tidak boleh null."
            );
        }

        if (isNameTaken(character.getName())) {
            throw new IllegalArgumentException(
                "Nama karakter \"" +
                character.getName() +
                "\" sudah digunakan."
            );
        }

        characters.add(character);
    }

    public boolean isNameTaken(String name) {

        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        String target = name.trim();

        for (Character character : characters) {

            if (character.getName().equalsIgnoreCase(target)) {
                return true;
            }
        }

        return false;
    }

    public Character findByName(String name) {

        if (name == null) {
            return null;
        }

        for (Character character : characters) {

            if (character.getName()
                    .equalsIgnoreCase(name.trim())) {
                return character;
            }
        }

        return null;
    }

    public boolean removeCharacter(String name) {

        Character found = findByName(name);

        return found != null && characters.remove(found);
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    public double getAverageLevel() {

        if (characters.isEmpty()) {
            return 0.0;
        }

        int total = 0;

        for (Character character : characters) {
            total += character.getLevel();
        }

        return (double) total / characters.size();
    }

    public Character findStrongest() {

        Character strongest = null;

        for (Character character : characters) {

            if (strongest == null ||
                character.getAttack() > strongest.getAttack()) {
                strongest = character;
            }
        }

        return strongest;
    }

    public List<Character> getAllCharacters() {
        return Collections.unmodifiableList(
            new ArrayList<>(characters)
        );
    }
}