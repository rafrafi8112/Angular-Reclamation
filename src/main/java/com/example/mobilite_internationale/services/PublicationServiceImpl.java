package com.example.mobilite_internationale.services;

import com.example.mobilite_internationale.entities.Publication;
import com.example.mobilite_internationale.entities.User;
import com.example.mobilite_internationale.interfaces.PublicationInterface;
import com.example.mobilite_internationale.interfaces.UserInterface;
import com.example.mobilite_internationale.repositories.PublicationRepository;
import com.example.mobilite_internationale.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationInterface {

    @Autowired
    PublicationRepository Publicationrepo;
    @Autowired
    UserRepository userRepository;

    @Override
    public Publication addPublication(Publication Publication) {
        return Publicationrepo.save(Publication);
    }

    @Override
    public void addPublication2(Publication Publication, Integer iduser) {
        User u1 = userRepository.findById(iduser).orElse(null);
        Publication.setUser(u1);
        Publicationrepo.save(Publication);
    }


    @Override
    public List<Publication> retrieveAllPublications() {
        return Publicationrepo.findAll();
    }

    @Override
    public Publication retrievePublication(Integer idPublication) {
        return Publicationrepo.findById(idPublication).orElse(null);
    }

    @Override
    public Publication updatePublication(Publication Publication) {


        return Publicationrepo.save(Publication);
    }

    @Override
    public void removePublication(Integer idPublication) {
        Publicationrepo.deleteById(idPublication);
    }
}
