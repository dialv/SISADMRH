package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.NivelEscolaridad;

public interface NivelEscolaridadService {

    Iterable<NivelEscolaridad> listAllNivelEscolaridad();

    Iterable<NivelEscolaridad> listAllActivos();

    Optional<NivelEscolaridad> getNivelEscolaridadById(Integer id);

    NivelEscolaridad saveNivelEscolaridad(NivelEscolaridad nivelescolaridad);

    void deleteNivelEscolaridad(Integer id);
}
