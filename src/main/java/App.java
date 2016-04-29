import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {

    // //HEROKU//
    ProcessBuilder process = new ProcessBuilder();
    Integer port;
    if (process.environment().get("PORT") != null) {
      port = Integer.parseInt(process.environment().get("PORT"));
    } else {
      port = 4567;
    }

    setPort(port);


    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    // // GET - displays form
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    //POST - processes form
    post("/words", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String userWord = request.queryParams("word");
      Word newWord = new Word(userWord);
      request.session().attribute("word", newWord);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // // GET - displays form
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("word", request.session().attribute("word"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
