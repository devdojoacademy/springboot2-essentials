package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

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

    public void delete(int id){
        animes.remove(animes.stream()
            .filter(anime -> anime.getId() == id)
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime Not Found")));
    }
}
