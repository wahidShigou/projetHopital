package cours.java.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Specialite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 40, nullable = false)
    private String libelle;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToMany(mappedBy = "specialites")
    private List<Medecin> employes;

    public List<Medecin> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Medecin> employes) {
        this.employes = employes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
