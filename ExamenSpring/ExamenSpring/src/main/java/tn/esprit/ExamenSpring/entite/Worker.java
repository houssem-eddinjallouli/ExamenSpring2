package tn.esprit.ExamenSpring.entite;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAggent;
    private String name;
    private String nic;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="worker")
    private Set<Reservation> Reservations;
}
