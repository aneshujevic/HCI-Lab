package com.hci_lab.Apoteka.admin;

import com.hci_lab.Apoteka.role.Role;
import com.hci_lab.Apoteka.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AdminController {

    private final AdminService service;

    private final RoleRepository roleRepository;

    @Autowired
    public AdminController(AdminService service, RoleRepository roleRepository) {
        this.service = service;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/register-admin")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAdmin(@RequestBody Admin admin) {
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName("ADMIN");
        roles.add(role);
        admin.setRoles(roles);
        service.register(admin);
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestParam("admin") Admin admin) {
        var userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var username = userDetails.getUsername();

        if (!username.equals(admin.getUsername())) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

        service.changePassword(admin);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    //    Ili koristimo preauthorize ili u WebSecurityConfig koristimo hasAuthority
//    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/test-role")
    public ResponseEntity<?> testRole() {
        return ResponseEntity.ok("successful role test");
    }
}
