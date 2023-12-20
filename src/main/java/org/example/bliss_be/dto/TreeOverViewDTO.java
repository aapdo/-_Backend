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
        List<Boolean> tempOverViewList = new ArrayList<>();

        List<Ornament> ornamentList = tree.getOrnamentList();
        System.out.println("test");

        for (Ornament o : ornamentList) {
            if (o.getIsGoodMemory() == null) {
                tempOverViewList.add(false);
                log.info("ornament is not null");
            } else {
                tempOverViewList.add(true);
                log.info("ornament is null");
            }

        }

        this.ornamentOverViewList = tempOverViewList;
    }
    /*

    public void setOrnamentIdList(Tree tree) {
        this.ornamentOverViewList = new ArrayList<>();
        Ornament ornament = Ornament.builder()
                .id(null)
                .isGoodMemory(null)
                .memory(null)
                .tree(null).build();
        List<Ornament> ornamentList = tree.getOrnamentList();
        log.info("ornamentList.size() = {}", ornamentList.size());
        for (int i = 0; i < 13; i++) {
            log.info("ornament0 = {}" , ornamentList.get(i));

            if (ornamentList.get(i).getId() == null ) {
                this.ornamentOverViewList.add(false);
                log.info("ornament is not null");
            } else {
                this.ornamentOverViewList.add(true);
                log.info("ornament is null");
            }
        }
    }

     */
}
