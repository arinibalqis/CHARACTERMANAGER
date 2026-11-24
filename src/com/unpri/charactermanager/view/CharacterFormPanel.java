
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Font;

import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComponent;

import javax.swing.border.Border;

public class CharacterFormPanel extends JPanel {

    private final CharacterManager manager;
    private final Runnable onCharacterAdded;

    private final JTextField nameField;
    private final JComboBox<CharacterType> roleCombo;
    private final JSpinner levelSpinner;

    private final JLabel messageLabel;

    private final Border normalNameBorder;
    private final Border normalRoleBorder;
    private final Border normalLevelBorder;

    public CharacterFormPanel(
            CharacterManager manager,
            Runnable onCharacterAdded) {

        this.manager = manager;
        this.onCharacterAdded = onCharacterAdded;

        setLayout(new BorderLayout(10, 10));
        setBackground(AppTheme.PANEL);

        setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                    AppTheme.ACCENT,
                    2
                ),
                BorderFactory.createEmptyBorder(
                    14, 14, 14, 14
                )
            )
        );

        // Judul form
        JLabel title = new JLabel(
            "✦ Tambah Karakter Baru"
        );

        title.setFont(AppTheme.HEADING_FONT);
        title.setForeground(AppTheme.ACCENT);

        // Komponen input
        nameField = new JTextField(15);

        roleCombo = new JComboBox<>(
            CharacterType.values()
        );

        levelSpinner = new JSpinner(
            new SpinnerNumberModel(1, 1, 99, 1)
        );

        // Simpan border asli
        normalNameBorder = nameField.getBorder();
        normalRoleBorder = roleCombo.getBorder();
        normalLevelBorder = levelSpinner.getBorder();

        styleInput(nameField);
        styleInput(roleCombo);
        styleInput(levelSpinner);

        // Panel form
        JPanel fields = new JPanel(
            new GridBagLayout()
        );

        fields.setOpaque(false);

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addField(
            fields, gbc, 0,
            "Nama Karakter",
            nameField
        );

        addField(
            fields, gbc, 1,
            "Role Karakter",
            roleCombo
        );

        addField(
            fields, gbc, 2,
            "Level (1-99)",
            levelSpinner
        );

        // Tombol tambah
        JButton addButton =
                new JButton("✚ Tambah Karakter");

        addButton.setFont(
            new Font("SansSerif", Font.BOLD, 13)
        );

        addButton.setBackground(AppTheme.ACCENT);
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorderPainted(false);
        addButton.setOpaque(true);

        addButton.setBorder(
            BorderFactory.createEmptyBorder(
                10, 18, 10, 18
            )
        );

        addButton.addActionListener(
            event -> submitForm()
        );

        JPanel buttonPanel =
                new JPanel(
                    new FlowLayout(FlowLayout.RIGHT)
                );

        buttonPanel.setOpaque(false);
        buttonPanel.add(addButton);

        // Pesan validasi
        messageLabel = new JLabel(
            "Isi data karakter, lalu tekan Tambah Karakter."
        );

        messageLabel.setFont(AppTheme.SMALL_FONT);
        messageLabel.setForeground(AppTheme.MUTED);

        JPanel bottom =
                new JPanel(new BorderLayout(5, 5));

        bottom.setOpaque(false);

        bottom.add(
            messageLabel,
            BorderLayout.CENTER
        );

        bottom.add(
            buttonPanel,
            BorderLayout.EAST
        );

        JPanel content =
                new JPanel(new BorderLayout(5, 5));

        content.setOpaque(false);

        content.add(
            fields,
            BorderLayout.CENTER
        );

        content.add(
            bottom,
            BorderLayout.SOUTH
        );

        add(title, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);
    }

    private void styleInput(JComponent component) {

        component.setFont(AppTheme.BODY_FONT);
        component.setBackground(AppTheme.FIELD);
        component.setForeground(AppTheme.TEXT);
    }

    private void addField(
            JPanel panel,
            GridBagConstraints gbc,
            int row,
            String labelText,
            JComponent component) {

        gbc.gridy = row;

        gbc.gridx = 0;
        gbc.weightx = 0;

        JLabel label = new JLabel(labelText);

        label.setFont(AppTheme.BODY_FONT);
        label.setForeground(AppTheme.TEXT);

        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;

        panel.add(component, gbc);
    }

    /**
     * Validasi nama berdasarkan urutan:
     * 1. Kelengkapan
     * 2. Panjang
     * 3. Format
     * 4. Keunikan
     */
    public String validateName(String name) {

        // 1. Kelengkapan
        if (name == null || name.trim().isEmpty()) {

            return "Nama karakter wajib diisi.";
        }

        String cleanedName = name.trim();

        // 2. Panjang
        if (cleanedName.length() < 3 ||
            cleanedName.length() > 20) {

            return "Nama harus terdiri dari 3 sampai 20 karakter.";
        }

        // 3. Format
        if (!cleanedName.matches("[A-Za-z ]+")) {

            return "Nama hanya boleh berisi huruf dan spasi.";
        }

        // 4. Keunikan
        if (manager.isNameTaken(cleanedName)) {

            return "Nama karakter \""
                    + cleanedName
                    + "\" sudah digunakan.";
        }

        return null;
    }

    /**
     * Proses penambahan karakter.
     */
    private void submitForm() {

        resetBorders();

        String cleanedName =
                nameField.getText().trim();

        // Validasi nama
        String nameError =
                validateName(cleanedName);

        if (nameError != null) {

            showError(nameError, nameField);
            return;
        }

        // Membaca level spinner
        final int level;

        try {

            levelSpinner.commitEdit();

            Object spinnerValue =
                    levelSpinner.getValue();

            level =
                    ((Number) spinnerValue).intValue();

        } catch (ParseException | IllegalArgumentException ex) {

            showError(
                "Level harus berupa angka bulat antara 1 sampai 99.",
                levelSpinner
            );

            return;
        }

        // Membaca role
        CharacterType selectedType =
                (CharacterType) roleCombo.getSelectedItem();

        try {

            // Membuat karakter
            Character character =
                    new Character(
                        cleanedName,
                        selectedType,
                        level
                    );

            // Menambahkan ke Model
            manager.addCharacter(character);

            // Pesan berhasil
            messageLabel.setText(
                "✓ Karakter berhasil ditambahkan: "
                + character.getName()
            );

            messageLabel.setForeground(
                AppTheme.SUCCESS
            );

            // Membersihkan form
            nameField.setText("");
            roleCombo.setSelectedIndex(0);
            levelSpinner.setValue(1);

            resetBorders();

            nameField.requestFocusInWindow();

            // Memperbarui daftar
            if (onCharacterAdded != null) {
                onCharacterAdded.run();
            }

        } catch (IllegalArgumentException ex) {

            // Pesan error berasal dari Model
            showError(
                ex.getMessage(),
                selectedType == CharacterType.MAGE
                        ? roleCombo
                        : nameField
            );
        }
    }

    /**
     * Menampilkan pesan kesalahan.
     */
    private void showError(
            String message,
            JComponent source) {

        messageLabel.setText("✖ " + message);

        messageLabel.setForeground(
            AppTheme.ERROR
        );

        source.setBorder(
            BorderFactory.createLineBorder(
                AppTheme.ERROR,
                2
            )
        );

        source.requestFocusInWindow();
    }

    /**
     * Mengembalikan border ke kondisi normal.
     */
    private void resetBorders() {

        nameField.setBorder(normalNameBorder);

        roleCombo.setBorder(normalRoleBorder);

        levelSpinner.setBorder(normalLevelBorder);
    }
}
