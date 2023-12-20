package org.example.bliss_be.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor @Builder
public class OrnamentDTO {
    private Long treeId;
    private Long ornamentId;
    private Boolean isGoodMemory;
    private String memory;

    public OrnamentDTO(Boolean isGoodMemory, String memory) {
        this.isGoodMemory = isGoodMemory;
        this.memory = memory;
    }
}
