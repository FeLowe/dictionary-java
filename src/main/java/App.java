import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;


public class App {
  public static void main(String[] args) {

    // //HEROKU//
    // ProcessBuilder process = new ProcessBuilder();
    // Integer port;
    // if (process.environment().get("PORT") != null) {
    //   port = Integer.parseInt(process.environment().get("PORT"));
    // } else {
    //   port = 4567;
    // }
    //
    // setPort(port);


    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    // // GET - displays form
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  get("/words/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/word-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("template", "templates/allwords.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //POST - processes form
    post("/words", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String userWord = request.queryParams("word");
      Word newWord = new Word(userWord);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // // GET - displays form
  }
}
