package academy.devdojo.springboot2.util;

import academy.devdojo.springboot2.domain.Anime;

public class AnimeCreator {

    public static Anime createAnimeToBeSaved() {
        return Anime.builder()
            .name("Tensei Shitara Slime Datta Ken")
            .build();
    }

    public static Anime createValidAnime() {
        return Anime.builder()
            .name("Tensei Shitara Slime Datta Ken")
            .id(1)
            .build();
    }

    public static Anime createValidUpdatedAnime() {
        return Anime.builder()
            .name("Tensei Shitara Slime Datta Ken 2")
            .id(1)
            .build();
    }
}
