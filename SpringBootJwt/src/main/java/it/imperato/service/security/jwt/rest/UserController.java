package it.imperato.service.security.jwt.rest;
	
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.imperato.service.security.jwt.model.User;

@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController {

//    @Autowired
//    private UserService userService;

//    @RequestMapping( method = GET, value = "/user/{userId}" )
//    public User loadById( @PathVariable Long userId ) {
//        return this.userService.findById( userId );
//    }
//
//    @RequestMapping( method = GET, value= "/user/all")
//    public List<User> loadAll() {
//        return this.userService.findAll();
//    }
//
//    @RequestMapping( method = GET, value= "/user/reset-credentials")
//    public ResponseEntity<Map> resetCredentials() {
//        this.userService.resetCredentials();
//        Map<String, String> result = new HashMap<>();
//        result.put( "result", "success" );
//        return ResponseEntity.accepted().body(result);
//    }
    
    /*
     *  Non viene usata la chiamata a userService.findByUsername (possibile aggiungeral comunque),
     *  Aggiunta quindi la pre autorizzazione sul role "ROLE_USER" per accedere l'endpoint.
     */
    @RequestMapping("/whoamiByDB")
    @PreAuthorize("hasRole('USER')")
    public User user() {
        SecurityContext context = SecurityContextHolder
                .getContext();
		Authentication authentication = context
                .getAuthentication();
		Object principal = authentication
                .getPrincipal();
		return (User)principal;
    }

}
