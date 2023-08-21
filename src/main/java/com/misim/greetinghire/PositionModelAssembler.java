package com.misim.greetinghire;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
class PositionModelAssembler implements RepresentationModelAssembler<Position, EntityModel<Position>> {

    @Override
    public EntityModel<Position> toModel(Position position) {

        return EntityModel.of(position,
                linkTo(methodOn(PositionController.class).one(position.getId())).withSelfRel(),
                linkTo(methodOn(PositionController.class).all()).withRel("positions"));
    }
}
