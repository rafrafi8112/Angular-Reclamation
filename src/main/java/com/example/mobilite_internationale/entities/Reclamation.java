package com.example.mobilite_internationale.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdReclamation;
    private String Email;


    private String Sujet;
    private String Message;
    private LocalDate dateRecl;
    private Boolean Pending=false;
    @JsonIgnore
    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToOne
    private Reponse reponsev;

    @JsonIgnore
    @ManyToOne
    private Publication publication;



}
