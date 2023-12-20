package org.example.bliss_be.service;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.example.bliss_be.dto.MemberDTO;
import org.example.bliss_be.entity.MemberEntity;
import org.example.bliss_be.entity.Ornament;
import org.example.bliss_be.entity.Tree;
import org.example.bliss_be.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.example.bliss_be.repository.TreeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private final TreeRepository treeRepository;

    @Transactional
    public String join(MemberDTO memberDTO){
        String message;
        if (memberRepository.findByName(memberDTO.getName()).isPresent()){
            message = "이미 존재하는 아이디입니다.";
        }else {
            List<Ornament> tmp = new ArrayList<>(13);


            Tree treeEntity = Tree.builder()
                    .isAccessable(false)
                    .NumBadMemory(0)
                    .NumGoodMemory(0)
                    .ornamentList(tmp)
                    .build();
            Tree savedTree = treeRepository.save(treeEntity);

            for (int i = 0; i < 13; i++) {
                Ornament ornament = Ornament.builder()
                        .isGoodMemory(null)
                        .memory(null)
                        .tree(treeEntity).build();
                tmp.add(ornament);
                log.info("new ornament = {}", ornament);
            }
            log.info("result : {}", savedTree.getOrnamentList().get(10));
            MemberEntity memberEntity = MemberEntity.builder()
                    .name(memberDTO.getName())
                    .password(memberDTO.getPassword())
                    .email(memberDTO.getEmail())
                    .tree(treeEntity)
                    .build();
            memberRepository.save(memberEntity);
            message = "회원가입에 성공하였습니다.";
        }
        return message;
    }
    public String login(MemberDTO memberDTO){
        String message;
        Optional<MemberEntity> member= memberRepository.findByName(memberDTO.getName());
        if (member.isPresent() && member.get().getPassword().equals(memberDTO.getPassword())){
            memberDTO.setTreeId(member.get().getTree().getId());
            message = "로그인에 성공하였습니다.";
        }else {
            message = "아이디 또는 비밀번호가 틀렸습니다.";
        }
        return message;
    }
}
