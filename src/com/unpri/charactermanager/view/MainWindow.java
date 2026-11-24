
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    private final JPanel characterListPanel;

    private final JLabel totalLabel;
    private final JLabel averageLabel;
    private final JLabel strongestLabel;

    private final JLabel statusLabel;

    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager v0.6");

        setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        setLayout(
            new BorderLayout(12, 12)
        );

        getContentPane().setBackground(
            AppTheme.BACKGROUND
        );

        // Label statistik
        totalLabel = createStatLabel();
        averageLabel = createStatLabel();
        strongestLabel = createStatLabel();

        // Status bawah
        statusLabel = new JLabel(
            "Character Manager siap digunakan"
        );

        statusLabel.setForeground(AppTheme.MUTED);
        statusLabel.setFont(AppTheme.SMALL_FONT);

        // Panel daftar karakter
        characterListPanel = new JPanel();

        characterListPanel.setLayout(
            new BoxLayout(
                characterListPanel,
                BoxLayout.Y_AXIS
            )
        );

        characterListPanel.setBackground(
            AppTheme.BACKGROUND
        );

        characterListPanel.setBorder(
            BorderFactory.createEmptyBorder(
                8, 8, 8, 8
            )
        );

        // Panel atas
        JPanel topPanel =
                new JPanel(new BorderLayout(10, 10));

        topPanel.setOpaque(false);

        topPanel.setBorder(
            BorderFactory.createEmptyBorder(
                12, 12, 0, 12
            )
        );

        topPanel.add(
            createHeader(),
            BorderLayout.NORTH
        );

        // Form input
        CharacterFormPanel formPanel =
                new CharacterFormPanel(
                    manager,
                    this::refreshList
                );

        topPanel.add(
            formPanel,
            BorderLayout.CENTER
        );

        // Scroll daftar karakter
        JScrollPane scrollPane =
                new JScrollPane(characterListPanel);

        scrollPane.setBorder(
            BorderFactory.createLineBorder(
                AppTheme.ACCENT,
                1
            )
        );

        scrollPane.getViewport().setBackground(
            AppTheme.BACKGROUND
        );

        scrollPane.setPreferredSize(
            new Dimension(560, 300)
        );

        // Panel legenda
        JPanel legendPanel = createLegend();

        legendPanel.setPreferredSize(
            new Dimension(180, 300)
        );

        // Panel tengah
        JPanel centerPanel =
                new JPanel(new BorderLayout(10, 0));

        centerPanel.setOpaque(false);

        centerPanel.setBorder(
            BorderFactory.createEmptyBorder(
                0, 12, 0, 12
            )
        );

        centerPanel.add(
            scrollPane,
            BorderLayout.CENTER
        );

        centerPanel.add(
            legendPanel,
            BorderLayout.EAST
        );

        // Panel bawah
        JPanel bottomPanel =
                new JPanel(
                    new FlowLayout(FlowLayout.LEFT)
                );

        bottomPanel.setBackground(
            new Color(225, 235, 255)
        );

        bottomPanel.setBorder(
            BorderFactory.createEmptyBorder(
                5, 12, 5, 12
            )
        );

        bottomPanel.add(statusLabel);

        // Memasang seluruh panel
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        refreshList();

        setMinimumSize(
            new Dimension(850, 650)
        );

        pack();

        setLocationRelativeTo(null);
    }

    /**
     * Membuat bagian header dan statistik.
     */
    private JPanel createHeader() {

        JPanel header =
                new JPanel(new BorderLayout(8, 8));

        header.setOpaque(false);

        JLabel title =
                new JLabel("✦ CHARACTER MANAGER");

        title.setFont(AppTheme.TITLE_FONT);
        title.setForeground(AppTheme.ACCENT);

        JPanel stats =
                new JPanel(
                    new GridLayout(1, 3, 10, 0)
                );

        stats.setOpaque(false);

        stats.add(
            createStatCard(
                "Total Karakter",
                totalLabel,
                new Color(225, 239, 255),
                AppTheme.ACCENT
            )
        );

        stats.add(
            createStatCard(
                "Rata-rata Level",
                averageLabel,
                new Color(239, 228, 255),
                AppTheme.PURPLE
            )
        );

        stats.add(
            createStatCard(
                "Serangan Tertinggi",
                strongestLabel,
                new Color(225, 248, 232),
                AppTheme.GREEN
            )
        );

        header.add(title, BorderLayout.NORTH);
        header.add(stats, BorderLayout.CENTER);

        return header;
    }

    /**
     * Membuat label statistik.
     */
    private JLabel createStatLabel() {

        JLabel label =
                new JLabel(
                    "-",
                    SwingConstants.CENTER
                );

        label.setFont(
            AppTheme.HEADING_FONT
        );

        label.setForeground(AppTheme.TEXT);

        return label;
    }

    /**
     * Membuat kartu statistik berwarna.
     */
    private JPanel createStatCard(
            String titleText,
            JLabel valueLabel,
            Color cardColor,
            Color accentColor) {

        JPanel card =
                new JPanel(
                    new BorderLayout(4, 4)
                );

        card.setBackground(cardColor);

        card.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                    accentColor,
                    1
                ),
                BorderFactory.createEmptyBorder(
                    12, 10, 12, 10
                )
            )
        );

        JLabel title =
                new JLabel(
                    titleText,
                    SwingConstants.CENTER
                );

        title.setFont(AppTheme.SMALL_FONT);
        title.setForeground(AppTheme.TEXT);

        valueLabel.setForeground(accentColor);

        card.add(title, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);

        return card;
    }

    /**
     * Membuat legenda role.
     */
    private JPanel createLegend() {

        JPanel legend = new JPanel();

        legend.setLayout(
            new BoxLayout(
                legend,
                BoxLayout.Y_AXIS
            )
        );

        legend.setBackground(AppTheme.PANEL);

        legend.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                    AppTheme.ACCENT,
                    1
                ),
                BorderFactory.createEmptyBorder(
                    12, 12, 12, 12
                )
            )
        );

        JLabel title =
                new JLabel("✦ ROLE KARAKTER");

        title.setFont(AppTheme.HEADING_FONT);
        title.setForeground(AppTheme.ACCENT);

        legend.add(title);

        legend.add(
            Box.createVerticalStrut(15)
        );

        addLegendItem(
            legend,
            CharacterType.WARRIOR,
            "WARRIOR"
        );

        addLegendItem(
            legend,
            CharacterType.MAGE,
            "MAGE"
        );

        addLegendItem(
            legend,
            CharacterType.ARCHER,
            "ARCHER"
        );

        addLegendItem(
            legend,
            CharacterType.ASSASSIN,
            "ASSASSIN"
        );

        legend.add(Box.createVerticalGlue());

        return legend;
    }

    /**
     * Menambahkan item legenda dengan warna role.
     */
    private void addLegendItem(
            JPanel panel,
            CharacterType type,
            String text) {

        JLabel item =
                new JLabel("●  " + text);

        item.setFont(AppTheme.BODY_FONT);

        item.setForeground(
            AppTheme.colorForRole(type)
        );

        panel.add(item);

        panel.add(
            Box.createVerticalStrut(12)
        );
    }

    /**
     * Memperbarui daftar karakter dan statistik.
     */
    public void refreshList() {

        characterListPanel.removeAll();

        for (Character character :
                manager.getAllCharacters()) {

            characterListPanel.add(
                createCharacterCard(character)
            );

            characterListPanel.add(
                Box.createVerticalStrut(10)
            );
        }

        // Tampilan ketika belum ada karakter
        if (manager.getTotalCharacters() == 0) {

            JLabel empty = new JLabel(
                "Belum ada karakter. Tambahkan melalui form di atas."
            );

            empty.setForeground(AppTheme.MUTED);
            empty.setFont(AppTheme.BODY_FONT);

            characterListPanel.add(empty);
        }

        // Memperbarui statistik
        totalLabel.setText(
            String.valueOf(
                manager.getTotalCharacters()
            )
        );

        averageLabel.setText(
            String.format(
                "%.2f",
                manager.getAverageLevel()
            )
        );

        Character strongest =
                manager.findStrongest();

        strongestLabel.setText(
            strongest == null
                ? "-"
                : strongest.getName()
                    + " (" + strongest.getAttack() + ")"
        );

        statusLabel.setText(
            "✦ Total "
            + manager.getTotalCharacters()
            + " karakter | Character Manager v0.6"
        );

        // Refresh tampilan
        characterListPanel.revalidate();
        characterListPanel.repaint();
    }

    /**
     * Membuat kartu karakter sesuai role.
     */
    private JPanel createCharacterCard(
            Character character) {

        Color roleColor =
                AppTheme.colorForRole(
                    character.getType()
                );

        Color cardColor =
                AppTheme.backgroundForRole(
                    character.getType()
                );

        JPanel card =
                new JPanel(
                    new BorderLayout(8, 5)
                );

        card.setBackground(cardColor);

        card.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                    roleColor,
                    2
                ),
                BorderFactory.createEmptyBorder(
                    10, 12, 10, 12
                )
            )
        );

        card.setMaximumSize(
            new Dimension(
                Integer.MAX_VALUE,
                115
            )
        );

        // Nama dan role
        JLabel name =
                new JLabel(
                    character.getName()
                    + " | "
                    + character.getType()
                );

        name.setFont(
            AppTheme.HEADING_FONT
        );

        name.setForeground(roleColor);

        // Level
        JLabel level =
                new JLabel(
                    "Level: "
                    + character.getLevel()
                );

        level.setFont(
            AppTheme.BODY_FONT
        );

        level.setForeground(AppTheme.TEXT);

        // Statistik karakter
        JLabel stats =
                new JLabel(
                    "HP: " + character.getHitPoints()
                    + "    ATK: " + character.getAttack()
                    + "    Mana: " + character.getMana()
                );

        stats.setFont(
            AppTheme.BODY_FONT
        );

        stats.setForeground(AppTheme.MUTED);

        JPanel information =
                new JPanel(
                    new GridLayout(2, 1, 3, 3)
                );

        information.setOpaque(false);

        information.add(level);
        information.add(stats);

        card.add(name, BorderLayout.NORTH);
        card.add(information, BorderLayout.CENTER);

        return card;
    }
}
