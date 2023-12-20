package org.example.bliss_be.controller;

import lombok.RequiredArgsConstructor;
import org.example.bliss_be.dto.OrnamentDTO;
import org.example.bliss_be.dto.ResponseDTO;
import org.example.bliss_be.dto.ResponseOrnermentDTO;
import org.example.bliss_be.entity.Ornament;
import org.example.bliss_be.service.OrnamentService;
import org.example.bliss_be.service.TreeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ornament")
public class OrnamentController {
    private final OrnamentService ornamentService;

    @GetMapping("/{ornamentId}")
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

    @GetMapping("/getlist/{treeId}")
    public ResponseEntity<ResponseDTO<List<ResponseOrnermentDTO>>> getOrnamentList(@PathVariable Long treeId){
        String message;
        List<ResponseOrnermentDTO> ornamentList = ornamentService.getOrnamentList(treeId);
        if(ornamentList.isEmpty()){
            message = "오너먼트가 하나도 없어요...";
        }else {
            message = "오너먼트 조회에 성공하였습니다.";
        }
        ResponseDTO<List<ResponseOrnermentDTO>> response = ResponseDTO.<List<ResponseOrnermentDTO>>builder()
                .message(message)
                .data(ornamentList)
                .build();
        return ResponseEntity.ok().body(response);
    }
}
