package org.example.bliss_be.service;


import org.example.bliss_be.entity.Tree;
import org.example.bliss_be.repository.TreeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TreeService {
    private final TreeRepository treeRepository;


    public void createNewTree(){
        treeRepository.save(new Tree());
    }

}
