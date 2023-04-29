package com.example.mobilite_internationale.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPub;
    private  String title;
    private  String contenu;
    private  String path;
    @JsonIgnore
    @OneToMany(mappedBy = "publication", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Commentaire> commentaires;
    @JsonIgnore
    @ManyToOne
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy = "publication", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private  Set<Reclamation> reclamationSet;
}
