package com.example.mobilite_internationale.services;

import com.example.mobilite_internationale.entities.Publication;
import com.example.mobilite_internationale.entities.Reclamation;
import com.example.mobilite_internationale.entities.User;
import com.example.mobilite_internationale.interfaces.ReclamationInterface;
import com.example.mobilite_internationale.repositories.PublicationRepository;
import com.example.mobilite_internationale.repositories.ReclamationRepository;
import com.example.mobilite_internationale.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class ReclamationService implements ReclamationInterface {
    @Autowired
    ReclamationRepository reclamationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PublicationRepository publicationRepository;
    private List<String> badWords = Arrays.asList("Fuck", "FUCK", "fuck","shit","Sheat");
    @Override
    public void addReclamation(Reclamation r, Integer id) {
        User u1 = userRepository.findById(id).orElse(null);
        r.setUser(u1);
        String filterMessage = filterMessage(r.getMessage());
        r.setMessage(filterMessage);
        reclamationRepository.save(r);
    }

    @Override
    public void addReclamationPub(Reclamation r, Integer iduser, Integer idpub) {
        User u1 = userRepository.findById(iduser).orElse(null);
        Publication p1 =publicationRepository.findById(idpub).orElse(null);


        List<Reclamation> reclamations = reclamationRepository.findByUserAndPublication(u1, p1);
        if (!reclamations.isEmpty()) {
            System.out.println("User has already made a reclamation on this publication.");
            return;
        }

        String filterMessage = filterMessage(r.getMessage());
        r.setMessage(filterMessage);
        r.setPublication(p1);
        r.setDateRecl(LocalDate.now());

        r.setUser(u1);
        reclamationRepository.save(r);
        if (p1.getReclamationSet().size()==4){
            p1.getUser().setBanned(true);

        }



    }

    private String filterMessage(String message) {
        for (String word : badWords) {
            String regex = "\\b" + word + "\\b";
            String replacement = "*".repeat(word.length());
            message = message.replaceAll(regex, replacement);
        }
        return message;
    }

    @Override
    public void removeReclamation(Integer idReclamation) {
        reclamationRepository.deleteById(idReclamation);
    }

    @Override
    public Reclamation updateReclamation(Reclamation rec, Integer idrec) {
        Reclamation r1 = reclamationRepository.findById(idrec).orElse(null);
        String filterMessage = filterMessage(rec.getMessage());
        r1.setMessage(filterMessage);

        return reclamationRepository.save(r1);
    }

    @Override
    public List<Reclamation> retrieveAllReclamation() {
        return reclamationRepository.findAll();
    }

    @Override
    public List<Reclamation> getReclamationsByUser(Integer idUser) {
        List<Reclamation> first = (List<Reclamation>) reclamationRepository.findAll();
        List<Reclamation> second = new ArrayList<Reclamation>();
        for(Reclamation rec : first)
        {
            if(rec.getUser().getIdUser()==idUser)
            {
                second.add(rec);

            }
        }

        return second;
    }
}
