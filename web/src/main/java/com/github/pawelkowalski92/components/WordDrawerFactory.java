package com.github.pawelkowalski92.components;

import com.github.pawelkowalski92.drawer.FontProvider;
import com.github.pawelkowalski92.drawer.WordDrawer;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

@Factory
public class WordDrawerFactory {

    @Singleton
    public WordDrawer defaultDrawer(FontProvider fontProvider) {
        return new WordDrawer(fontProvider);
    }

    @Singleton
    public FontProvider monospacedFontProvider() {
        return FontProvider.forMonospacedFont().withSize(72);
    }
}
