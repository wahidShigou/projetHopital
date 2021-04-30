package cours.java.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 40, nullable = false)
    private String libelle;


    @OneToMany(mappedBy = "service")
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
