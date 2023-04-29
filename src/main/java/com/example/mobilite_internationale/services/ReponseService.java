package com.example.mobilite_internationale.services;

import com.example.mobilite_internationale.entities.Reclamation;
import com.example.mobilite_internationale.entities.Reponse;
import com.example.mobilite_internationale.entities.User;
import com.example.mobilite_internationale.interfaces.ReactionInterface;
import com.example.mobilite_internationale.interfaces.ReponseInterface;
import com.example.mobilite_internationale.repositories.ReclamationRepository;
import com.example.mobilite_internationale.repositories.ReponseRepository;
import com.example.mobilite_internationale.repositories.UserRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class ReponseService implements ReponseInterface {
    @Autowired
    ReponseRepository reponseRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReclamationRepository reclamationRepository;

    @Override
    public void addReponse(Integer idReclamation, Integer iduser, Reponse rp) {
    Reclamation r1 =reclamationRepository.findById(idReclamation).orElse(null);
    User u1= userRepository.findById(iduser).orElse(null);
    r1.setPending(true);
    rp.setUser(u1);
    rp.setDatereponse(LocalDate.now());
    rp.setReclamation(r1);

    reponseRepository.save(rp);

    }

    @Override
    public void removeReponse(Integer idReponse) {
    reponseRepository.deleteById(idReponse);
    }

    @Override
    public Reponse updateReponse(Reponse rep, Integer idrep) {
        Reponse r1 = reponseRepository.findById(idrep).orElse(null);
        r1.setMessage(rep.getMessage());
       return reponseRepository.save(r1);
    }

    @Override
    public List<Reponse> retrieveAllReponse() {
        return reponseRepository.findAll();
    }

    @Override
    public List<Reponse> getReponseByUser(Integer idUser) {
User user = userRepository.findById(idUser).orElse(null);
List<Reponse> reponseList = reponseRepository.findAll();
        List<Reponse> reponses = new ArrayList<Reponse>();
        for (Reponse ls : reponseList){
            if (ls.getUser().getIdUser().equals(user.getIdUser())){
                reponses.add(ls);
            }
        }
        return reponses;

    }
}
