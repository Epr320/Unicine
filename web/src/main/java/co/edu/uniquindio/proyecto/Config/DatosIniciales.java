package co.edu.uniquindio.proyecto.Config;

import co.edu.uniquindio.proyecto.Interfaces.AdministradorCiudadServicio;
import co.edu.uniquindio.proyecto.Interfaces.AdministradorServicio;
import co.edu.uniquindio.proyecto.Interfaces.CiudadServicio;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

public class DatosIniciales implements CommandLineRunner {

    @Autowired
    AdministradorCiudadServicio administradorCiudadServicio;

    @Autowired
    AdministradorServicio administradorServicio;

    @Autowired
    CiudadServicio ciudadServicio;
    @Override
    public void run(String... args) throws Exception {


        List<Ciudad> ciudads = ciudadServicio.listar();

        if(ciudads.isEmpty()) {
            Ciudad ciudad = ciudadServicio.agregarCiudad("Armenia");
            Ciudad ciudad1 = ciudadServicio.agregarCiudad("Medellin");
            Ciudad ciudad2 = ciudadServicio.agregarCiudad("Pereira");
            Ciudad ciudad3 = ciudadServicio.agregarCiudad("Bogota");
            Ciudad ciudad4 = ciudadServicio.agregarCiudad("Cali");

            administradorServicio.crear("1111111111", "Carlos", "admin@gmail.com", "root");
            administradorCiudadServicio.agregarAdministradorDeCiudad("1111111112", "Raul perez", "adminArmenia@gmail.com", "root", ciudad);
            administradorCiudadServicio.agregarAdministradorDeCiudad("1111111113", "Raul perez", "adminMedellin@gmail.com", "root", ciudad1);
            administradorCiudadServicio.agregarAdministradorDeCiudad("1111111123", "Mario Quita", "adminPereira@gmail.com", "root", ciudad2);
            administradorCiudadServicio.agregarAdministradorDeCiudad("1111111124", "Sandra Liz", "adminBogota@gmail.com", "root", ciudad3);
            administradorCiudadServicio.agregarAdministradorDeCiudad("1111111126", "Pepito Perez", "adminCali@gmail.com", "root", ciudad4);
        }
    }

}
