package com.misim.greetinghire.web;

import com.misim.greetinghire.domain.position.PositionRepository;
import com.misim.greetinghire.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Controller
@AllArgsConstructor
public class WebController {

    private PositionService positionService;

    @GetMapping("/positions")
    public String main(Model model) {
        model.addAttribute("position", positionService.findAllDesc());
        return "main";
    }

}
