package com.github.pawelkowalski92.cli;

import com.github.pawelkowalski92.drawer.FontProvider;
import com.github.pawelkowalski92.drawer.WordDrawer;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.github.pawelkowalski92.drawer.FontColor.CYAN;
import static java.nio.file.StandardOpenOption.*;

public class Application {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Missing word!");
        }

        FontProvider fontProvider = FontProvider.forMonospacedFont()
                .withSize(72);
        WordDrawer wordDrawer = new WordDrawer(fontProvider);

        String word = args[0];
        Path file = Path.of(word + ".png");

        try (OutputStream os = Files.newOutputStream(file, CREATE, WRITE, TRUNCATE_EXISTING)) {
            wordDrawer.drawWord(word, CYAN).saveTo(os);
        }
    }
}
