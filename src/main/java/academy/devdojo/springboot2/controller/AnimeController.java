package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.util.DateUtil;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("anime")
@Slf4j
@RequiredArgsConstructor
public class AnimeController {

    private final DateUtil dateUtil;

    @GetMapping(path = "/list")
    public List<Anime> listAll() {
        log.info("Date Formatted {}", dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return Arrays.asList(
            new Anime("Boku No Hero"),
            new Anime("Berserk"),
            new Anime("Naruto"));
    }
}
