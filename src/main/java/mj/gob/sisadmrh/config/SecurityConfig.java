package mj.gob.sisadmrh.config;

import mj.gob.sisadmrh.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    UserDetailsServiceImpl userDetailsService;
 
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
     
     
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
 
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
        http.csrf().disable();
 
        // The pages does not require login
        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
        http.authorizeRequests().antMatchers("/index").authenticated();
 
        		http.authorizeRequests().antMatchers("/usuarios/")
                            .access("hasAnyRole('ROLE_ADMIN')");//Consultar Usuarios</a></li>
                        http.authorizeRequests().antMatchers("/usuarios/new/usuario")
                            .access("hasAnyRole('ROLE_ADMIN')");//Crear Usuario</a></li>
                        http.authorizeRequests().antMatchers("/roles/")
                            .access("hasAnyRole('ROLE_ADMIN')");//Consultar Roles</a></li>
                        http.authorizeRequests().antMatchers("/roles/new/rol")
                            .access("hasAnyRole('ROLE_ADMIN')");//Crear Rol</a></li>
                        http.authorizeRequests().antMatchers("/usuariosroles/")
                            .access("hasAnyRole('ROLE_ADMIN')");//Consultar roles asignados</a></li>
                        http.authorizeRequests().antMatchers("/usuariosroles/new/usuariorol")
                            .access("hasAnyRole('ROLE_ADMIN')");//Asignar Roles</a></li>
                        http.authorizeRequests().antMatchers("/archivos/")
                            .access("hasAnyRole('ROLE_ADMIN')");//Carga de Archivos Fuentes<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-cog"></span></a></li>
			http.authorizeRequests().antMatchers("/beneficios/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Consultar Beneficios</a></li>
                        http.authorizeRequests().antMatchers("/beneficios/new/beneficio")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear Beneficio</a></li>
                        http.authorizeRequests().antMatchers("/beneficios/report/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO')");//Reporte de Beneficios</a></li>
			http.authorizeRequests().antMatchers("/cuadrodirectivos/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Consultar Cuadros Directivos</a></li>
                        http.authorizeRequests().antMatchers("/cuadrodirectivos/new/cuadrodirectivo")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear Cuadros Directivos</a></li>
                        http.authorizeRequests().antMatchers("/cuadrodirectivos/report/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Reporte de Cuadro Directivo</a></li>
			http.authorizeRequests().antMatchers("/capacitaciones/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Consultar Capacitaciones</a></li>
                        http.authorizeRequests().antMatchers("/capacitaciones/new/capacitacion")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear Capacitaciones</a></li>
                        http.authorizeRequests().antMatchers("/capacitaciones/report/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER')");//Reporte de Capacitaciones</a></li>
			http.authorizeRequests().antMatchers("/capacitaciones/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Consultar EmpleadoCapacitaciones</a></li>
                        http.authorizeRequests().antMatchers("/empleadocapacitaciones/new/empleadocapacitacion")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear EmpleadoCapacitaciones</a></li>
			http.authorizeRequests().antMatchers("/capacitadores/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Consultar Capacitador</a></li>
                        http.authorizeRequests().antMatchers("/capacitadores/new/capacitador")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Crear Capacitador</a></li>
                        http.authorizeRequests().antMatchers("/costocapacitaciones/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Consultar Costo Capacitaciones</a></li>
                        http.authorizeRequests().antMatchers("/costocapacitaciones/new/costocapacitacion")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear Costo Capacitacion2</a></li>
                        http.authorizeRequests().antMatchers("/costocapacitaciones/report/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Reporte comites</a></li>-->
                        http.authorizeRequests().antMatchers("/empleadoasistenciacapacitaciones/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Consultar EmpleadoCapacitaciones</a></li>
                        http.authorizeRequests().antMatchers("/empleadoasistenciacapacitaciones/new/empleadoasistenciacapacitacion")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear Empleado Asistencia Capacitaciones</a></li>
			http.authorizeRequests().antMatchers("/asistenciacapacitaciones/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Consultar Asistencia de Capacitacion</a></li>
                        http.authorizeRequests().antMatchers("/asistenciacapacitaciones/new/asistenciacapacitacion")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear Asistencia Capacitacion</a></li>
			http.authorizeRequests().antMatchers("/diagnosticocapacitaciones/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Consultar diagnostico</a></li>
                        http.authorizeRequests().antMatchers("/diagnosticocapacitaciones/new/diagnosticocapacitacion")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear Diagnostico</a></li>
			http.authorizeRequests().antMatchers("/evaluacioncapacitaciones/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Consultar Evualucion Capacitacion</a></li>
                        http.authorizeRequests().antMatchers("/evaluacioncapacitaciones/new/evaluacioncapacitacion")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear Evualucion Capacitacion</a></li>
			http.authorizeRequests().antMatchers("/comites/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Consultar comites</a></li>
                        http.authorizeRequests().antMatchers("/comites/new/comite")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Crear comite</a></li>
                        http.authorizeRequests().antMatchers("/comites/report/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER')");//Reporte comites</a></li>
                        http.authorizeRequests().antMatchers("/nivelescolaridades/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Niveles escolares</a></li>
                        http.authorizeRequests().antMatchers("/nivelescolaridades/new/nivelescolaridad")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear Nivel escolar</a></li>
			http.authorizeRequests().antMatchers("/incapacidades/new/incapacidad")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");// Crear Incapacidad</a></li>
			http.authorizeRequests().antMatchers("/incapacidades/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Consultar incapacidades</a></li>
                        http.authorizeRequests().antMatchers("/comisiones/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Consultar Comisiones</a></li>
                        http.authorizeRequests().antMatchers("/comisiones/new/comision")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear Comisiones</a></li>
                        http.authorizeRequests().antMatchers("/comisiones/reporte/comision")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Reporte de Comisiones</a></li>
			http.authorizeRequests().antMatchers("/inasistencias/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Consultar Inasistencias</a></li>
                        http.authorizeRequests().antMatchers("/inasistencias/new/inasistencia")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear Inasistencias</a></li>
                        http.authorizeRequests().antMatchers("/puestos/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Consultar Puestos de Trabaj</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/puestoreporte/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//reporte de puestos a caducar</a></li>
                        http.authorizeRequests().antMatchers("/puestos/new/puesto")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear Puesto de Trabaj</a></li>
                        http.authorizeRequests().antMatchers("/misiones/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Consultar Misiones</a></li>
                        http.authorizeRequests().antMatchers("/misiones/new/mision")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear Misiones</a></li>
                        http.authorizeRequests().antMatchers("/misiones/reporte/mision")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Reporte de Misiones</a></li>
			http.authorizeRequests().antMatchers("/empleados/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Consultar Empleados</a></li>
			http.authorizeRequests().antMatchers("/empleados/new/empleado")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Crear Empleado</a></li>
			http.authorizeRequests().antMatchers("/estados/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER')");//Consultar Estados</a></li>
                        http.authorizeRequests().antMatchers("/estados/new/estado")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER')");//Crear Estado</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/abogados/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Reporte de Abogados</a></li>
			http.authorizeRequests().antMatchers("/otherreports/empleadoincapacidad/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO')");//Reporte de Empleados con incapacidad</a></li>
			http.authorizeRequests().antMatchers("/otherreports/hijoscapesp/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Reporte de empleados con hijos con capacidades especiales</a></li>
			http.authorizeRequests().antMatchers("/otherreports/historial/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTRATEGICO','ROLE_TACTICO','ROLE_OPERATIVO')");//Reporte de Historial Laboral</a></li>
			http.authorizeRequests().antMatchers("/otherreports/motoristas/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Reporte de Motoristas</a></li>
			http.authorizeRequests().antMatchers("/otherreports/notarios/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Reporte de Notarios</a></li>
			http.authorizeRequests().antMatchers("/otherreports/renuncias/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTRATEGICO')");//Reporte de renuncias</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/comites/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Reporte de comites</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/capacitaciones/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Reporte de capacitaciones</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/cumpleanieros/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Reporte de cumpleanieros</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/constanciaservicios/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTRATEGICO')");//Constancia de Servicios</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/misionesinternas/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTRATEGICO')");//Reporte de Misiones Internas</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/1misionesexternas/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTRATEGICO')");//Reporte de Misiones externa1</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/2misionesexternas/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTRATEGICO')");//Reporte de Misiones externa2</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/constanciasalariales/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTRATEGICO')");//constancias salariales</a></li>
                        http.authorizeRequests().antMatchers("/comites/report/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO')");//Reporte comites</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/plazasocupadas/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO')");//Reporte Plazas Ocupadas</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/puestoscaducar/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTRATEGICO')");//Reporte Puesto a Caducar</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/contrataciones/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTRATEGICO')");//Reporte Contrataciones</a></li>
                        http.authorizeRequests().antMatchers("/empleado/reporte/despidos")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTRATEGICO')");//Reporte de Despidos</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/despidos/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTRATEGICO')");//Reporte de Despidos</a></li>
                        http.authorizeRequests().antMatchers("/empleado/reporte/estadisticoactivos")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER', 'ROLE_ESTRATEGICO')");//Estadistico de Personal Activo</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/capacitadores/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO')");//Reporte Capacitador</a></li>
                        http.authorizeRequests().antMatchers("/capacitaciones/reporte/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER')");//Reporte de Capacitaciones</a></li>
                        http.authorizeRequests().antMatchers("/capacitaciones/reporte/diagnostico")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO','ROLE_OPERATIVO')");//Reporte de Temas de Diagnostico</a></li>
                        http.authorizeRequests().antMatchers("/capacitaciones/reporte/personalcapacitado")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ESTRATEGICO')");//Estadistico de Personal Capacitado</a></li>
                        http.authorizeRequests().antMatchers("/cuadrodirectivos/report/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER')");//Reporte de Cuadro Directivo</a></li>
                        http.authorizeRequests().antMatchers("/beneficios/report/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER')");//Reporte de Beneficios</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/reporte/costocreporte")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER')");//Reporte de costos de Capacitacion</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/reporte/pensionadoreporte")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO')");//Reporte de Personal Pensionado</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/reporte/exoneradoreporte")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TACTICO')");//Reporte de Personal Exonerado de Marcacion</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/reporte/nivelesreporte")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Reporte de Niveles Escolares</a></li>
                        http.authorizeRequests().antMatchers("/otherreports/evaluacioncap")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_OPERATIVO')");//Reporte de Niveles Escolares</a></li>
                                
        

        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will be thrown.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
        // Config for Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/index")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Config for Logout Page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
 
    }
}