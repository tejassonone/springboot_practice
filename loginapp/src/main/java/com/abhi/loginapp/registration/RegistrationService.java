package com.abhi.loginapp.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.abhi.loginapp.appuser.AppUser;
import com.abhi.loginapp.appuser.AppUserRepository;
import com.abhi.loginapp.appuser.AppUserRole;
import com.abhi.loginapp.appuser.AppUserService;

import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor
public class RegistrationService {
	
	@Autowired
    private AppUserService appUserService;
    

	
	
    public String register(RegistrationRequest request) {
//		String password= user.getPassword();
//		String encodedPassword = passwordEncoder.encode(password);
//		user.setPassword(encodedPassword);
//		user = AppUserRepository.save(user);
		
//        AppUser user = new AppUser(
//                request.getFirstName(),
//                request.getLastName(),
//                request.getEmail(),
//                request.getPassword(),
//                AppUserRole.USER
//
//        );
//        AppUserRepository.save(user);
		return "user registered";
    	
    }
    
   

}
