package Entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor @Builder
public class Member {
    @Id
    String member_id;
    String name;
    String password;
    String email;
}
