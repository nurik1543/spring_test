package nursultan.taalaibekov.spring_test.controllers;


import nursultan.taalaibekov.spring_test.Entities.RoutineTemplate;
import nursultan.taalaibekov.spring_test.interfaces.IDAOTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TemplateCrud {

    @Autowired
    private IDAOTemplate dao;

    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */
    @RequestMapping("/empform")
    public String showform(Model m){
        m.addAttribute("command", new RoutineTemplate());
        return "empform";
    }
    /*It saves object into database. The @ModelAttribute puts request data
     *  into model object. You need to mention RequestMethod.POST method
     *  because default request is GET*/
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("emp") RoutineTemplate emp){
        dao.insert(emp);
        return "redirect:/viewemp";//will redirect to viewemp request mapping
    }
    /* It provides list of employees in model object */
    @RequestMapping("/viewemp")
    public String viewemp(Model m){
        List<RoutineTemplate> list = dao.getAllElemtents();
        m.addAttribute("list",list);
        return "viewemp";
    }
    /* It displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.*/
    @RequestMapping(value="/editemp/{id}")
    public String edit(@PathVariable int id, Model m){
        RoutineTemplate emp=dao.getElementById(id);
        m.addAttribute("command",emp);
        return "empeditform";
    }
    /* It updates model object. */
    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("emp") RoutineTemplate emp){
        dao.update(emp);
        return "redirect:/viewemp";
    }
    /* It deletes record for the given id in URL and redirects to /viewemp */
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        dao.deleteById(id);
        return "redirect:/viewemp";
    }

}

