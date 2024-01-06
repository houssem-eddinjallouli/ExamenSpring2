package tn.esprit.ExamenSpring.service;

import tn.esprit.ExamenSpring.entite.Vehicle;
import tn.esprit.ExamenSpring.entite.Washing_Service;
import tn.esprit.ExamenSpring.entite.Worker;

import java.util.List;

public interface ITestService {
    public Worker addWorker(Worker worker);
    public void addWashingService(List<Washing_Service> waching_service);
    public Vehicle addVehicleReservationAndAffectToWashingservice (Vehicle vehicle, List<Long> idService);
    public Worker affectWorkertoReservation(String nic,List<Long> idReservation);
}
