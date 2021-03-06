package mj.gob.sisadmrh.service;

import java.util.ArrayList;
import java.util.List;
import mj.gob.sisadmrh.model.Usuario;
import mj.gob.sisadmrh.repository.UsuarioRepository;
import mj.gob.sisadmrh.repository.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UsuarioRepository usuarioRepo;
 
    @Autowired
    private UsuarioRolRepository userRoleRepo;
 
   @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario appUser = this.usuarioRepo.findbyusername(userName);
    
        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
 
        System.out.println("Found User: " + appUser);
 
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.userRoleRepo.getListroles(appUser.getCodigousuario());
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
 
        UserDetails userDetails = (UserDetails) new User(appUser.getNombreusuario(), //
                appUser.getContraseniausuario(), grantList);
 
        return userDetails;
    }
}