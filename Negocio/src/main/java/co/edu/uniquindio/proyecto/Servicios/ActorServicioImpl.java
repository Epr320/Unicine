package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Interfaces.ActorServicio;
import co.edu.uniquindio.proyecto.Repositorios.ActorRepo;
import co.edu.uniquindio.proyecto.entidades.Actor;
import org.springframework.stereotype.Service;

@Service
public class ActorServicioImpl implements ActorServicio {
    ActorRepo actorRepo;

    @Override
    public Actor agregarActor(String nombre) throws Exception {
        Actor actor = new Actor();
        actor.setNombre(nombre);
        return actorRepo.save(actor);
    }
    
}
