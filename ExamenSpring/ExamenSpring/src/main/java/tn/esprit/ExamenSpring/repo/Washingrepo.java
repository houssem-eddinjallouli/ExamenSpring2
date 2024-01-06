package tn.esprit.ExamenSpring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ExamenSpring.entite.Washing_Service;

public interface Washingrepo extends JpaRepository<Washing_Service, Long> {
}
