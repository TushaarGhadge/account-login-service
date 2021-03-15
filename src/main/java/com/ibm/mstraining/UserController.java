package com.ibm.mstraining;

import java.security.Principal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@PreAuthorize("hasAuthority('SCOPE_admin')")
    @RequestMapping("/user")
    public Principal user( Principal principal) {
        // Principal holds the logged in user information.
        // Spring automatically populates this principal object after login.
        return principal;
    }
    @Secured("ROLE_USER")
    @RequestMapping("/userInfo")
    public String userInfo(Principal principal) {
        return String.valueOf(principal);
    }
}