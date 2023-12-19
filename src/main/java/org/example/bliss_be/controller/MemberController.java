package org.example.bliss_be.controller;

import org.example.bliss_be.dto.MemberDTO;
import org.example.bliss_be.dto.ResponseDTO;
import org.example.bliss_be.dto.ResponseMemberDTO;
import lombok.RequiredArgsConstructor;
import org.example.bliss_be.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "/signup")
    public ResponseEntity<ResponseDTO<ResponseMemberDTO>> join(@RequestBody MemberDTO memberDTO) {
        String message = memberService.join(memberDTO);
        ResponseMemberDTO responseMemberDTO = ResponseMemberDTO.builder()
                .name(memberDTO.getName())
                .build();
        ResponseDTO<ResponseMemberDTO> response = ResponseDTO.<ResponseMemberDTO>builder()
                .message(message)
                .data(responseMemberDTO)
                .build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<ResponseMemberDTO>> login(@RequestBody MemberDTO memberDTO) {
        String message = memberService.login(memberDTO);
        ResponseMemberDTO responseMemberDTO = ResponseMemberDTO.builder()
                .name(memberDTO.getName())
//                .treeId(memberDTO.getTreeId)
                .build();
        ResponseDTO<ResponseMemberDTO> response = ResponseDTO.<ResponseMemberDTO>builder()
                .message(message)
                .data(responseMemberDTO)
                .build();
        return ResponseEntity.ok().body(response);
    }

}