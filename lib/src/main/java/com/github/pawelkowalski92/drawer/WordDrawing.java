package com.github.pawelkowalski92.drawer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;

public class WordDrawing {

    public static final String DEFAULT_IMAGE_FORMAT = "png";

    private final BufferedImage image;

    WordDrawing(BufferedImage image) {
        this.image = image;
    }

    public void saveTo(OutputStream os) throws IOException {
        ImageIO.write(image, DEFAULT_IMAGE_FORMAT, os);
    }

    public byte[] saveAsBytes() {
        int size = Math.multiplyExact(image.getWidth(), image.getHeight());
        try (ByteArrayOutputStream os = new ByteArrayOutputStream(size)) {
            saveTo(os);
            return os.toByteArray();
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

}
