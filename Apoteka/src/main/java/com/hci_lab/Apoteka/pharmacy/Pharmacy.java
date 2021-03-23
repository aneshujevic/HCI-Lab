package com.hci_lab.Apoteka.pharmacy;

import com.hci_lab.Apoteka.location.Location;
import com.hci_lab.Apoteka.medication.Medication;
import com.hci_lab.Apoteka.person.Person;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToOne
    private Person owner;

    @OneToMany(targetEntity = Person.class, mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Person> workers = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "pharmacy_medications",
            joinColumns = {@JoinColumn(name = "pharmacy_id")},
            inverseJoinColumns = {@JoinColumn(name = "medications_id")}
    )
    private Set<Medication> medications = new HashSet<>();

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Medication> getMedications() {
        return medications;
    }

    public void setMedications(Set<Medication> medications) {
        this.medications = medications;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Set<Person> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Person> workers) {
        this.workers = workers;
    }
}
