package org.example.bliss_be.service;

import lombok.RequiredArgsConstructor;
import org.example.bliss_be.dto.OrnamentDTO;
import org.example.bliss_be.entity.Ornament;
import org.example.bliss_be.repository.OrnamentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrnamentService {
    private final OrnamentRepository ornamentRepository;

    public String getOrnamentData(OrnamentDTO ornamentDTO) {
        String msg = "";
        Optional<Ornament> optionOrnament = ornamentRepository.findById(ornamentDTO.getOrnamentId());
        // 존재하는 경우
        if (optionOrnament.isPresent()) {
            msg = "오너먼트 조회에 성공하였습니다.";
            Ornament ornament = optionOrnament.get();
            ornamentDTO.setMemory(ornament.getMemory());
            ornamentDTO.setIsGoodMemory(ornament.getIsGoodMemory());
        } else {
            msg = "존재하지 않는 오너먼트입니다.";
        }

        return msg;
    }
}
