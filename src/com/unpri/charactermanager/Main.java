
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            CharacterManager manager =
                    new CharacterManager();

            // Karakter pertama
            manager.addCharacter(
                    new Character(
                            1, "Arthur", 5,
                            CharacterType.WARRIOR
                    )
            );

            // Karakter kedua
            manager.addCharacter(
                    new Character(
                            2, "Merlin", 10,
                            CharacterType.MAGE
                    )
            );

            // Karakter ketiga
            manager.addCharacter(
                    new Character(
                            3, "Robin", 3,
                            CharacterType.ARCHER
                    )
            );

            // Karakter keempat
            manager.addCharacter(
                    new Character(
                            4, "Arjuna", 12,
                            CharacterType.ASSASSIN
                    )
            );

            // Karakter kelima
            manager.addCharacter(
                    new Character(
                            5, "Leon", 15,
                            CharacterType.WARRIOR
                    )
            );

            // Karakter keenam
            manager.addCharacter(
                    new Character(
                            6, "Freya", 7,
                            CharacterType.MAGE
                    )
            );

            // Membuka aplikasi GUI
            MainWindow window =
                    new MainWindow(manager);

            window.setVisible(true);

        });
    }
}
