package tn.esprit.ExamenSpring.entite;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReservation;
    private LocalDateTime timereservation;
    @Enumerated(EnumType.STRING)
    private Status status;
    public enum Status{PENDING,CONFIRMED,CANCELED}


    @ManyToOne
    Worker worker;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Washing_Service> washing_services;
}
