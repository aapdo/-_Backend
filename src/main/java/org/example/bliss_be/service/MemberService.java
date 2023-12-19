package org.example.bliss_be.service;

import org.example.bliss_be.dto.MemberDTO;
import org.example.bliss_be.entity.MemberEntity;
import org.example.bliss_be.entity.Tree;
import org.example.bliss_be.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.example.bliss_be.repository.TreeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final TreeRepository treeRepository;
    public String join(MemberDTO memberDTO){
        String message;
        if (memberRepository.findByName(memberDTO.getName()).isPresent()){
            message = "이미 존재하는 아이디입니다.";

        }else {
            Tree treeEntity = Tree.builder()
                    .isAccessable(false)
                    .NumBadMemory(0)
                    .NumGoodMemory(0)
                    .ornamentList(new ArrayList<>())
                    .build();
            treeRepository.save(treeEntity);
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
            message = "로그인에 성공하였습니다.";
        }else {
            message = "아이디 또는 비밀번호가 틀렸습니다.";
        }
        return message;
    }
}
