package com.example.mobilite_internationale.interfaces;

import com.example.mobilite_internationale.entities.Reclamation;
import com.example.mobilite_internationale.entities.Reponse;

import java.util.List;

public interface ReponseInterface {
    public void addReponse(Integer idReclamation , Integer iduser, Reponse rp);
    public void removeReponse(Integer idReponse);
    public Reponse updateReponse (Reponse rep,Integer idrep);
    public List<Reponse> retrieveAllReponse();
    public List<Reponse> getReponseByUser(Integer idUser);
}
