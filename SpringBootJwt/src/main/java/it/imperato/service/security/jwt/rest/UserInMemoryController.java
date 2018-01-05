package it.imperato.service.security.jwt.rest;
	
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class UserInMemoryController {

	private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    public UserInMemoryController(InMemoryUserDetailsManager inMemoryUserDetailsManager) {
       this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    }

    @RequestMapping( method = GET, value = "/user/{userName}" )
    public User loadById( @PathVariable String userName ) {
    	UserDetails ud = this.inMemoryUserDetailsManager.loadUserByUsername( userName );
    	return new User(ud.getUsername(),ud.getPassword(),ud.getAuthorities());
    }

    @RequestMapping( method = GET, value= "/user/all")
    public List<User> loadAll() {
//    	Collection collUsers = buildUsersCollectionByInMemoryUserDetailsManager(inMemoryUserDetailsManager);
//    	List<User> users = new ArrayList<>(collUsers);
    	List<User> users = new ArrayList<>();
        return users;
    }
    
    public Collection buildUsersCollectionByUserDetailsService(Object bean){

        Field field = ReflectionUtils.findField(org.springframework.security.authentication.ProviderManager.class, "providers");
        ReflectionUtils.makeAccessible(field);
        List listOfProviders = (List)ReflectionUtils.getField(field, bean);     
        DaoAuthenticationProvider dao = (DaoAuthenticationProvider)listOfProviders.get(0);
        Field fieldUserDetailService = ReflectionUtils.findField(DaoAuthenticationProvider.class, "userDetailsService");
        ReflectionUtils.makeAccessible(fieldUserDetailService);
        InMemoryUserDetailsManager userDet = (InMemoryUserDetailsManager)(ReflectionUtils.getField(fieldUserDetailService, dao));
        Field usersMapField = ReflectionUtils.findField(InMemoryUserDetailsManager.class, "users");
        ReflectionUtils.makeAccessible(usersMapField);
        Map map = (Map)ReflectionUtils.getField(usersMapField, userDet);
        // log.info(map);
        return map.values();
    }
    
    public Collection buildUsersCollectionByInMemoryUserDetailsManager(Object bean){
        Field inMemoryUserDetailsManager = ReflectionUtils.findField(InMemoryUserDetailsManager.class, "inMemoryUserDetailsManager");
        ReflectionUtils.makeAccessible(inMemoryUserDetailsManager);
        InMemoryUserDetailsManager userDet = (InMemoryUserDetailsManager)(ReflectionUtils.getField(inMemoryUserDetailsManager, bean));
        Field usersMapField = ReflectionUtils.findField(InMemoryUserDetailsManager.class, "users");
        ReflectionUtils.makeAccessible(usersMapField);
        Map map = (Map)ReflectionUtils.getField(usersMapField, userDet);
        // log.info(map);
        return map.values();
    }

//    @RequestMapping( method = GET, value= "/user/reset-credentials")
//    public ResponseEntity<Map> resetCredentials() {
//        this.userService.resetCredentials();
//        Map<String, String> result = new HashMap<>();
//        result.put( "result", "success" );
//        return ResponseEntity.accepted().body(result);
//    }
    
    /*
     *  We are not using userService.findByUsername here(we could),
     *  so it is good that we are making sure that the user has role "ROLE_USER"
     *  to access this endpoint.
     */
    @RequestMapping("/whoami")
    @PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
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
