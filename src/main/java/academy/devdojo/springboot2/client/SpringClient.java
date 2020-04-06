package academy.devdojo.springboot2.client;

import academy.devdojo.springboot2.domain.Anime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class SpringClient {

    public static void main(String[] args) {
        ResponseEntity<Anime> animeResponseEntity = new RestTemplate()
            .getForEntity("http://localhost:8080/animes/{id}", Anime.class, 2);

        log.info("Response Entity {}", animeResponseEntity);

        log.info("Response Data {}", animeResponseEntity.getBody());

        Anime anime = new RestTemplate()
            .getForObject("http://localhost:8080/animes/{id}", Anime.class, 2);

        log.info("Anime {} ",anime);
    }

}
