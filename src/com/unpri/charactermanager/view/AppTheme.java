
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
    public static final Color BACKGROUND_COLOR =
            new Color(244, 246, 250);

    public static final Color CARD_COLOR =
            new Color(255, 255, 255);

    public static final Color TEXT_COLOR =
            new Color(38, 50, 56);

    public static final Color MUTED_COLOR =
            new Color(96, 125, 139);

    public static final Color GOLD_COLOR =
            new Color(197, 139, 0);

    // Warna berdasarkan role
    public static final Color WARRIOR_COLOR =
            new Color(253, 235, 208);

    public static final Color MAGE_COLOR =
            new Color(232, 218, 239);

    public static final Color ARCHER_COLOR =
            new Color(214, 234, 248);

    public static final Color ASSASSIN_COLOR =
            new Color(245, 183, 177);

    // Font aplikasi
    public static final Font HEADER_FONT =
            new Font("SansSerif", Font.BOLD, 24);

    public static final Font BODY_FONT =
            new Font("SansSerif", Font.PLAIN, 14);

    public static final Font STAT_FONT =
            new Font("SansSerif", Font.BOLD, 16);

    public static final Font HIGHLIGHT_FONT =
            BODY_FONT.deriveFont(Font.BOLD, 15f);

    // Border utama
    public static final Border PANEL_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            new Color(210, 215, 220), 1
                    ),
                    BorderFactory.createEmptyBorder(
                            10, 12, 10, 12
                    )
            );

    // Mengatur warna kartu berdasarkan role
    public static Color colorFor(CharacterType type) {

        if (type == null) {
            return CARD_COLOR;
        }

        switch (type) {
            case WARRIOR:
                return WARRIOR_COLOR;

            case MAGE:
                return MAGE_COLOR;

            case ARCHER:
                return ARCHER_COLOR;

            case ASSASSIN:
                return ASSASSIN_COLOR;

            default:
                return CARD_COLOR;
        }
    }

    // Border berbeda berdasarkan role
    public static Border borderFor(CharacterType type) {

        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        colorFor(type).darker(), 2
                ),
                BorderFactory.createEmptyBorder(
                        10, 12, 10, 12
                )
        );
    }
}
