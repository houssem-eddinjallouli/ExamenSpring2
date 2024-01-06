package tn.esprit.ExamenSpring.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ExamenSpring.entite.Reservation;
import tn.esprit.ExamenSpring.entite.Vehicle;
import tn.esprit.ExamenSpring.entite.Washing_Service;
import tn.esprit.ExamenSpring.entite.Worker;
import tn.esprit.ExamenSpring.repo.Reservationrepo;
import tn.esprit.ExamenSpring.repo.Vehiclerepo;
import tn.esprit.ExamenSpring.repo.Washingrepo;
import tn.esprit.ExamenSpring.repo.WorkerRepo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class TestServiceImp implements ITestService{
Reservationrepo reservationrepo;
Vehiclerepo vehiclerepo;
Washingrepo washingrepo;
WorkerRepo workerRepo;
    @Override
    public Worker addWorker(Worker worker) {
        return workerRepo.save(worker);
    }

    @Override
    public void addWashingService(List<Washing_Service> waching_service) {
        for (Washing_Service ws:waching_service)
            washingrepo.save(ws);
    }

    @Override
    @Transactional
    public Vehicle addVehicleReservationAndAffectToWashingservice(Vehicle vehicle, List<Long> idService) {
        Reservation nr = new Reservation();
        nr.setStatus(Reservation.Status.PENDING);
        nr.setTimereservation(LocalDateTime.now().plusHours(2));
        nr.setWashing_services(new HashSet<>());
        for (Long s :idService)
        {
            Washing_Service waching_service=washingrepo.findById(s).orElse(null);
            nr.getWashing_services().add(waching_service);
        }
        vehicle.setReservations(new HashSet<>());
        vehicle.getReservations().add(nr);
        return vehiclerepo.save(vehicle);
    }

    @Override
    @Transactional
    public Worker affectWorkertoReservation(String nic, List<Long> idReservation) {
        Worker houssem=workerRepo.findByNic(nic);
        for (Long i:idReservation)
        {
            if (houssem.getReservations().size()<5){
            Reservation r = reservationrepo.findById(i).orElse(null);
            r.setWorker(houssem);
            r.setStatus(Reservation.Status.CONFIRMED);}
        }

        return workerRepo.save(houssem);
    }
}
