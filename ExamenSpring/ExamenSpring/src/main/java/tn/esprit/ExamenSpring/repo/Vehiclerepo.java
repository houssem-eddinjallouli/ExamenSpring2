package tn.esprit.ExamenSpring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ExamenSpring.entite.Reservation;
import tn.esprit.ExamenSpring.entite.Vehicle;

public interface Vehiclerepo extends JpaRepository<Vehicle, Long> {
}
