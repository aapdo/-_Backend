package Entity;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

>>>>>>> 3e04d06 (Feat: new Tree)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isAccessable;
    private Integer NumBadMemory;
    private Integer NumGoodMemory;
<<<<<<< HEAD

    @OneToMany

    private List<Ornament> ornamentList;
=======
>>>>>>> 3e04d06 (Feat: new Tree)
}
