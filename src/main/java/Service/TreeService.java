package Service;

<<<<<<< HEAD
import Entity.Tree;
=======
>>>>>>> 3e04d06 (Feat: new Tree)
import Repository.TreeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TreeService {
    private final TreeRepository treeRepository;

<<<<<<< HEAD
    public void createNewTree(){
        treeRepository.save(new Tree());
    }

=======
>>>>>>> 3e04d06 (Feat: new Tree)
}
