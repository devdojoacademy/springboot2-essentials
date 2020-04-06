package academy.devdojo.springboot2.client;

import academy.devdojo.springboot2.domain.Anime;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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

        log.info("Anime {} ", anime);

        Anime[] animeArray = new RestTemplate()
            .getForObject("http://localhost:8080/animes", Anime[].class);

        log.info("Anime Array {} ", Arrays.toString(animeArray));
        //@formatter:off
        ResponseEntity<List<Anime>> exchangeAnimeList = new RestTemplate()
            .exchange("http://localhost:8080/animes", HttpMethod.GET, null, new ParameterizedTypeReference<List<Anime>>() {});
        //@formatter:on

        log.info("Anime list {} ", exchangeAnimeList.getBody());

    }

}
