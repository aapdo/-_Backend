package org.example.bliss_be.controller;

import lombok.RequiredArgsConstructor;
import org.example.bliss_be.dto.ResponseDTO;
import org.example.bliss_be.entity.Ornament;
import org.example.bliss_be.entity.Tree;
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
        String msg = "test!";
        Tree dummyTree = new Tree();
        List<Ornament> dummyData = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            if (i % 2 == 0) {
                dummyData.add(null);
            } else {
                dummyData.add(new Ornament());
            }
        }
        dummyTree.setOrnamentList(dummyData);
        treeOverViewDTO.setOrnamentIdList(dummyTree);

        ResponseDTO<dto.TreeOverViewDTO> response = ResponseDTO.<dto.TreeOverViewDTO>builder()
                .message(msg).data(treeOverViewDTO).build();
        return ResponseEntity.ok().body(response);
    }
}
