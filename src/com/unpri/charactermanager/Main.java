
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("       CHARACTER MANAGER");
        System.out.println("==================================");

        // Membuat tiga karakter
        Character hero1 = new Character(
                1, "Arthur", 5, CharacterType.WARRIOR
        );

        Character hero2 = new Character(
                2, "Merlin", 7, CharacterType.MAGE
        );

        Character hero3 = new Character(
                3, "Robin", 4, CharacterType.ARCHER
        );

        // Menampilkan data karakter
        System.out.println("\n--- DATA KARAKTER ---");
        System.out.println(hero1);
        System.out.println(hero2);
        System.out.println(hero3);

        // Demo level up
        System.out.println("\n--- DEMO LEVEL UP ---");

        System.out.println("Level Arthur sebelum: "
                + hero1.getLevel());

        hero1.levelUp();

        System.out.println("Level Arthur sesudah: "
                + hero1.getLevel());

        System.out.println("HP Arthur: "
                + hero1.getHitPoints());

        System.out.println("Attack Arthur: "
                + hero1.getAttack());

        // Mini Challenge
        System.out.println("\n--- MINI CHALLENGE ---");

        Character hero4 = new Character(
                4, "Arjuna", 6, CharacterType.ASSASSIN
        );

        hero4.setMana(100);

        System.out.println(hero4);

        System.out.println("Mana Arjuna: "
                + hero4.getMana());

        System.out.println("Apakah Arjuna masih hidup? "
                + hero4.isAlive());

        // Demo validasi mana
        System.out.println("\n--- VALIDASI MANA ---");

        try {
            hero4.setMana(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Validasi berhasil: "
                    + e.getMessage());
        }

        System.out.println("\n==================================");
        System.out.println("         PROGRAM SELESAI");
        System.out.println("==================================");
    }
}



























































