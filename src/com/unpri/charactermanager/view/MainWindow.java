
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private static final int HIGHLIGHT_LEVEL_THRESHOLD = 5;

    private final CharacterManager manager;

    private JPanel characterPanel;
    private JLabel totalLabel;
    private JLabel averageLabel;

    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager v0.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(
                AppTheme.BACKGROUND_COLOR
        );

        createComponents();
        displayCharacters();

        pack();
        setLocationRelativeTo(null);
        setMinimumSize(getSize());
    }

    private void createComponents() {

        setLayout(new BorderLayout(10, 10));

        // Header
        JLabel header = new JLabel(
                "CHARACTER MANAGER",
                SwingConstants.CENTER
        );

        header.setFont(AppTheme.HEADER_FONT);
        header.setForeground(AppTheme.TEXT_COLOR);
        header.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 10, 15, 10
                )
        );

        add(header, BorderLayout.NORTH);

        // Panel daftar karakter
        characterPanel = new JPanel();

        characterPanel.setLayout(
                new BoxLayout(
                        characterPanel,
                        BoxLayout.Y_AXIS
                )
        );

        characterPanel.setBackground(
                AppTheme.BACKGROUND_COLOR
        );

        characterPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 15, 10, 15
                )
        );

        JScrollPane scrollPane =
                new JScrollPane(characterPanel);

        scrollPane.setPreferredSize(
                new Dimension(620, 400)
        );

        scrollPane.setBorder(null);

        scrollPane.getViewport().setBackground(
                AppTheme.BACKGROUND_COLOR
        );

        add(scrollPane, BorderLayout.CENTER);

        // Footer statistik
        JPanel footer = new JPanel(
                new GridLayout(1, 2, 15, 0)
        );

        footer.setBackground(
                AppTheme.BACKGROUND_COLOR
        );

        footer.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 15, 20, 15
                )
        );

        totalLabel = new JLabel(
                "",
                SwingConstants.CENTER
        );

        averageLabel = new JLabel(
                "",
                SwingConstants.CENTER
        );

        totalLabel.setFont(AppTheme.STAT_FONT);
        averageLabel.setFont(AppTheme.STAT_FONT);

        totalLabel.setForeground(AppTheme.TEXT_COLOR);
        averageLabel.setForeground(AppTheme.GOLD_COLOR);

        footer.add(totalLabel);
        footer.add(averageLabel);

        add(footer, BorderLayout.SOUTH);
    }

    private void displayCharacters() {

        characterPanel.removeAll();

        ArrayList<Character> characters =
                manager.getAllCharacters();

        for (Character character : characters) {

            JPanel card = createCharacterCard(character);

            card.setAlignmentX(Component.LEFT_ALIGNMENT);

            characterPanel.add(card);

            characterPanel.add(
                    Box.createVerticalStrut(10)
            );
        }

        totalLabel.setText(
                "Total Karakter: " +
                manager.getTotalCharacters()
        );

        averageLabel.setText(
                String.format(
                        "Rata-rata Level: %.2f",
                        manager.getAverageLevel()
                )
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }

    private JPanel createCharacterCard(Character character) {

        JPanel card = new JPanel(
                new BorderLayout(15, 5)
        );

        // Warna dan border berdasarkan role
        card.setBackground(
                AppTheme.colorFor(character.getType())
        );

        card.setBorder(
                AppTheme.borderFor(character.getType())
        );

        card.setOpaque(true);

        // Informasi karakter
        JPanel informationPanel = new JPanel();

        informationPanel.setLayout(
                new BoxLayout(
                        informationPanel,
                        BoxLayout.Y_AXIS
                )
        );

        informationPanel.setOpaque(false);

        JLabel nameLabel = new JLabel(
                character.getName()
        );

        nameLabel.setFont(AppTheme.STAT_FONT);
        nameLabel.setForeground(AppTheme.TEXT_COLOR);

        JLabel typeLabel = new JLabel(
                "Role: " + character.getType()
        );

        typeLabel.setFont(AppTheme.BODY_FONT);
        typeLabel.setForeground(AppTheme.MUTED_COLOR);

        informationPanel.add(nameLabel);
        informationPanel.add(typeLabel);

        // Informasi level
        JLabel levelLabel = new JLabel(
                "Level " + character.getLevel()
        );

        if (character.getLevel() >= HIGHLIGHT_LEVEL_THRESHOLD) {

            levelLabel.setForeground(
                    AppTheme.GOLD_COLOR
            );

            levelLabel.setFont(
                    AppTheme.HIGHLIGHT_FONT
            );

        } else {

            levelLabel.setForeground(
                    AppTheme.TEXT_COLOR
            );

            levelLabel.setFont(
                    AppTheme.BODY_FONT
            );
        }

        card.add(
                informationPanel,
                BorderLayout.CENTER
        );

        card.add(
                levelLabel,
                BorderLayout.EAST
        );

        // Properti tambahan pertama: Tooltip
        card.setToolTipText(
                "<html>"
                + "Nama: " + character.getName()
                + "<br>Level: " + character.getLevel()
                + "<br>Role: " + character.getType()
                + "<br>HP: " + character.getHitPoints()
                + "</html>"
        );

        // Properti tambahan kedua: Border berdasarkan role
        card.setPreferredSize(
                new Dimension(560, 75)
        );

        card.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 75)
        );

        return card;
    }
}
