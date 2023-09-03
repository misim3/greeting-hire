package com.misim.greetinghire.dto.position;

import com.misim.greetinghire.domain.position.Position;
import lombok.Getter;

@Getter
public class PositionMainResponseDto {
    private Long id;
    private String company;
    private String name;
    private String experience;
    private String type;

    public PositionMainResponseDto(Position entity) {
        id = entity.getId();
        company = entity.getCompany();
        name = entity.getName();
        experience = entity.getExperience();
        type = entity.getType();
    }

}
