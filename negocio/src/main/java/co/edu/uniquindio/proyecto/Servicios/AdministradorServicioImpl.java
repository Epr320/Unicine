package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.AdministradorServicio;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorCiudadRepo;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorRepo;
import co.edu.uniquindio.proyecto.Repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.AdministradorCiudad;
import co.edu.uniquindio.proyecto.entidades.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdministradorServicioImpl implements AdministradorServicio {
    @Autowired
    AdministradorRepo administradorRepo;

    @Autowired
    AdministradorCiudadRepo administradorCiudadRepo;

    @Autowired
    ClienteRepo clienteRepo;

    @Override
    public Administrador login(String email, String password) throws Exception {
        return administradorRepo.findByEmailAndPassword(email,password).orElseThrow(() -> new Exception("Datos Incorrectos"));

    }

    @Override
    public Administrador crear(String cedula, String nombre, String email, String password) throws Exception {
        int tamanio;
        List<AdministradorCiudad> administradorHotelList = administradorCiudadRepo.findAll();
        Optional<Cliente> buscar = clienteRepo.findById(cedula);
        Optional<Administrador> buscar2 = administradorRepo.findById(cedula);
        Optional<AdministradorCiudad> buscar3 = administradorCiudadRepo.findById(cedula);

        if (buscar.isPresent() || buscar2.isPresent() || buscar3.isPresent()){
            throw new Exception("La cedula ya esta registrada en el sistema");
        }

        buscar = clienteRepo.findByEmail(email);
        buscar2 = administradorRepo.findByEmail(email);
        buscar3 = administradorCiudadRepo.findByEmail(email);

        if (buscar.isPresent() || buscar2.isPresent() || buscar3.isPresent()){
            throw new Exception("El email ya esta registrado");
        }

        if (administradorHotelList.isEmpty()) {
            tamanio = 0;
        } else {
            tamanio = administradorHotelList.size();
        }

        Administrador administrador = new Administrador(cedula, nombre, email, password, tamanio+1);


        return administradorRepo.save(administrador);
    }
}
