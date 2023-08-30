package com.misim.greetinghire.web;

import com.misim.greetinghire.PositionNotFoundException;
import com.misim.greetinghire.domain.position.Position;
import com.misim.greetinghire.domain.position.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PositionRepository positionRepository;

    @GetMapping("/positions")
    public String all() {
        return "/main.html";
    }

    @GetMapping("/positions/{id}")
    public String one() {
        return "one";
    }
}
