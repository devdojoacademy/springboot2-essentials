package academy.devdojo.springboot2.client;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.wrapper.PageableResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class SpringClient {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("academy"));
//        testGetWithRestTemplate();

        //@formatter:off
        ResponseEntity<PageableResponse<Anime>> exchangeAnimeList = new RestTemplate()
            .exchange("http://localhost:8080/animes?sort=name,desc", HttpMethod.GET, null, new ParameterizedTypeReference<PageableResponse<Anime>>() {});
        //@formatter:on

        log.info("Anime list {} ", exchangeAnimeList.getBody());

        Anime overlord = Anime.builder().name("Overlord").build();
//        Anime overlordSaved = new RestTemplate().postForObject("http://localhost:8080/animes", overlord, Anime.class);
//
//        log.info("Overlord saved id: {} ", overlordSaved.getId());

        Anime steinsGate = Anime.builder().name("Steins Gate").build();

        Anime steinsGateSaved = new RestTemplate()
            .exchange("http://localhost:8080/animes", HttpMethod.POST, new HttpEntity<>(steinsGate, createJsonHeader()),
                Anime.class)
            .getBody();

        log.info("Steins Gate saved id: {} ", steinsGateSaved.getId());

        steinsGateSaved.setName("Steins Gate Zero");

        ResponseEntity<Void> exchangeUpdated = new RestTemplate()
            .exchange("http://localhost:8080/animes", HttpMethod.PUT,
                new HttpEntity<>(steinsGateSaved, createJsonHeader()), Void.class);

        log.info("Steins Gate updated status: {} ", exchangeUpdated.getStatusCode());

        ResponseEntity<Void> exchangeDeleted = new RestTemplate()
            .exchange("http://localhost:8080/animes/{id}", HttpMethod.DELETE,
                null, Void.class, steinsGateSaved.getId());

        log.info("Steins Gate deleted status: {} ", exchangeDeleted.getStatusCode());

    }

    private static HttpHeaders createJsonHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    private static void testGetWithRestTemplate() {
        ResponseEntity<Anime> animeResponseEntity = new RestTemplate()
            .getForEntity("http://localhost:8080/animes/{id}", Anime.class, 2);

        log.info("Response Entity {}", animeResponseEntity);

        log.info("Response Data {}", animeResponseEntity.getBody());

        Anime anime = new RestTemplate()
            .getForObject("http://localhost:8080/animes/{id}", Anime.class, 2);

        log.info("Anime {} ", anime);
    }

}
