package Controller;

<<<<<<< HEAD
import Dto.TreeDetailDto;
import Service.TreeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

=======
import Service.TreeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

>>>>>>> 3e04d06 (Feat: new Tree)
@RestController
@AllArgsConstructor
public class TreeController {
    private final TreeService treeService;

<<<<<<< HEAD
    @GetMapping("/testNull")
    public Integer test(@RequestBody List<Integer> list) {
        treeService.createNewTree();
        return list.get(0);
    }

    @GetMapping("/tree/getdetail/{treeId}")
    public TreeDetailDto getTreeDetail(@PathVariable Long treeId) {
        return
    }

=======
>>>>>>> 3e04d06 (Feat: new Tree)
}
