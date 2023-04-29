package com.example.mobilite_internationale.interfaces;

import com.example.mobilite_internationale.entities.Reclamation;

import java.util.List;

public interface ReclamationInterface {
    public void addReclamation(Reclamation r, Integer id);
    public void addReclamationPub(Reclamation r, Integer iduser,Integer idpub);
    public void removeReclamation(Integer idReclamation);
    public Reclamation updateReclamation (Reclamation rec,Integer idRec);
    public List<Reclamation> retrieveAllReclamation();
    public List<Reclamation> getReclamationsByUser(Integer idUser);
}
