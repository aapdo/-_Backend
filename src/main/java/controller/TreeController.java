package controller;


import dto.ResponseDTO;
import dto.TreeDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import service.TreeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
@RequiredArgsConstructor
public class TreeController {
    private final TreeService treeService;

    @GetMapping("/tree/getdetail/{treeId}")
    public ResponseEntity<ResponseDTO<TreeDetailDTO>> getTreeDetail(@PathVariable Long treeId) {
        TreeDetailDTO treeDetailDTO = new TreeDetailDTO();
        treeDetailDTO.setTreeId(treeId);
        String msg = treeService.getTreeDetail(treeDetailDTO);
        ResponseDTO<TreeDetailDTO> response = ResponseDTO.<TreeDetailDTO>builder()
                .message(msg).data(treeDetailDTO).build();
        return ResponseEntity.ok().body(response);
    }


}
