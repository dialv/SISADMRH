/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.List;
import java.util.Optional;
import mj.gob.sisadmrh.model.AsistenciaCapacitacion;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.Comite;
import mj.gob.sisadmrh.repository.AsistenciaCapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaCapacitacionImpl implements AsistenciaCapacitacionService{
private AsistenciaCapacitacionRepository asistenciaCapacitacionRep;
@Autowired
public void SetAsistenciacapacitacionRepository(AsistenciaCapacitacionRepository asistenciaCapacitacionRepository){
this.asistenciaCapacitacionRep=asistenciaCapacitacionRepository;
}
    @Override
    public Iterable<AsistenciaCapacitacion> listAllAsistenciacapacitacion() {
      return asistenciaCapacitacionRep.findAll();
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<AsistenciaCapacitacion> getAsistenciacapacitacionById(Integer id) {
    
return asistenciaCapacitacionRep.findById(id);
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AsistenciaCapacitacion saveAsistenciacapacitacion(AsistenciaCapacitacion asistenciaCapacitacion) {
      return asistenciaCapacitacionRep.save(asistenciaCapacitacion);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAsistenciacapacitacion(Integer id) {
     asistenciaCapacitacionRep.deleteById(id);
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Object[]> findnamesBycemp(String emp) {
        
    return  asistenciaCapacitacionRep.findnamesBycemp(emp);   // servira para jalar el empleado,puesto y ubicacionfisica
    }
    

    @Override
    public Iterable<AsistenciaCapacitacion> findByCapacitacion(String dato) {
        return asistenciaCapacitacionRep.findByCapacitacion("%"+dato+"%");
        
    }

    @Override
    public Iterable<AsistenciaCapacitacion> listAllActivos() {
    return asistenciaCapacitacionRep.listAllActivos();
    }

}
