package com.abhi.studentapp.auth;


import java.util.Optional;

import org.springframework.stereotype.Repository;


public interface ApplicationUserDao{

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}