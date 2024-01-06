package tn.esprit.ExamenSpring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ExamenSpring.entite.Reservation;
import tn.esprit.ExamenSpring.entite.Worker;

public interface WorkerRepo extends JpaRepository<Worker, Long> {
    Worker findByNic(String hh);
}
