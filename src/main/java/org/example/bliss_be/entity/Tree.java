package org.example.bliss_be.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor @Builder
@Getter
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isAccessable;
    private Integer NumBadMemory;
    private Integer NumGoodMemory;

    @JsonIgnore
    @OneToMany(mappedBy = "tree")
    private List<Ornament> ornamentList;

}
