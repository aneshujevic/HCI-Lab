package com.hci_lab.Apoteka.medication;

import com.hci_lab.Apoteka.pharmacy.Pharmacy;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;
    private String dosages;

    @ManyToMany(mappedBy = "medications")
    private Set<Pharmacy> pharmacies;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "medication_replacements",
            joinColumns = {@JoinColumn(name = "medication_id")},
            inverseJoinColumns = {@JoinColumn(name = "replacements_id")}
    )
    private Set<Medication> replacements;

    public Set<Pharmacy> getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(Set<Pharmacy> pharmacies) {
        this.pharmacies = pharmacies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosages() {
        return dosages;
    }

    public void setDosages(String dosage) {
        this.dosages = dosage;
    }

    public Set<Medication> getReplacements() {
        return replacements;
    }

    public void setReplacements(Set<Medication> replacements) {
        this.replacements = replacements;
    }
}
