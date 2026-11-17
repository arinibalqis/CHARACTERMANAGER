
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final CharacterManager manager;
    private final JPanel characterPanel;
    private final JLabel averageLevelLabel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager v0.3");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Header
        JLabel header = new JLabel(
                "CHARACTER MANAGER",
                SwingConstants.CENTER
        );

        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        add(header, BorderLayout.NORTH);

        // Daftar karakter
        characterPanel = new JPanel();
        characterPanel.setLayout(
                new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
        );

        characterPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );

        JScrollPane scrollPane = new JScrollPane(characterPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Bagian bawah
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 15, 15)
        );

        averageLevelLabel = new JLabel();
        averageLevelLabel.setFont(new Font("Arial", Font.BOLD, 15));

        JButton addButton = new JButton("Tambah Karakter");

        addButton.addActionListener(event -> addNewCharacter());

        bottomPanel.add(averageLevelLabel, BorderLayout.CENTER);
        bottomPanel.add(addButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        refreshCharacterList();
    }

    private void refreshCharacterList() {
        characterPanel.removeAll();

        for (Character character : manager.getAllCharacters()) {
            JLabel characterLabel = new JLabel(character.toString());

            characterLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            characterLabel.setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                            BorderFactory.createEmptyBorder(10, 10, 10, 10)
                    )
            );

            characterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            characterPanel.add(characterLabel);
            characterPanel.add(Box.createVerticalStrut(8));
        }

        updateAverageLevel();

        characterPanel.revalidate();
        characterPanel.repaint();
    }

    private void updateAverageLevel() {
        double average = manager.getAverageLevel();

        averageLevelLabel.setText(
                String.format("Rata-rata Level: %.2f", average)
        );
    }

    private void addNewCharacter() {
        int newId = manager.getTotalCharacters() + 1;

        Character newCharacter = new Character(
                newId,
                "Character " + newId,
                10,
                com.unpri.charactermanager.model.CharacterType.MAGE
        );

        manager.addCharacter(newCharacter);

        refreshCharacterList();
    }
}
