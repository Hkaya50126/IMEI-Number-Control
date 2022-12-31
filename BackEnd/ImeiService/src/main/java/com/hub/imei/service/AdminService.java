package com.hub.imei.service;

import com.hub.imei.entity.AppUser;
import com.hub.imei.repo.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService implements IAdminService{
    private final AppUserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AppUser saveAdmin(AppUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setBanned(false);
        user.setAdmin(true);
        return userRepo.save(user);
    }

    @Override
    public List<AppUser> getAllAdmins(){
        return userRepo.getAllAdmins();
    }

    @Override
    public Long getCountOfUsers(){
        return userRepo.countUser();
    }
}
