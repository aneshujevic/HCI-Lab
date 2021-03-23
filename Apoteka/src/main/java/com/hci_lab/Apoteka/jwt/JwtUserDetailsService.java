package com.hci_lab.Apoteka.jwt;

import com.hci_lab.Apoteka.admin.AdminRepository;
import com.hci_lab.Apoteka.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// T
// servis koji nam sluzi da vrati detalje o korisniku iz baze
// na osnovu kojih validiramo JWT
@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final AdminRepository adminRepository;

    @Autowired
    public JwtUserDetailsService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var admin = adminRepository.findByUsername(username);
        if (admin != null) {
            var authorities = new ArrayList<SimpleGrantedAuthority>();

            for (Role role : admin.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }

            return new User(admin.getUsername(), admin.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("No admin with this username: " + username);
        }
    }
}
