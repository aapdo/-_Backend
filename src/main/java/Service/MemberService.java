package service;

import dto.MemberDTO;
import entity.MemberEntity;
import repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public String join(MemberDTO memberDTO){
        String message;
        if (memberRepository.findById(memberDTO.getName()).isPresent()){
            message = "이미 존재하는 아이디입니다.";

        }else {
            MemberEntity memberEntity = MemberEntity.builder()
                    .name(memberDTO.getName())
                    .password(memberDTO.getPassword())
                    .email(memberDTO.getEmail())
                    .build();
            memberRepository.save(memberEntity);
            message = "회원가입에 성공하였습니다.";
        }
        return message;
    }
    public String login(MemberDTO memberDTO){
        String message;
        Optional<MemberEntity> member= memberRepository.findById(memberDTO.getName());
        if (member.isPresent() && member.get().getPassword().equals(memberDTO.getPassword())){
            message = "로그인에 성공하였습니다.";
        }else {
            message = "아이디 또는 비밀번호가 틀렸습니다.";
        }
        return message;
    }
}
