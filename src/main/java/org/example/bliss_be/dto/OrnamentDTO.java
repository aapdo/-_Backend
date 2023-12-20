package org.example.bliss_be.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
