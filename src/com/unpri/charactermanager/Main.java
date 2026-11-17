
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            CharacterManager manager = new CharacterManager();

            // Membuat lima karakter awal
            manager.addCharacter(
                    new Character(1, "Arthur", 5, CharacterType.WARRIOR)
            );

            manager.addCharacter(
                    new Character(2, "Merlin", 10, CharacterType.MAGE)
            );

            manager.addCharacter(
                    new Character(3, "Robin", 8, CharacterType.ARCHER)
            );

            manager.addCharacter(
                    new Character(4, "Arjuna", 12, CharacterType.ASSASSIN)
            );

            manager.addCharacter(
                    new Character(5, "Lancelot", 15, CharacterType.WARRIOR)
            );

            // Menampilkan GUI
            MainWindow window = new MainWindow(manager);

            window.setVisible(true);
        });
    }
}
