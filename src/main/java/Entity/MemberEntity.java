package entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor @Builder
@Table(name = "member")
public class MemberEntity {
    @Id
    private String memberId;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String email;
}
