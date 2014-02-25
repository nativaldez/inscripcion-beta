package org.ticpy.tekoporu.inscripcion;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ticpy.tekoporu.inscripcion.domain.Alumno;
import org.ticpy.tekoporu.inscripcion.excepcion.CursoException;
import org.ticpy.tekoporu.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class CursoTest {
	@Inject
	private Curso curso;

	@Test
	public void matricularAlumnoConExito() {
		curso.vaciarCurso();
		Alumno alumno = new Alumno("Andres Gonzales");
		curso.matricular(alumno);
		Assert.assertTrue(curso.estaMatriculado(alumno));

	}

	@Test(expected = CursoException.class)
	public void errorMatricularAlumnoDuplicado() {
		curso.vaciarCurso();
		Alumno alumno = new Alumno("Andres Gonzales2");
		curso.matricular(alumno);
		curso.matricular(alumno);

	}

	@Test(expected = CursoException.class)
	public void errorMatricularCursoLleno() {
		curso.vaciarCurso();
		for (int i = 1; i <= 5; i++) {
			curso.matricular(new Alumno("Alumno " + i));
		}
		curso.matricular(new Alumno("Alumno 6"));

	}

}
