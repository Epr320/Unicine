package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.Servicios.ActorServicioImpl;
import co.edu.uniquindio.proyecto.entidades.Actor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ActorServicioTest {
    @Autowired
    ActorServicioImpl actorServicio;

    @Test
    public void agregarActor(){
        try {
            Actor actor=actorServicio.agregarActor("Oscar Ruiz");
            Assert.assertNotNull(actor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
