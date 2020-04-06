package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.util.Utils;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class AnimeService {

    private final Utils utils;
    private final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findById(int id) {
        return utils.findAnimeOrThrowNotFound(id, animeRepository);
    }

    @Transactional
    public Anime save(Anime anime){
        return animeRepository.save(anime);
    }

    public void delete(int id) {
        animeRepository.delete(utils.findAnimeOrThrowNotFound(id, animeRepository));
    }

    public void update(Anime anime) {
        animeRepository.save(anime);
    }
}
