package nl.raymond.airlinexyz.airlinexyz.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Airport extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "airport")
    private Set<Fleet> fleet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
