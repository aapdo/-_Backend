package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ornament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
