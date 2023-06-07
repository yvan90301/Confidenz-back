package com.isj.confidenz.models;

import lombok.Data;

import javax.persistence.*;
@Entity // indique qu'il s'agit d'une entité
@Table(name = "notification") // nom de la table dans la basede données
@Data
public class Notification {
    @Id
    @Column(name = "id_notification", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createdate", nullable = false)
    private String createdate;

    @Column(name = "vue", nullable = false)
    private  boolean vue;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_entreprise", nullable = false)
    private Entreprise id_entreprise;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_employe",nullable = false)
    private Employe id_employe;

    @Column(name = "contenu", nullable = false)
    private String contenu;
}

