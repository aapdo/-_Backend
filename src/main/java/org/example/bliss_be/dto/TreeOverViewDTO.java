package dto;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.bliss_be.entity.Ornament;
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
        Ornament ornament = Ornament.builder()
                .id(null)
                .isGoodMemory(null)
                .memory(null)
                .tree(null).build();

        for (int i = 0; i < tree.getOrnamentList().size(); i++) {
            log.info("ornament0 = {}" , tree.getOrnamentList().get(0));
            if (tree.getOrnamentList().get(i).equals(ornament)) {
                this.ornamentOverViewList.add(false);
                log.info("ornament is not null");
            } else {
                this.ornamentOverViewList.add(true);
                log.info("ornament is null");
            }
        }
    }
}
