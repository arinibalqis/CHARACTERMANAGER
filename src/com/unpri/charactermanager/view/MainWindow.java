
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Component;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {

    private final CharacterManager characterManager;

    private JPanel characterPanel;
    private JPanel legendPanel;
    private JPanel statisticsPanel;

    private JLabel statusLabel;
    private JLabel totalLabel;
    private JLabel averageLabel;
    private JLabel highestLabel;
    private JLabel roleLabel;

    private static final int HIGHLIGHT_LEVEL_THRESHOLD = 5;

    public MainWindow(CharacterManager characterManager) {

        this.characterManager = characterManager;

        setTitle("Character Manager v0.5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(12, 12));

        getContentPane().setBackground(AppTheme.BACKGROUND);

        initializeComponents();

        setMinimumSize(new Dimension(650, 450));
        pack();
        setLocationRelativeTo(null);
    }

    private void initializeComponents() {

        JPanel mainPanel = new JPanel(new BorderLayout(12, 12));

        mainPanel.setBackground(AppTheme.BACKGROUND);
        mainPanel.setBorder(
                new EmptyBorder(15, 15, 15, 15)
        );

        // NORTH: Header dan statistik
        JPanel northPanel = new JPanel(new BorderLayout(0, 12));

        northPanel.setBackground(AppTheme.BACKGROUND);

        northPanel.add(createHeader(), BorderLayout.NORTH);

        northPanel.add(
                createStatisticsPanel(),
                BorderLayout.SOUTH
        );

        // CENTER: Daftar karakter dengan scrollbar
        JScrollPane scrollPane = createCharacterScrollPane();

        // EAST: Legenda role
        legendPanel = createLegendPanel();

        // SOUTH: Status bar
        JPanel statusPanel = createStatusPanel();

        // Menempatkan seluruh komponen
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(legendPanel, BorderLayout.EAST);
        mainPanel.add(statusPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
    }

    // HEADER
    private JPanel createHeader() {

        JPanel header = new JPanel(new BorderLayout());

        header.setBackground(AppTheme.PANEL);
        header.setBorder(
                new EmptyBorder(15, 18, 15, 18)
        );

        JLabel title = new JLabel("CHARACTER MANAGER");

        title.setFont(AppTheme.TITLE_FONT);
        title.setForeground(AppTheme.TEXT);

        JLabel subtitle = new JLabel(
                "Manage your characters and explore their roles"
        );

        subtitle.setFont(AppTheme.SUBTITLE_FONT);
        subtitle.setForeground(AppTheme.MUTED);

        JPanel textPanel = new JPanel();

        textPanel.setLayout(
                new BoxLayout(textPanel, BoxLayout.Y_AXIS)
        );

        textPanel.setBackground(AppTheme.PANEL);

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(5));
        textPanel.add(subtitle);

        header.add(textPanel, BorderLayout.WEST);

        return header;
    }

    // STATISTICS PANEL
    private JPanel createStatisticsPanel() {

        statisticsPanel = new JPanel(
                new GridLayout(2, 2, 10, 10)
        );

        statisticsPanel.setBackground(AppTheme.BACKGROUND);

        statisticsPanel.add(
                createStatisticCard("TOTAL CHARACTERS", "0")
        );

        statisticsPanel.add(
                createStatisticCard("AVERAGE LEVEL", "0")
        );

        statisticsPanel.add(
                createStatisticCard("HIGHEST LEVEL", "0")
        );

        statisticsPanel.add(
                createStatisticCard("TOTAL ROLES", "0")
        );

        updateStatistics();

        return statisticsPanel;
    }

    private JPanel createStatisticCard(
            String title,
            String value
    ) {

        JPanel card = new JPanel(
                new FlowLayout(FlowLayout.LEFT, 12, 8)
        );

        card.setBackground(AppTheme.CARD);
        card.setBorder(AppTheme.panelBorder());

        JLabel titleLabel = new JLabel(title);

        titleLabel.setFont(AppTheme.SMALL_FONT);
        titleLabel.setForeground(AppTheme.MUTED);

        JLabel valueLabel = new JLabel(value);

        valueLabel.setFont(AppTheme.HEADING_FONT);
        valueLabel.setForeground(AppTheme.TEXT);

        card.setLayout(new BorderLayout(0, 5));

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        AppTheme.panelBorder(),
                        new EmptyBorder(8, 12, 8, 12)
                )
        );

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);

        return card;
    }

    // CHARACTER SCROLL PANE
    private JScrollPane createCharacterScrollPane() {

        characterPanel = new JPanel(
                new GridLayout(0, 2, 12, 12)
        );

        characterPanel.setBackground(AppTheme.BACKGROUND);

        characterPanel.setBorder(
                new EmptyBorder(5, 5, 5, 5)
        );

        refreshCharacterCards();

        // Panel pembungkus agar kartu tetap dimulai dari atas
        JPanel wrapperPanel = new JPanel(
                new BorderLayout()
        );

        wrapperPanel.setBackground(AppTheme.BACKGROUND);

        wrapperPanel.add(
                characterPanel,
                BorderLayout.NORTH
        );

        JScrollPane scroll = new JScrollPane(wrapperPanel);

        scroll.setPreferredSize(
                new Dimension(650, 350)
        );

        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );

        scroll.getViewport().setBackground(
                AppTheme.BACKGROUND
        );

        scroll.setBorder(AppTheme.panelBorder());

        return scroll;
    }

    // MEMBUAT KARTU KARAKTER
    private void refreshCharacterCards() {

        characterPanel.removeAll();

        List<Character> characters =
                characterManager.getAllCharacters();

        for (Character character : characters) {

            characterPanel.add(
                    createCharacterCard(character)
            );
        }

        characterPanel.revalidate();
        characterPanel.repaint();
    }

    private JPanel createCharacterCard(Character character) {

        JPanel card = new JPanel(
                new BorderLayout(8, 8)
        );

        card.setBackground(AppTheme.CARD);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        AppTheme.borderFor(character.getType()),
                        new EmptyBorder(12, 12, 12, 12)
                )
        );

        JLabel nameLabel = new JLabel(
                character.getName()
        );

        nameLabel.setFont(AppTheme.HEADING_FONT);
        nameLabel.setForeground(AppTheme.TEXT);

        JLabel roleLabel = new JLabel(
                character.getType().name()
        );

        roleLabel.setFont(AppTheme.SMALL_FONT);
        roleLabel.setForeground(
                AppTheme.colorFor(character.getType())
        );

        JLabel levelLabel = new JLabel(
                "Level: " + character.getLevel()
        );

        levelLabel.setFont(AppTheme.BODY_FONT);
        levelLabel.setForeground(AppTheme.MUTED);

        JLabel hpLabel = new JLabel(
                "HP: " + character.getHitPoints()
        );

        hpLabel.setFont(AppTheme.BODY_FONT);
        hpLabel.setForeground(AppTheme.MUTED);

        JPanel topPanel = new JPanel(
                new BorderLayout()
        );

        topPanel.setBackground(AppTheme.CARD);

        topPanel.add(nameLabel, BorderLayout.NORTH);
        topPanel.add(roleLabel, BorderLayout.SOUTH);

        JPanel detailPanel = new JPanel(
                new FlowLayout(FlowLayout.LEFT, 10, 5)
        );

        detailPanel.setBackground(AppTheme.CARD);

        detailPanel.add(levelLabel);
        detailPanel.add(hpLabel);

        if (character.getLevel() >= HIGHLIGHT_LEVEL_THRESHOLD) {

            card.setToolTipText(
                    "High level character"
            );
        }

        card.add(topPanel, BorderLayout.NORTH);
        card.add(detailPanel, BorderLayout.CENTER);

        card.setPreferredSize(
                new Dimension(220, 105)
        );

        return card;
    }

    // LEGEND PANEL
    private JPanel createLegendPanel() {

        JPanel legend = new JPanel();

        // Target BoxLayout adalah container legend
        legend.setLayout(
                new BoxLayout(legend, BoxLayout.Y_AXIS)
        );

        legend.setBackground(AppTheme.PANEL);

        legend.setBorder(
                new EmptyBorder(15, 12, 15, 12)
        );

        JLabel title = new JLabel("CHARACTER ROLES");

        title.setFont(AppTheme.HEADING_FONT);
        title.setForeground(AppTheme.TEXT);

        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        legend.add(title);

        legend.add(Box.createVerticalStrut(20));

        // Legenda dibuat berdasarkan enum
        for (CharacterType type : CharacterType.values()) {

            JLabel roleItem = new JLabel(
                    "●  " + type.name()
            );

            roleItem.setFont(AppTheme.BODY_FONT);

            roleItem.setForeground(
                    AppTheme.colorFor(type)
            );

            roleItem.setAlignmentX(
                    Component.LEFT_ALIGNMENT
            );

            legend.add(roleItem);

            legend.add(Box.createVerticalStrut(15));
        }

        // Glue mendorong ruang kosong ke bagian bawah
        legend.add(Box.createVerticalGlue());

        legend.setPreferredSize(
                new Dimension(165, 200)
        );

        return legend;
    }

    // STATUS BAR
    private JPanel createStatusPanel() {

        JPanel statusPanel = new JPanel(
                new BorderLayout()
        );

        statusPanel.setBackground(AppTheme.PANEL);

        statusPanel.setBorder(
                new EmptyBorder(10, 15, 10, 15)
        );

        statusLabel = new JLabel(
                "Character Manager is running"
        );

        statusLabel.setFont(AppTheme.SMALL_FONT);
        statusLabel.setForeground(AppTheme.MUTED);

        JLabel versionLabel = new JLabel("v0.5");

        versionLabel.setFont(AppTheme.SMALL_FONT);
        versionLabel.setForeground(AppTheme.ACCENT);

        statusPanel.add(
                statusLabel,
                BorderLayout.WEST
        );

        statusPanel.add(
                versionLabel,
                BorderLayout.EAST
        );

        return statusPanel;
    }

    // UPDATE STATISTIK
    private void updateStatistics() {

        if (statisticsPanel == null) {
            return;
        }

        List<Character> characters =
                characterManager.getAllCharacters();

        int totalCharacters = characters.size();

        int totalLevel = 0;
        int highestLevel = 0;

        for (Character character : characters) {

            totalLevel += character.getLevel();

            if (character.getLevel() > highestLevel) {
                highestLevel = character.getLevel();
            }
        }

        double averageLevel = totalCharacters > 0
                ? (double) totalLevel / totalCharacters
                : 0;

        int totalRoles = CharacterType.values().length;

        updateStatisticValue(0, String.valueOf(totalCharacters));

        updateStatisticValue(
                1,
                String.format("%.2f", averageLevel)
        );

        updateStatisticValue(
                2,
                String.valueOf(highestLevel)
        );

        updateStatisticValue(
                3,
                String.valueOf(totalRoles)
        );

        statisticsPanel.revalidate();
        statisticsPanel.repaint();
    }

    private void updateStatisticValue(
            int index,
            String value
    ) {

        JPanel card = (JPanel) statisticsPanel.getComponent(index);

        JLabel valueLabel = (JLabel) card.getComponent(1);

        valueLabel.setText(value);
    }

    // Memperbarui tampilan setelah data berubah
    public void refreshView() {

        refreshCharacterCards();
        updateStatistics();

        statusLabel.setText(
                "Character data updated"
        );

        revalidate();
        repaint();
    }
}
