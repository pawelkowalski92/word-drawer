package com.github.pawelkowalski92.controller;

import com.github.pawelkowalski92.drawer.FontColor;
import com.github.pawelkowalski92.drawer.WordDrawer;
import com.github.pawelkowalski92.drawer.WordDrawing;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

@Controller("/word-drawer")
public class WordDrawingController {

    private final WordDrawer wordDrawer;

    @Inject
    public WordDrawingController(WordDrawer wordDrawer) {
        this.wordDrawer = wordDrawer;
    }

    @Get(produces = MediaType.IMAGE_PNG)
    public Publisher<byte[]> writeWord(@QueryValue("word") String word,
                                       @QueryValue(value = "color", defaultValue = "black") FontColor color) {
        return Mono.fromCallable(() -> wordDrawer.drawWord(word, color))
                .map(WordDrawing::saveAsBytes);
    }
}
