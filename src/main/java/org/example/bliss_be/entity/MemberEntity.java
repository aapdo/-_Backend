package org.example.bliss_be.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor @Builder
@Table(name = "member")
public class MemberEntity {
    @Id
    private String name;
    @Column
    private String password;
    @Column
    private String email;

    @OneToOne
    @JoinColumn (name = "tree_id")
    private Tree tree;
}
