import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import freemarker.template.*;
import lista.Estudiante;

public class Main {

    public static void main(String[] args) {

        staticFiles.location("/templates");

        final Configuration configuration = new Configuration(new Version(2,3,0));
        configuration.setClassForTemplateLoading(Main.class, "/");


        EstudianteService estudianteService = new EstudianteService();


        estudianteService.insert(new Estudiante(20140324, "Regis", "baez", "8295101896"));
        estudianteService.insert(new Estudiante(20141565, "juan", "perez", "8095815876"));
        estudianteService.insert(new Estudiante(20200101, "jose", "Ramos", "8099048521"));

        get("/", (request, response) -> {
            response.redirect("/home");
            return null;
        });

        get("/home", (request, response) -> {
            Template homeTemplate = configuration.getTemplate("templates/home.ftl");
            StringWriter stringWriter = new StringWriter();

            Map<String, Object> params = new HashMap<>();
            params.put("title", "P2 de Programacion Web");
            params.put("header", "Estudiantes:");
            params.put("insertEstudiante", "Insertar un estudiante");
            params.put("lista", estudianteService.getAll());
            params.put("tamano", estudianteService.getAll().size());

            homeTemplate.process(params, stringWriter);
            return stringWriter;
        });

        get("/insert", (request, response) -> {
            return configuration.getTemplate("templates/insertEstudiante.ftl");
        });

        post("/insertL", (request, response) -> {
            StringWriter stringWriter = new StringWriter();
            try{
                String matricula = request.queryParams("matricula");
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");
                Estudiante e = new Estudiante(Integer.parseInt(matricula), nombre, apellido, telefono);
                estudianteService.insert(e);
                response.redirect("/");
            }catch (Exception e){
                e.printStackTrace();
                response.redirect("/insert");
            }
            return stringWriter;
        });

        get("/deletefromlist/:matricula", (request, response) -> {
            StringWriter stringWriter = new StringWriter();
            int matricula = Integer.parseInt(request.params("matricula"));

            estudianteService.delete(estudianteService.getByMatricula(matricula));
            response.redirect("/");
            return stringWriter;
        });

        get("/update/:matricula", (request, response) -> {
            Template result = configuration.getTemplate("templates/updateEstudiante.ftl");
            StringWriter stringWriter = new StringWriter();

            int matricula = Integer.parseInt(request.params("matricula"));

            Map<String, Object> params = new HashMap<>();
            params.put("actual", estudianteService.getByMatricula(matricula)!=null?estudianteService.getByMatricula(matricula):new Estudiante());

            result.process(params,stringWriter);
            return stringWriter;
        });

        post("/updateL", (request, response) -> {
            StringWriter stringWriter = new StringWriter();

            try {
                int matricula = Integer.parseInt(request.queryParams("matricula"));
                Estudiante e = estudianteService.getByMatricula(matricula);

                e.setNombre(request.queryMap().get("nombre").value());
                e.setApellido(request.queryMap().get("apellido").value());
                e.setTelefono(request.queryMap().get("telefono").value());

                estudianteService.update(e);
                response.redirect("/home");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("lista.Estudiante no encontrado");
                response.redirect("/");
            }

            return stringWriter;
        });

        get("/ver/:matricula", (request, response) -> {
            Template result = configuration.getTemplate("templates/checkEstudiante.ftl");
            StringWriter stringWriter = new StringWriter();

            int matricula = Integer.parseInt(request.params("matricula"));
            Estudiante e = estudianteService.getByMatricula(matricula);
            if(e!=null){
                Map<String, Object> params = new HashMap<>();
                params.put("actual", estudianteService.getByMatricula(matricula)!=null?estudianteService.getByMatricula(matricula):new Estudiante());

                result.process(params, stringWriter);
                return stringWriter;
            }
            else {
                return stringWriter;
            }
        });


    }

}
