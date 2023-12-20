package org.example.bliss_be.controller;

import lombok.RequiredArgsConstructor;
import org.example.bliss_be.dto.ResponseDTO;
import org.example.bliss_be.service.TreeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DummyController {
    private final TreeService treeService;

    @GetMapping("/tree/overview/dummy")
    public ResponseEntity<ResponseDTO<dto.TreeOverViewDTO>> test(){
        dto.TreeOverViewDTO treeOverViewDTO = new dto.TreeOverViewDTO();
        treeOverViewDTO.setTreeId(1L);
        String msg = treeService.getTreeOverView(treeOverViewDTO);
        List<Boolean> dummyData = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            dummyData.add( (i % 2 == 0) );
        }
        ResponseDTO<dto.TreeOverViewDTO> response = ResponseDTO.<dto.TreeOverViewDTO>builder()
                .message(msg).data(treeOverViewDTO).build();
        return ResponseEntity.ok().body(response);
    }
}
