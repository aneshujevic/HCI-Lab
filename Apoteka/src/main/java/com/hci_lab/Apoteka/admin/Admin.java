package com.hci_lab.Apoteka.admin;

import com.hci_lab.Apoteka.role.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "admin_roles",
            joinColumns = {@JoinColumn(name = "admin_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id")}
    )
    private Set<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
