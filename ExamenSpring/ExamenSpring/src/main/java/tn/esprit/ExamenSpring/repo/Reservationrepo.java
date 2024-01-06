package tn.esprit.ExamenSpring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ExamenSpring.entite.Reservation;

public interface Reservationrepo extends JpaRepository<Reservation, Long> {
}
