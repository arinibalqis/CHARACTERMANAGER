
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        System.out.println("======================================");
        System.out.println("       CHARACTER MANAGER - TP5");
        System.out.println("======================================");

        // 1. ADD CHARACTER
        System.out.println("\n=== 1. ADD CHARACTER ===");

        Character hero1 = new Character(
                1, "Arthur", CharacterType.WARRIOR, 10
        );

        Character hero2 = new Character(
                2, "Merlin", CharacterType.MAGE, 15
        );

        Character hero3 = new Character(
                3, "Robin", CharacterType.ARCHER, 12
        );

        System.out.println("Arthur: " + manager.addCharacter(hero1));
        System.out.println("Merlin: " + manager.addCharacter(hero2));
        System.out.println("Robin: " + manager.addCharacter(hero3));

        // 2. DUPLICATE CHECK
        System.out.println("\n=== 2. DUPLICATE CHECK ===");

        Character duplicate = new Character(
                4, "Arthur", CharacterType.WARRIOR, 8
        );

        System.out.println(
                "Tambah Arthur duplikat: "
                + manager.addCharacter(duplicate)
        );

        // 3. FIND BY NAME
        System.out.println("\n=== 3. FIND BY NAME ===");

        Character found = manager.findByName("Merlin");

        if (found != null) {
            System.out.println("Karakter ditemukan: " + found);
        } else {
            System.out.println("Karakter tidak ditemukan");
        }

        // 4. TOTAL CHARACTER
        System.out.println("\n=== 4. TOTAL CHARACTER ===");

        System.out.println(
                "Total karakter: " + manager.getTotalCharacters()
        );

        // 5. DISPLAY ALL CHARACTERS
        System.out.println("\n=== 5. ALL CHARACTERS ===");

        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        // 6. DEFENSIVE COPY EXPERIMENT
        System.out.println("\n=== 6. DEFENSIVE COPY ===");

        ArrayList<Character> copy = manager.getAllCharacters();

        System.out.println("Jumlah sebelum clear: " + copy.size());

        copy.clear();

        System.out.println("Jumlah salinan setelah clear: " + copy.size());

        System.out.println(
                "Jumlah asli dalam manager: "
                + manager.getTotalCharacters()
        );

        // 7. AVERAGE LEVEL
        System.out.println("\n=== 7. AVERAGE LEVEL ===");

        System.out.printf(
                "Rata-rata level: %.2f%n",
                manager.getAverageLevel()
        );

        CharacterManager emptyManager = new CharacterManager();

        System.out.println(
                "Rata-rata manager kosong: "
                + emptyManager.getAverageLevel()
        );

        // 8. FIND BY TYPE
        System.out.println("\n=== 8. FIND BY TYPE ===");

        ArrayList<Character> warriors =
                manager.findByType(CharacterType.WARRIOR);

        System.out.println("Karakter bertipe WARRIOR:");

        for (Character character : warriors) {
            System.out.println(character);
        }

        // 9. CUSTOM ANALYTICS
        System.out.println("\n=== 9. FIND STRONGEST ===");

        Character strongest = manager.findStrongest();

        if (strongest != null) {
            System.out.println("Karakter terkuat: " + strongest.getName());
            System.out.println("Attack tertinggi: " + strongest.getAttack());
        }

        // 10. REMOVE CHARACTER
        System.out.println("\n=== 10. REMOVE CHARACTER ===");

        System.out.println(
                "Hapus Robin: " + manager.removeCharacter("Robin")
        );

        System.out.println(
                "Total setelah penghapusan: "
                + manager.getTotalCharacters()
        );

        // 11. REFERENCE EXPERIMENT
        System.out.println("\n=== 11. REFERENCE EXPERIMENT ===");

        Character a = new Character(
                5, "Gandalf", CharacterType.MAGE, 5
        );

        Character b = a;

        b.setLevel(8);

        System.out.println("Level a: " + a.getLevel());
        System.out.println("Apakah a == b? " + (a == b));

        // 12. EQUALS EXPERIMENT
        System.out.println("\n=== 12. EQUALS EXPERIMENT ===");

        Character x = new Character(
                6, "Arjuna", CharacterType.WARRIOR, 5
        );

        Character y = new Character(
                7, "Arjuna", CharacterType.ARCHER, 9
        );

        System.out.println("x.equals(y): " + x.equals(y));

        // 13. STATIC COUNTER
        System.out.println("\n=== 13. STATIC COUNTER ===");

        System.out.println(
                "Total karakter yang dibuat: "
                + Character.getTotalCharacterCreated()
        );

        System.out.println("\n======================================");
        System.out.println("          PROGRAM SELESAI");
        System.out.println("======================================");
    }
}
