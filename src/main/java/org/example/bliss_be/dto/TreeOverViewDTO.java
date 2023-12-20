package dto;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.bliss_be.entity.Tree;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Slf4j
public class TreeOverViewDTO {
    private Long treeId;
    private List<Boolean> ornamentOverViewList;

    public void setOrnamentIdList(Tree tree) {
        this.ornamentOverViewList = new ArrayList<>();
        for (int i = 0; i < tree.getOrnamentList().size(); i++) {
            if (tree.getOrnamentList().get(i) != null) {
                this.ornamentOverViewList.add(true);
                log.info("ornament is not null");
            } else {
                this.ornamentOverViewList.add(false);
                log.info("ornament is null");
            }
        }
    }
}
