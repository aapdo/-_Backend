package org.example.bliss_be.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.bliss_be.dto.OrnamentDTO;
import org.example.bliss_be.dto.ResponseOrnermentDTO;
import org.example.bliss_be.entity.Ornament;
import org.example.bliss_be.entity.Tree;
import org.example.bliss_be.repository.OrnamentRepository;
import org.example.bliss_be.repository.TreeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrnamentService {
    private final OrnamentRepository ornamentRepository;
    private final TreeRepository treeRepository;
    public List<ResponseOrnermentDTO> getOrnamentList(Long treeId){
        List<Ornament> ornamentList = ornamentRepository.findAllByTreeId(treeId);
        List<ResponseOrnermentDTO> ornamentDTOList = new ArrayList<>();
        for (Ornament o : ornamentList){
            ResponseOrnermentDTO ornamentDTO = ResponseOrnermentDTO.builder()
                    .ornamentId(o.getId())
                    .isGoodMemory(o.getIsGoodMemory())
                    .memory(o.getMemory())
                    .build();
            ornamentDTOList.add(ornamentDTO);
        }
        return  ornamentDTOList;
    }
    public Integer addOrnament(OrnamentDTO ornamentDTO){
        Boolean edited = false;
        int listIndex = -1;
        // 1, 3, 5, 10 ,15
        Optional<Tree> myTree = treeRepository.findById(ornamentDTO.getTreeId());
        Tree tree;
        List<Ornament> getOrnermentList;
        if(myTree.isPresent()){
            tree = myTree.get();

            int badNum = tree.getNumBadMemory();
            int goodNum = tree.getNumGoodMemory();
            log.info("goodNum = {}, badNum = {}", goodNum, badNum);

            //좋은 기억이면
            if(ornamentDTO.getIsGoodMemory()){
                goodNum++;
                edited = true;
            }else {
                badNum++;
                if (badNum == 1 || badNum == 3 || badNum == 5 || badNum == 10 || badNum == 15) {
                    edited = true;
                    System.out.println("특별 오너먼트 만들어졌어요");
                } else {
                    System.out.println("나쁜기억을 더 만들어오세요");
                }
            }
            tree.setNumGoodMemory(goodNum);
            tree.setNumBadMemory(badNum);


            if(!edited){
                System.out.println("추가된 오너먼트가 없어요");
                log.info("cur tree = {}", tree);
                Tree newTree = treeRepository.save(tree);
                log.info("new tree = {}", newTree);
            }else {
                Ornament ornament = Ornament.builder()
                        .isGoodMemory(ornamentDTO.getIsGoodMemory())
                        .memory(ornamentDTO.getMemory())
                        .tree(tree)
                        .build();

                ornamentRepository.save(ornament);
                System.out.println("기본 오너먼트가 만들어졌어요");

                getOrnermentList = tree.getOrnamentList();

                listIndex = getOrnermentList.indexOf(ornament);
                log.info("list index = {}", listIndex);
            }
        }else {
            System.out.println("트리를 조회할 수 없어요");
        }
        return listIndex;
    }
    public String getOrnamentData(OrnamentDTO ornamentDTO) {
        String msg = "";
        Optional<Ornament> optionOrnament = ornamentRepository.findById(ornamentDTO.getOrnamentId());
        // 존재하는 경우
        if (optionOrnament.isPresent()) {
            msg = "오너먼트 조회에 성공하였습니다.";
            Ornament ornament = optionOrnament.get();
            ornamentDTO.setMemory(ornament.getMemory());
            ornamentDTO.setIsGoodMemory(ornament.getIsGoodMemory());
        } else {
            msg = "존재하지 않는 오너먼트입니다.";
        }

        return msg;
    }
}
