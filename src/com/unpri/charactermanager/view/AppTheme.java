
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class AppTheme {

    private AppTheme() {
    }

    // Warna utama aplikasi
    public static final Color BACKGROUND = new Color(24, 28, 36);
    public static final Color PANEL = new Color(35, 41, 52);
    public static final Color CARD = new Color(44, 51, 64);
    public static final Color TEXT = new Color(240, 243, 248);
    public static final Color MUTED = new Color(165, 175, 190);
    public static final Color ACCENT = new Color(74, 144, 226);
    public static final Color BORDER = new Color(65, 75, 90);

    // Font aplikasi
    public static final Font TITLE_FONT =
            new Font("Segoe UI", Font.BOLD, 23);

    public static final Font SUBTITLE_FONT =
            new Font("Segoe UI", Font.PLAIN, 13);

    public static final Font HEADING_FONT =
            new Font("Segoe UI", Font.BOLD, 15);

    public static final Font BODY_FONT =
            new Font("Segoe UI", Font.PLAIN, 13);

    public static final Font SMALL_FONT =
            new Font("Segoe UI", Font.PLAIN, 11);

    // Warna berdasarkan role karakter
    public static Color colorFor(CharacterType type) {

        switch (type) {
            case WARRIOR:
                return new Color(220, 90, 90);

            case MAGE:
                return new Color(125, 105, 230);

            case ARCHER:
                return new Color(75, 175, 125);

            case ASSASSIN:
                return new Color(220, 155, 65);

            default:
                return ACCENT;
        }
    }

    // Border berdasarkan role karakter
    public static Border borderFor(CharacterType type) {

        return BorderFactory.createLineBorder(
                colorFor(type), 2, true
        );
    }

    // Border umum panel
    public static Border panelBorder() {

        return BorderFactory.createLineBorder(
                BORDER, 1, true
        );
    }
}
