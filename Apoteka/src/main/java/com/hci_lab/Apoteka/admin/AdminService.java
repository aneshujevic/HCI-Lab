package com.hci_lab.Apoteka.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {

    private final AdminRepository repository;

    @Autowired
    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register(Admin admin) {
        var unhashed = admin.getPassword();
        var encoder = new BCryptPasswordEncoder();
        var hashed = encoder.encode(unhashed);

        admin.setPassword(hashed);
        repository.save(admin);
    }

    @Override
    public void changePassword(Admin admin) {
        var unhashed = admin.getPassword();
        var encoder = new BCryptPasswordEncoder();
        var hashed = encoder.encode(unhashed);

        admin.setPassword(hashed);
        repository.save(admin);
    }
}
