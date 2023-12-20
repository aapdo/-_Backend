package org.example.bliss_be.controller;

import org.example.bliss_be.dto.*;
import dto.TreeOverViewDTO;
import lombok.RequiredArgsConstructor;
import org.example.bliss_be.entity.Tree;
import org.example.bliss_be.service.OrnamentService;
import org.springframework.http.ResponseEntity;
import org.example.bliss_be.service.TreeService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class TreeController {
    private final TreeService treeService;
    private final OrnamentService ornamentService;

    @GetMapping("/tree/getdetail/{treeId}")
    public ResponseEntity<ResponseDTO<TreeDetailDTO>> getTreeDetail(@PathVariable Long treeId) {
        TreeDetailDTO treeDetailDTO = new TreeDetailDTO();
        treeDetailDTO.setTreeId(treeId);
        String msg = treeService.getTreeDetail(treeDetailDTO);
        ResponseDTO<TreeDetailDTO> response = ResponseDTO.<TreeDetailDTO>builder()
                .message(msg).data(treeDetailDTO).build();
        return ResponseEntity.ok().body(response);

    }
    @GetMapping("/tree/overview/{treeId}")
    public ResponseEntity<ResponseDTO<TreeOverViewDTO>> getTreeOverView(@PathVariable Long treeId) {
        TreeOverViewDTO treeOverViewDTO = new TreeOverViewDTO();
        treeOverViewDTO.setTreeId(treeId);
        String msg = treeService.getTreeOverView(treeOverViewDTO);
        ResponseDTO<TreeOverViewDTO> response = ResponseDTO.<TreeOverViewDTO>builder()
                .message(msg).data(treeOverViewDTO).build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/tree/memo")
    public ResponseEntity<ResponseDTO<Long>> getRecord(@RequestBody RecordReqDTO recordReqDTO) {
        // 좋은 기억을 입력하면 오너먼트 준다.
        // 나쁜 기억 1, 3, 5, 10, 15
        Long treeId = recordReqDTO.getTreeId();

        String msg = "기록에 실패하였습니다.";
        OrnamentDTO ornamentDTO ;
        if (recordReqDTO.getMemoType().equals("GOOD")) {
            ornamentDTO = new OrnamentDTO(true, recordReqDTO.getMemo());
        } else {
            ornamentDTO = new OrnamentDTO(false, recordReqDTO.getMemo());
        }
        ornamentDTO.setTreeId(treeId);
        ornamentService.addOrnament(ornamentDTO);

        // 장식 생성이 되지 않은 경우
        if (ornamentDTO.getOrnamentId() != null) {
            msg = "기록되었습니다.";
        }

        ResponseDTO<Long> response = ResponseDTO.<Long>builder()
                .message(msg)
                .data(ornamentDTO.getOrnamentId())
                .build();

        return ResponseEntity.ok().body(response);
    }
}
