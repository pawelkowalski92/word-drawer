package com.github.pawelkowalski92.drawer;

import java.awt.*;

public enum FontColor {

    BLACK(Color.BLACK),
    CYAN(Color.CYAN),
    RED(Color.RED),
    BLUE(Color.BLUE),
    GREEN(Color.GREEN);

    private final Color color;

    FontColor(Color color) {
        this.color = color;
    }

    void applyColorTo(Graphics drawingCtx) {
        drawingCtx.setColor(color);
    }
}
