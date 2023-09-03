package com.misim.greetinghire.service;

import com.misim.greetinghire.domain.position.PositionRepository;
import com.misim.greetinghire.dto.position.PositionMainResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PositionService {
    private PositionRepository positionRepository;

    @Transactional(readOnly = true)
    public List<PositionMainResponseDto> findAllDesc() {
        return positionRepository.findAllDesc()
                .map(PositionMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
