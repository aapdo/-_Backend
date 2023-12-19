package org.example.bliss_be.controller;

import lombok.RequiredArgsConstructor;
import org.example.bliss_be.dto.OrnamentDTO;
import org.example.bliss_be.dto.ResponseDTO;
import org.example.bliss_be.service.OrnamentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrnamentController {
    private final OrnamentService ornamentService;

    @GetMapping("/ornament/{ornamentId}")
    public ResponseEntity<ResponseDTO<OrnamentDTO>> getOrnament(@PathVariable Long ornamentId) {
        OrnamentDTO ornamentDTO = new OrnamentDTO();
        ornamentDTO.setOrnamentId(ornamentId);
        String msg = ornamentService.getOrnamentData(ornamentDTO);
        ResponseDTO<OrnamentDTO> response = ResponseDTO.<OrnamentDTO>builder()
                .message(msg)
                .data(ornamentDTO).
                build();
        return ResponseEntity.ok(response);
    }
}
