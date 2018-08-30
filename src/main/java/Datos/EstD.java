package Datos;

import lista.Estudiante;

import java.util.List;

public interface EstD {
    void insert(Estudiante e);

    void update(Estudiante e);

    void delete(Estudiante e);

    List<Estudiante> getAll();

    Estudiante getByMatricula(int matricula);
}
