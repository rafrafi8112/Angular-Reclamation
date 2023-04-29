package com.example.mobilite_internationale.controllers;

import com.example.mobilite_internationale.entities.Publication;
import com.example.mobilite_internationale.entities.Reclamation;

import com.example.mobilite_internationale.interfaces.ReclamationInterface;
import com.example.mobilite_internationale.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Reclamation")

public class ReclamationController {
    @Autowired
    ReclamationInterface reclamationInterface;
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add-Reclamation/{userId}")
    @ResponseBody
    public void addReclamation(@RequestBody Reclamation rec, @PathVariable("userId") Integer id) {
        reclamationInterface.addReclamation(rec,id);

    }
    @PostMapping("/add-ReclamationPub/{userId}/{pubId}")
    @ResponseBody
    public void addReclamationPub(@RequestBody Reclamation rec, @PathVariable("userId") Integer iduser,@PathVariable("pubId") Integer idpub) {
        reclamationInterface.addReclamationPub(rec,iduser,idpub);

    }
    @GetMapping("/retrieve-all-reclamation")
    public List<Reclamation> retrieveAllReclamation() {
        List<Reclamation> reclamations = reclamationInterface.retrieveAllReclamation();
        return reclamations;
    }
    @DeleteMapping("/remove-reclamation/{id-rec}")
    public void removeReclamation(@PathVariable("id-rec") Integer idUser) {
        reclamationInterface.removeReclamation(idUser);
    }
    @PutMapping("/update-reclamation/{id-rec}")
    public Reclamation updateReclamation(@RequestBody Reclamation u,@PathVariable("id-rec") Integer idrec) {
        Reclamation reclamation = reclamationInterface.updateReclamation(u,idrec);
        return reclamation;
    }
    @GetMapping("/getReclamationsByClient/{idUser}")
    @ResponseBody
    public List<Reclamation> getReclamationsByClient(@PathVariable("idUser") Integer idUser) {
        return reclamationInterface.getReclamationsByUser(idUser);

    }

    @PostMapping("/reclamationsBlock")
    public void createReclamations() {

        userService.checkAndBlockUser();
    }
}
