package Service;

import Repository.TreeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TreeService {
    private final TreeRepository treeRepository;

}
