package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.PersonaServicio;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorCiudadRepo;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorRepo;
import co.edu.uniquindio.proyecto.Repositorios.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonaServicioImpl implements PersonaServicio {

    @Autowired
    AdministradorRepo administradorRepo;

    @Autowired
    ClienteRepo clienteRepo;

    @Autowired
    AdministradorCiudadRepo administradorCiudadRepo;

    @Override
    public Integer verificarTipoDeUsuario(String email) throws Exception {
        if(administradorRepo.findByEmail(email).isPresent()){
            return 1;
        } else {
            if(administradorCiudadRepo.findByEmail(email).isPresent()){
                return 2;
            } else{
                if(clienteRepo.findByEmail(email).isPresent()){
                    return 3;
                } else{
                    throw new Exception("No existe un usuario de ningun tipo registrado con este email.");
                }
            }
        }
    }
}
