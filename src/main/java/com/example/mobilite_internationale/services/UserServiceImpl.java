package com.example.mobilite_internationale.services;

import com.example.mobilite_internationale.entities.Publication;
import com.example.mobilite_internationale.entities.Reclamation;
import com.example.mobilite_internationale.entities.User;
import com.example.mobilite_internationale.repositories.ReclamationRepository;
import com.example.mobilite_internationale.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReclamationRepository reclamationService;


    public void checkAndBlockUser() {
        List<Reclamation> reclamations = reclamationService.findAll();
        for (Reclamation reclamation : reclamations) {
            Publication publication = reclamation.getPublication();
            User user = publication.getUser();
            Set<Reclamation> allReclamations = publication.getReclamationSet();
            if (allReclamations.size() >= 5) {
                for(Reclamation re1 : allReclamations){
                    re1.setPending(true);
                }
                user.setBanned(true);
                userRepository.save(user);
            }
        }
    }
}

