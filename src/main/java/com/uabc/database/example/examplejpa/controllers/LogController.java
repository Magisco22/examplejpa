package com.uabc.database.example.examplejpa.controllers;


import com.uabc.database.example.examplejpa.constant.ViewConstant;
import com.uabc.database.example.examplejpa.model.LogModel;
import com.uabc.database.example.examplejpa.services.LogService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/logs")
public class LogController {

    @Autowired
    @Qualifier("logServiceImpl")
    private LogService logService;



    private static final Log log = LogFactory.getLog(LogController.class);

    @GetMapping("/cancel")
    public String cancel(){
        return "redirect:/logs/showContacts";
    }

    @GetMapping("/logForm")
    public String redirectContactForm(Model model,
                                      @RequestParam(name = "id", required = false) int id){
        LogModel logModel = new LogModel();
        if(id != 0){
            logModel = logService.findContactByIdModel(id);
        }
        model.addAttribute("logModel", logModel);
        return ViewConstant.LOG_FORM;
    }

    @PostMapping("/addcontact")
    public String addContact(@ModelAttribute(name = "logModel")LogModel logModel, Model model) throws Exception{
        log.info("Method: addContact() -- Params: "+ logModel.toString());
        if(logService.addContact(logModel) != null){
            model.addAttribute("result", 1);//esto es para que se muestre un mensaje de que se agregó éxitosamente
        }else{
            model.addAttribute("result", 0);
        }
        return "redirect:/logs/showContacts";
    }

    @GetMapping("/showContacts")
    public ModelAndView showContacts(){
        ModelAndView mav = new ModelAndView(ViewConstant.LOGS);
        mav.addObject("logs", logService.listAllContacts());
        return mav;
    }

    @GetMapping("/removeContact")
    public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id){
        logService.removeContact(id);
        return showContacts();
    }


}