package dto;

import org.example.bliss_be.entity.Tree;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
            this.ornamentIdList.add(tree.getOrnamentList().get(i).getId());
        }
    }

    public TreeDetailDTO(Tree tree) {
        this.treeId = tree.getId();
        this.ornamentIdList = new ArrayList<>();
        for (int i = 0; i < tree.getOrnamentList().size(); i++) {
            this.ornamentIdList.add(tree.getOrnamentList().get(i).getId());
        }
    }
}
