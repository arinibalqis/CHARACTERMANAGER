
package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import com.unpri.charactermanager.model.CharacterType;

public final class AppTheme {

    // Background
    public static final Color BACKGROUND =
            new Color(239, 244, 255);

    public static final Color PANEL =
            new Color(255, 255, 255);

    public static final Color CARD =
            new Color(255, 255, 255);

    // Text
    public static final Color TEXT =
            new Color(35, 45, 75);

    public static final Color MUTED =
            new Color(110, 120, 145);

    // Main colors
    public static final Color ACCENT =
            new Color(76, 110, 245);

    public static final Color SUCCESS =
            new Color(39, 174, 96);

    public static final Color ERROR =
            new Color(231, 76, 60);

    public static final Color FIELD =
            new Color(248, 250, 255);

    // Role colors
    public static final Color ORANGE =
            new Color(243, 156, 18);

    public static final Color PURPLE =
            new Color(142, 68, 173);

    public static final Color GREEN =
            new Color(39, 174, 96);

    public static final Color BLUE =
            new Color(52, 152, 219);

    // Fonts
    public static final Font TITLE_FONT =
            new Font("SansSerif", Font.BOLD, 24);

    public static final Font HEADING_FONT =
            new Font("SansSerif", Font.BOLD, 16);

    public static final Font BODY_FONT =
            new Font("SansSerif", Font.PLAIN, 13);

    public static final Font SMALL_FONT =
            new Font("SansSerif", Font.PLAIN, 11);

    // Border
    public static final Border PANEL_BORDER =
            BorderFactory.createEmptyBorder(
                    12, 14, 12, 14
            );

    private AppTheme() {
    }

    public static Color colorFor(String status) {

        if ("error".equalsIgnoreCase(status)) {
            return ERROR;
        }

        if ("success".equalsIgnoreCase(status)) {
            return SUCCESS;
        }

        return ACCENT;
    }

    public static Color colorForRole(CharacterType type) {

        if (type == null) {
            return ACCENT;
        }

        switch (type) {

            case WARRIOR:
                return ORANGE;

            case MAGE:
                return PURPLE;

            case ARCHER:
                return GREEN;

            case ASSASSIN:
                return BLUE;

            default:
                return ACCENT;
        }
    }

    public static Color backgroundForRole(CharacterType type) {

        if (type == null) {
            return CARD;
        }

        switch (type) {

            case WARRIOR:
                return new Color(255, 241, 220);

            case MAGE:
                return new Color(245, 230, 255);

            case ARCHER:
                return new Color(225, 250, 232);

            case ASSASSIN:
                return new Color(225, 240, 255);

            default:
                return CARD;
        }
    }
}
