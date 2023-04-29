package com.example.mobilite_internationale.controllers;

import com.example.mobilite_internationale.entities.Reclamation;
import com.example.mobilite_internationale.entities.Reponse;
import com.example.mobilite_internationale.interfaces.ReclamationInterface;
import com.example.mobilite_internationale.services.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reponse")
public class ReponseController {
    @Autowired
    ReponseService reponseService;
    @PostMapping("/add-Reponse/{userId}/{recId}")
    @ResponseBody
    public void addReponse(@RequestBody Reponse rec, @PathVariable("userId") Integer iduser, @PathVariable("recId") Integer idpub) {
        reponseService.addReponse(idpub,iduser,rec);

    }
    @DeleteMapping("/remove-reponse/{id-rec}")
    public void removeReponse(@PathVariable("id-rec") Integer idUser) {
        reponseService.removeReponse(idUser);
    }
    @PutMapping("/update-reponse/{id-rep}")
    public Reponse updateReponse(@RequestBody Reponse u,@PathVariable("id-rep") Integer idrep) {
        Reponse reponse = reponseService.updateReponse(u,idrep);
        return reponse ;
    }
    @GetMapping("/retrieve-all-reponses")
    public List<Reponse> retrieveAllReclamation() {
        List<Reponse> reponses = reponseService.retrieveAllReponse();
        return reponses;
    }
    @GetMapping("/getReponseById/{idUser}")
    @ResponseBody
    public List<Reponse> getReponseByClient(@PathVariable("idUser") Integer idUser) {
        return reponseService.getReponseByUser(idUser);

    }
}
