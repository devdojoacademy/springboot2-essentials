package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Repository;

@Repository
public class AnimeRepository {

    private static List<Anime> animes;

    static {
        animes = new ArrayList<>(List.of(new Anime(1, "Boku No Hero"),
            new Anime(2, "Berserk"),
            new Anime(3, "Naruto")));
    }

    public List<Anime> listAll() {
        return animes;
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextInt(4, 100000));
        animes.add(anime);
        return anime;
    }
}
