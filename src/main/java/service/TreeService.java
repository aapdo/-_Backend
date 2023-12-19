package service;


import dto.TreeDetailDTO;
import dto.TreeOverViewDTO;
import entity.Tree;
import repository.TreeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TreeService {
    private final TreeRepository treeRepository;


    public String getTreeDetail(TreeDetailDTO treeDetailDTO){
        String returnMsg = "";
        Optional<Tree> optionalTree = treeRepository.findById(treeDetailDTO.getTreeId());
        if (optionalTree.isPresent()) {
            treeDetailDTO.setOrnamentIdList(optionalTree.get());
            returnMsg = "트리 조회에 성공하였습니다.";
        } else {
            returnMsg = "존재하지 않는 트리입니다.";
        }

        return returnMsg;
    }
    public String getTreeOverView(TreeOverViewDTO treeOverViewDTO){
        String returnMsg = "";
        Optional<Tree> optionalTree = treeRepository.findById(treeOverViewDTO.getTreeId());
        if (optionalTree.isPresent()) {
            treeOverViewDTO.setOrnamentIdList(optionalTree.get());
            returnMsg = "트리 조회에 성공하였습니다.";
        } else {
            returnMsg = "존재하지 않는 트리입니다.";
        }

        return returnMsg;
    }
}
