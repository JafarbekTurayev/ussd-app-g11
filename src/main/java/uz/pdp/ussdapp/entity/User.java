package uz.pdp.ussdapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.ussdapp.entity.enums.UserType;

import javax.persistence.*;
import java.util.*;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String userName;//
    @Column(nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    private List<SimCard> simCardList;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    private boolean enabled;
    private boolean accountNonLocked = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;

    public User(String fullName, String userName, String password, Role role, boolean enabled) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

}
