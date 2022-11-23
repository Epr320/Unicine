package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cliente extends Persona implements Serializable {
    @ElementCollection
    private List<String> telefono;

    @Column(nullable = true)
    private String ruta;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;

    public Cliente(String cedula, String nombre, String email, String password) {
    super(cedula,nombre,email,password);
    }
}
