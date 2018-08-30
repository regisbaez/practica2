package Datos;

import lista.Estudiante;
import BD.EBD;

import java.util.List;

public class EstDl implements EstD {


    @Override
    public void insert(Estudiante e) {
        EBD.estudianteList.add(e);
    }

    @Override
    public void update(Estudiante e) {
        for (Estudiante actual: getAll()) {
            if(actual.getMatricula()==e.getMatricula()){
                actual.setNombre(e.getNombre());
                actual.setApellido(e.getApellido());
                actual.setTelefono(e.getTelefono());
            }
        }
    }

    @Override
    public void delete(Estudiante e) {
        EBD.estudianteList.remove(e);
    }

    @Override
    public List<Estudiante> getAll() {
        return EBD.estudianteList;
    }

    @Override
    public Estudiante getByMatricula(int matricula) {
        for (Estudiante estudiante: getAll()) {
            if(estudiante.getMatricula()==matricula){
                return estudiante;
            }
        }
        return null;
    }
}
