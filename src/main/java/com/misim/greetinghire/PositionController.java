package com.misim.greetinghire;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class PositionController {
    private final PositionRepository repository;

    PositionController(PositionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/positions")
    List<Position> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/positions")
    Position newPosition(@RequestBody Position newPosition) {
        return repository.save(newPosition);
    }

    // Single item

    @GetMapping("/positions/{id}")
    Position one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PositionNotFoundException(id));
    }

    @PutMapping("/positions/{id}")
    Position replacePosition(@RequestBody Position newPosition, @PathVariable Long id) {

        return repository.findById(id)
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
    }

    @DeleteMapping("/positions/{id}")
    void deletePosition(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
