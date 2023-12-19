package dto;


import entity.Tree;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TreeOverViewDTO {
    private Long treeId;
    private List<Boolean> ornamentOverViewList;

    public void setOrnamentIdList(Tree tree) {
        this.ornamentOverViewList = new ArrayList<>();
        for (int i = 0; i < tree.getOrnamentList().size(); i++) {
            if (tree.getOrnamentList().get(i) != null) {
                this.ornamentOverViewList.add(true);
            } else {
                this.ornamentOverViewList.add(false);
            }
        }
    }
}
