package org.example.bliss_be.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResponseMemberDTO {
    String name;
    Double treeId;
}
