package com.misim.greetinghire;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class PositionController {
    private final PositionRepository repository;

    private final PositionModelAssembler assembler;

    PositionController(PositionRepository repository, PositionModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/positions")
    CollectionModel<EntityModel<Position>> all() {
        List<EntityModel<Position>> positions = repository.findAll().stream()
                .map(position -> EntityModel.of(position,
                        linkTo(methodOn(PositionController.class).one(position.getId())).withSelfRel(),
                        linkTo(methodOn(PositionController.class).all()).withRel("positions")))
                .collect(Collectors.toList());
        return CollectionModel.of(positions, linkTo(methodOn(PositionController.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/positions")
    ResponseEntity<?> newPosition(@RequestBody Position newPosition) {

        EntityModel<Position> entityModel = assembler.toModel(repository.save(newPosition));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    // Single item

    @GetMapping("/positions/{id}")
    EntityModel<Position> one(@PathVariable Long id) {

        Position position = repository.findById(id)
                .orElseThrow(() -> new PositionNotFoundException(id));

        return EntityModel.of(position,
                linkTo(methodOn(PositionController.class).one(id)).withSelfRel(),
                linkTo(methodOn(PositionController.class).all()).withRel("positions"));
    }

    @PutMapping("/positions/{id}")
    ResponseEntity<?> replacePosition(@RequestBody Position newPosition, @PathVariable Long id) {

        Position updatePosition = repository.findById(id)
                .map(position -> {
                    position.setCompany(newPosition.getCompany());
                    position.setName(newPosition.getName());
                    position.setExperience(newPosition.getExperience());
                    position.setType(newPosition.getType());
                    position.setDeadline(newPosition.getDeadline());
                    position.setUrl(newPosition.getUrl());
                    return repository.save(position);
                })
                .orElseGet(() -> {
                    newPosition.setId(id);
                    return repository.save(newPosition);
                });

        EntityModel<Position> entityModel = assembler.toModel(updatePosition);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/positions/{id}")
    ResponseEntity<?> deletePosition(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
