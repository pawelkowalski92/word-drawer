package com.github.pawelkowalski92.drawer;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class FontProvider {

    public static final int DEFAULT_FONT_SIZE = 12;
    private final Font font;

    private FontProvider(Font font) {
        this.font = font;
    }

    public FontProvider withSize(int fontSize) {
        return new FontProvider(font.deriveFont((float) fontSize));
    }

    FontMetrics measureFont() {
        BufferedImage measureBox = new BufferedImage(1, 1, TYPE_INT_ARGB);
        Graphics drawingCtx = measureBox.createGraphics();
        try {
            return drawingCtx.getFontMetrics(font);
        } finally {
            drawingCtx.dispose();
        }
    }

    void applyFontTo(Graphics drawingCtx) {
        drawingCtx.setFont(font);
    }

    public static FontProvider forDefaultFont() {
        return new FontProvider(
                new Font(Font.SANS_SERIF, Font.PLAIN, DEFAULT_FONT_SIZE)
        );
    }

    public static FontProvider forMonospacedFont() {
        return new FontProvider(
                new Font(Font.MONOSPACED, Font.PLAIN, DEFAULT_FONT_SIZE)
        );
    }

}
