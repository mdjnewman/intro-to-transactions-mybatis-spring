package me.mdjnewman.twu.samples.todoserver.controllers;

import me.mdjnewman.twu.samples.todoserver.model.TodoItem;
import me.mdjnewman.twu.samples.todoserver.services.TodoItemService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/")
public class HomeController {

    @Resource
    private TodoItemService itemService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
        model.addAttribute("items", itemService.findAll());
        model.addAttribute("newItem", new TodoItem().setDueDate(Calendar.getInstance().getTime()));
		return "home";
	}

    @RequestMapping(method = RequestMethod.POST)
    public String newItem(@ModelAttribute("newItem") TodoItem newItem,
                          BindingResult result){
        itemService.insert(newItem);
        return "redirect:/";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }
}