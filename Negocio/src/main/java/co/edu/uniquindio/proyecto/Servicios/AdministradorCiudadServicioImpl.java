package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.AdministradorCiudadServicio;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorCiudadRepo;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorRepo;
import co.edu.uniquindio.proyecto.Repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.AdministradorCiudad;
import co.edu.uniquindio.proyecto.entidades.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdministradorCiudadServicioImpl implements AdministradorCiudadServicio {

    @Autowired
    ClienteRepo  clienteRepo;

    @Autowired
    AdministradorCiudadRepo administradorCiudadRepo;

    @Autowired
    AdministradorRepo administradorRepo;

    @Override
    public AdministradorCiudad login(String email, String password) throws Exception {
       return administradorCiudadRepo.findByEmailAndAndPassword(email,password).orElseThrow(() -> new Exception("Datos Incorrectos"));
    }

    @Override
    public AdministradorCiudad agregarAdministradorDeCiudad(String cedula, String nombre, String email, String password) throws Exception {
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

        AdministradorCiudad administradorHotel = new AdministradorCiudad(cedula, nombre, email, password, tamanio+1);
        return administradorCiudadRepo.save(administradorHotel);
    }

    @Override
    public AdministradorCiudad actualizarAdministradorDeCiudad(String cedula, String nombre, String email, String password, Integer codigo) throws Exception {

        Optional<AdministradorCiudad> buscar = administradorCiudadRepo.findById(cedula);

        if(buscar.isEmpty()){
            throw new Exception("El administrador no existe");
        }

        buscar.get().setNombre(nombre);
        buscar.get().setEmail(email);
        buscar.get().setPassword(password);
        buscar.get().setCodigo(codigo);

        return administradorCiudadRepo.save(buscar.get());
    }

    @Override
    public boolean eliminarAdministradorDeCiudadPorCedula(String cedula) throws Exception {
        if(administradorCiudadRepo.findById(cedula).isPresent()) {
            administradorCiudadRepo.deleteById(cedula);
        }else{
            throw new Exception("El administrador no existe");
        }

        if(administradorCiudadRepo.existsById(cedula)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public AdministradorCiudad buscarAdministradorDeCiudadPorCedula(String cedula) throws Exception {
        return administradorCiudadRepo.findById(cedula).orElseThrow(() -> new Exception("No existe un administrador registrado con esa cedula"));
    }

    @Override
    public AdministradorCiudad buscarAdministradorDeCiudadPorCodigo(Integer codigo) throws Exception {
        return administradorCiudadRepo.findByCodigo(codigo).orElseThrow(() -> new Exception("No existe un administrador registrado con ese codigo"));
    }

    @Override
    public AdministradorCiudad buscarAdministradorDeCiudadPorCiudad(Integer codigo) throws Exception {
        return administradorCiudadRepo.buscarPorCodigoDeCiudad(codigo).orElseThrow(() -> new Exception("No existe un ciuddad registradada con ese codigo"));
    }

    @Override
    public List<AdministradorCiudad> listar() {
        return administradorCiudadRepo.findAll();
    }
}
