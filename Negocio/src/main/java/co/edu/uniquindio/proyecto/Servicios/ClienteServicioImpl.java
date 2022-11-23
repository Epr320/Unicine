package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.ClienteServicio;
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
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    ClienteRepo clienteRepo;

    @Autowired
    AdministradorRepo administradorRepo;

    @Autowired
    AdministradorCiudadRepo administradorCiudadRepo;

    @Autowired
    EmailService emailService;

    @Override
    public Cliente login(String email, String password) throws Exception {
        return clienteRepo.findByEmailAndPassword(email,password).orElseThrow(()-> new Exception("Datos Incorrectos"));
    }

    @Override
    public Cliente registrarCliente(String cedula, String nombre, String email, String password, List<String> telefonos, String ruta) throws Exception {

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
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setCedula(cedula);
        cliente.setEmail(email);
        cliente.setPassword(password);
        cliente.setTelefono(telefonos);
        cliente.setRuta(ruta);
        return clienteRepo.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(String cedula, String nombre, String email, String password, List<String> telefonos, String ruta) throws Exception {
        Optional<Cliente> buscar = clienteRepo.findById(cedula);

        if (buscar.isEmpty()){
            throw new Exception("El cliente no existe");
        } else {
            buscar = clienteRepo.findByEmail(email);

            if (buscar.isPresent()){
                if (buscar.get().equals(email) == true) {
                    throw new Exception("El email del cliente es el mismo");
                } else {
                    throw new Exception("El email indicado ya esta en USO");
                }
            }
        }

        Cliente clienteActualizar = clienteRepo.getById(cedula);

        clienteActualizar.setNombre(nombre);
        clienteActualizar.setEmail(email);
        clienteActualizar.setPassword(password);
        clienteActualizar.setTelefono(telefonos);

        return clienteRepo.save(clienteActualizar);
    }

    @Override
    public void actualizarTelefonos(String cedula, List<String> telefonos) throws Exception {
        if(clienteRepo.findById(cedula).isPresent()){
            if(!telefonos.isEmpty()){
                Cliente aux = clienteRepo.getById(cedula);
                aux.setTelefono(telefonos);
                clienteRepo.save(aux);
            } else{
                throw new Exception("El listado de numeros a actualizar esta vacio.");
            }
        } else {
            throw new Exception("No existe la cedula indicada en la base de datos.");
        }
    }

    @Override
    public boolean eliminarClientePorCedula(String cedula) throws Exception {
        if (clienteRepo.findById(cedula).isPresent()){
            clienteRepo.deleteById(cedula);
        }else{
            throw new Exception("No existe un cliente registrado con esa cedula");
        }

        if (clienteRepo.existsById(cedula)){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public Cliente buscarClientePorCedula(String cedula) throws Exception {
        Optional<Cliente> cliente = clienteRepo.findById(cedula);
        if(cliente.isPresent()) {
            return cliente.get();
        } else {
            throw new Exception("No existe un cliente registrado con esa cedula");
        }
    }

    @Override
    public List<Cliente> listar() throws Exception {
        return clienteRepo.findAll();
    }

    @Override
    public boolean recuperarPasswordUsandoCorreoElectronico(String email) throws Exception {
        if(clienteRepo.findByEmail(email).isEmpty()) {
            throw new Exception("Este email no esta relacionado a algun cliente registrado en el sistema.");
        } else {
            String password = clienteRepo.recuperarPasswordConEmail(email);
            return emailService.enviarEmail("Recuperar contrasenia", "Su contrasenia es: " + password, email);

        }
    }

}
