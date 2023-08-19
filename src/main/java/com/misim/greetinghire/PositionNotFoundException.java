package com.misim.greetinghire;

class PositionNotFoundException extends RuntimeException{

    PositionNotFoundException(Long id) {
        super("Could not find position " + id);
    }
}
