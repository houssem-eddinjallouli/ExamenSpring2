package tn.esprit.ExamenSpring.entite;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
//@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Getter
@Setter
public class Washing_Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idService;
    private float prixce;
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany(mappedBy="washing_services", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    public enum Type{ExternalWaching,INTERNALWaching,POLISHING}
}
