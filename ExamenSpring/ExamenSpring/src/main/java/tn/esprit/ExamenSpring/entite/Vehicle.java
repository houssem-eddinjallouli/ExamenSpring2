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
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVehicle;
    private String brand;
    private String immatriculation;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> Reservations;

}
