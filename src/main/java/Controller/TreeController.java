package Controller;

import Service.TreeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TreeController {
    private final TreeService treeService;

}
