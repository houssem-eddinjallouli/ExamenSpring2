package tn.esprit.ExamenSpring.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ExamenSpring.entite.Vehicle;
import tn.esprit.ExamenSpring.entite.Washing_Service;
import tn.esprit.ExamenSpring.entite.Worker;
import tn.esprit.ExamenSpring.service.ITestService;

import java.util.Date;
import java.util.List;

@RestController

@RequestMapping("/spring")
public class TestController {

    @Autowired
    ITestService testService;

    @PostMapping("/add-addWorker")
    public Worker addWorker(@RequestBody Worker c) {
        return testService.addWorker(c);
    }


    @PostMapping("/add-addWashingService")
    public void addWashingService(@RequestBody List<Washing_Service> c) {
         testService.addWashingService(c);
    }



    @PostMapping("/add-addVehicleReservationAndAffectToWashingservice")
    public Vehicle addVehicleReservationAndAffectToWashingservice(@RequestBody Vehicle c,@RequestParam List<Long> idService) {
        return testService.addVehicleReservationAndAffectToWashingservice(c,idService);
    }

    @PutMapping("/affectWorkertoReservation/{nic}")
    public Worker affectWorkertoReservation(@PathVariable("nic") String nic,@RequestParam List<Long> idReservation) {
        return testService.affectWorkertoReservation(nic,idReservation);
    }


//    @PostMapping("/add-participant")
//    public Participant addChambre(@RequestBody Participant c) {
//        Participant chambre = participantService.ajouterParticipant(c);
//        return chambre;
//    }
//

//
//    @GetMapping("/retrieve-par")
//    public List<Participant> getChambres() {
//        return participantService.getParReservLogis();
//    }
//

//    @PostMapping("/add-logistique/{d}")
//    public Logistique addzeaChambre(@RequestBody Logistique c,@PathVariable("d") String d) {
//        return logistiqueService.ajoutAffectLogEvnm(c,d);
//    }

//
//    @GetMapping("/retrieve-logistique/{dd}/{df}")
//    public List<Logistique> getChambres(@PathVariable("dd")@DateTimeFormat(pattern = "yyyy-MM-dd") Date dd, @PathVariable("df")@DateTimeFormat(pattern = "yyyy-MM-dd") Date df) {
//        return logistiqueService.getLogistiquesDates(dd,df);
//    }
//

//    @PostMapping("/add-evenement")
//    public Evenement addChaeazembre(@RequestBody Evenement c) {
//        Evenement chambre = evenementService.ajoutAffectEvenParticip(c);
//        return chambre;
//    }

}
