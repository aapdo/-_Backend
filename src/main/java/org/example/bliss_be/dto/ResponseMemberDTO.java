package org.example.bliss_be.dto;

import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor @Builder
public class ResponseMemberDTO {

    String name;
    Long treeId;
}
