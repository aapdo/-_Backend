package dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Builder
public class ResponseMemberDTO {
    String name;
    Double treeId;
}
