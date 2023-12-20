package org.example.bliss_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private Boolean isGoodMemory;
    private String memory;

    @ManyToOne
    @JoinColumn(name = "tree_Id")
    private Tree tree;
}
