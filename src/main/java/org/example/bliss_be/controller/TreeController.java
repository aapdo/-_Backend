package org.example.bliss_be.controller;


import org.example.bliss_be.dto.TreeDetailDto;
import org.example.bliss_be.service.TreeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class TreeController {
    private final TreeService treeService;


    @GetMapping("/testNull")
    public Integer test(@RequestBody List<Integer> list) {
        treeService.createNewTree();
        return list.get(0);
    }

    @GetMapping("/tree/getdetail/{treeId}")
    public TreeDetailDto getTreeDetail(@PathVariable Long treeId) {
        TreeDetailDto treeDetailDto = null;
        return  treeDetailDto;
    }


}
