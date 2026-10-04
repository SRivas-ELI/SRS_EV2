package entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Enfermera {
	private int idEnfermera, dni;
	private String nombres,apellidos,email,telefono;
	private LocalDate fechaNacimiento,fechaContratacion;
	private Categoria categoria;
}
