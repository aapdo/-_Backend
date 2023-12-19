package org.example.bliss_be.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bliss_be.entity.Tree;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Setter
public class TreeDetailDTO {
    private Long treeId;
    private List<Long> ornamentIdList;


    public void setOrnamentIdList(Tree tree) {
        this.ornamentIdList = new ArrayList<>();
        for (int i = 0; i < tree.getOrnamentList().size(); i++) {
            if (tree.getOrnamentList().get(i) != null) {
                this.ornamentIdList.add(tree.getOrnamentList().get(i).getId());
            } else {
                this.ornamentIdList.add(null);
            }
        }
    }
}
