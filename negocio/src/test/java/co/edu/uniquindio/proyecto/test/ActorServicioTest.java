package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.Interfaces.ActorServicio;
import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Actor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = {NegocioApplication.class})
@Transactional
public class ActorServicioTest {
    @Autowired
    private ActorServicio actorServicio;

    @Test
    public void agregarActor(){
        try {
            Actor actor=actorServicio.agregarActor("Oscar Ruiz");
            Assertions.assertNotNull(actor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
