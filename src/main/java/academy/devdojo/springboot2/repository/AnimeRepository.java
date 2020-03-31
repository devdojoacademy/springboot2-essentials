package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.util.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AnimeRepository {

    private final Utils utils;
    private static List<Anime> animes;

    static {
        animes = new ArrayList<>(List.of(new Anime(1, "Boku No Hero"),
            new Anime(2, "Berserk"),
            new Anime(3, "Naruto")));
    }

    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(int id) {
        return utils.findAnimeOrThrowNotFound(id, animes);
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextInt(4, 100000));
        animes.add(anime);
        return anime;
    }

    public void delete(int id) {
        animes.remove(utils.findAnimeOrThrowNotFound(id, animes));
    }

    public void update(Anime anime) {
        animes.remove(utils.findAnimeOrThrowNotFound(anime.getId(), animes));
        animes.add(anime);
    }
}
