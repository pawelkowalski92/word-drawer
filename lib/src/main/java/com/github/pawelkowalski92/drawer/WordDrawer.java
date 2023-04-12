package com.github.pawelkowalski92.drawer;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.github.pawelkowalski92.drawer.FontColor.BLACK;
import static java.awt.image.BufferedImage.*;

public class WordDrawer {

    private final FontProvider fontProvider;

    public WordDrawer(FontProvider fontProvider) {
        this.fontProvider = fontProvider;
    }

    public WordDrawing drawWord(CharSequence word) {
        return drawWord(word, BLACK);
    }

    public WordDrawing drawWord(CharSequence word, FontColor color) {
        String wordStr = String.valueOf(word);
        FontMetrics metrics = fontProvider.measureFont();

        int width = metrics.stringWidth(wordStr);
        int height = metrics.getHeight();

        BufferedImage image = new BufferedImage(width, height, TYPE_INT_ARGB);
        Graphics drawingCtx = image.createGraphics();

        drawingCtx.setColor(Color.WHITE);
        drawingCtx.fillRect(0, 0, width, height);

        fontProvider.applyFontTo(drawingCtx);
        color.applyColorTo(drawingCtx);

        drawingCtx.drawString(wordStr, 0, height - metrics.getDescent());

        return new WordDrawing(image);
    }

}
