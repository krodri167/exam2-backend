package ec.edu.insteclrg.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tusername")
public class Username {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String password;

}

