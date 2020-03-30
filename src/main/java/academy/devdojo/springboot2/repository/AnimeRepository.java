package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class AnimeRepository {

    public List<Anime> listAll() {
        return List.of(new Anime(1, "Boku No Hero"),
            new Anime(2, "Berserk"),
            new Anime(3, "Naruto"));
    }
}
