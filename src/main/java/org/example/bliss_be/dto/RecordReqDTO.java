package org.example.bliss_be.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecordReqDTO {
    private Long treeId;
    // GOOD or BAD
    private String memoType;
    private String memo;
}
