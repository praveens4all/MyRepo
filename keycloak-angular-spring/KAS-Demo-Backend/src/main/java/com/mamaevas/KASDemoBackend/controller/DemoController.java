package com.mamaevas.KASDemoBackend.controller;

import com.mamaevas.KASDemoBackend.entity.Church;
import com.mamaevas.KASDemoBackend.service.ChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/authenticate")
public class DemoController {

    private ChurchService churchService;

    @Autowired
    public DemoController(ChurchService churchService) {
        this.churchService = churchService;
    }

    @PreAuthorize("hasAnyRole('ROLE_manager')")
    @ResponseBody
    @GetMapping(value = "/manager", produces = "text/plain; charset=UTF-8")
    public String getManager(Principal principal) {
        return logPrincipal(principal);
    }

    @PreAuthorize("hasAnyRole('ROLE_admin')")
    @ResponseBody
    @GetMapping(value = "/admin", produces = "text/plain; charset=UTF-8")
    public String getAdmin(Principal principal) {
        Church church = churchService.getChurchByName("Acts church");
        System.out.println("church"+church.toString());
        return logPrincipal(principal);
    }

    @PreAuthorize("hasAnyRole('ROLE_admin', 'ROLE_manager')")
    @ResponseBody
    @GetMapping(value = "/admin-manager", produces = "text/plain; charset=UTF-8")
    public String getAdminManager(Principal principal) {
        return logPrincipal(principal);
    }

    @ResponseBody
    @GetMapping(value = "/all", produces = "text/plain; charset=UTF-8")
    public String getAll(Principal principal) {
        return logPrincipal(principal);
    }

    private String logPrincipal(Principal principal) {
        Collection<SimpleGrantedAuthority> authorities =
                (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        System.out.println("######################################");
        System.out.println(authorities);
        System.out.println("######################################");
        System.out.println(principal);
        return principal.getName() + " " + authorities.toString();
    }
}
