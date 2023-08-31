package com.misim.greetinghire.web;

import com.misim.greetinghire.domain.position.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Controller
@AllArgsConstructor
public class WebController {

    private PositionRepository positionRepository;

    @GetMapping("/positions")
    public String all() {
        return "main";
    }

    @GetMapping("/positions/{id}")
    public String one() {
        return "one";
    }
}
