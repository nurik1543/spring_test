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


    @RequestMapping("/add")
    public String showform(Model m){
        m.addAttribute("command", new RoutineTemplate());
        return "add";
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("emp") RoutineTemplate emp){
        dao.insert(emp);
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String viewemp(Model m){
        List<RoutineTemplate> list = dao.getAllElemtents();
        m.addAttribute("list",list);
        return "list";
    }

    @RequestMapping(value="/edit/{id}")
    public String edit(@PathVariable int id, Model m){
        RoutineTemplate emp=dao.getElementById(id);
        m.addAttribute("command",emp);
        return "edit";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("emp") RoutineTemplate emp){
        dao.update(emp);
        return "redirect:/list";
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        dao.deleteById(id);
        return "redirect:/list";
    }

}

