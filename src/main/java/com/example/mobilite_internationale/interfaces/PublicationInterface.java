package com.example.mobilite_internationale.interfaces;

import com.example.mobilite_internationale.entities.Publication;

import java.util.List;

public interface PublicationInterface {
    public Publication addPublication (Publication Publication);
    public void addPublication2 (Publication Publication,Integer iduser);
    public List<Publication> retrieveAllPublications();
    public Publication retrievePublication (Integer  idPublication);
    public Publication updatePublication (Publication Publication);
    public void removePublication(Integer idPublication);
}
