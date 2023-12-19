package service;


import entity.Tree;
import repository.TreeRepository;
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
