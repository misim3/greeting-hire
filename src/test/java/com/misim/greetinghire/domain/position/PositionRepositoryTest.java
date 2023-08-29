package com.misim.greetinghire.domain.position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class PositionRepositoryTest {

    @Autowired
    PositionRepository positionRepository;

    @After("")
    public void cleanup() {
        positionRepository.deleteAll();
    }

    @Test
    public void loadPosition() {
        //given
        positionRepository.save(Position.builder()
                .company("가나다")
                .name("마바사")
                .experience("5년이상")
                .type("정규직")
                .url("https://example.com")
                .build());

        //when
        List<Position> positionList = positionRepository.findAll();

        //then
        Position position = positionList.get(0);
        assertEquals(position.getCompany(), "가나다");
        assertEquals(position.getName(), "마바사");
        assertEquals(position.getExperience(), "5년이상");
        assertEquals(position.getType(), "정규직");
        assertEquals(position.getUrl(), "https://example.com");
    }

    @Test
    public void checkBaseTimeEntity() {
        //given
        LocalDateTime now = LocalDateTime.now();
        positionRepository.save(Position.builder()
                .company("가나다")
                .name("마바사")
                .experience("5년이상")
                .type("정규직")
                .url("https://example.com")
                .build());
        //when
        List<Position> positionList = positionRepository.findAll();

        //then
        Position position = positionList.get(0);
        assertTrue(position.getCreatedDate().isAfter(now));
        assertTrue(position.getModifiedDate().isAfter(now));
    }
}
