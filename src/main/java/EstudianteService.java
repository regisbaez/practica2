import Datos.EstD;
import Datos.EstDl;
import lista.Estudiante;

import java.util.List;

public class EstudianteService implements EstD {
    private EstDl estudianteDAO;

    public EstudianteService() {
        estudianteDAO = new EstDl();
    }

    @Override
    public void insert(Estudiante e) {
        estudianteDAO.insert(e);
    }

    @Override
    public void update(Estudiante e) {
        estudianteDAO.update(e);
    }

    @Override
    public void delete(Estudiante e) {
        estudianteDAO.delete(e);
    }

    @Override
    public List<Estudiante> getAll() {
        return estudianteDAO.getAll();
    }

    @Override
    public Estudiante getByMatricula(int matricula) {
        return estudianteDAO.getByMatricula(matricula);
    }
}
