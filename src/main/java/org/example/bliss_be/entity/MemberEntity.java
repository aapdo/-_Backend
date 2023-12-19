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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String email;
}
