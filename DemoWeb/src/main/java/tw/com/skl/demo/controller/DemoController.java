package tw.com.skl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.skl.demo.model.entity.Demo;
import tw.com.skl.demo.model.service.DemoService;
import tw.com.skl.demo.model.service.impl.DemoServiceImpl;
import tw.com.skl.demo.model.service.impl.DemoServiceImpl2;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {

	@Autowired
	private DemoService demoService;

	// IoC
//	private DemoService demoService = new DemoServiceImpl();
//	private DemoService demoService = new DemoServiceImpl2();

	@GetMapping()
	public String list(Model model) {

		List<Demo> usrList = demoService.list();
		model.addAttribute("usrList", usrList);

		return "demo/list";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {

		Demo usrForAdd = new Demo();
		model.addAttribute("usrForAdd", usrForAdd);

		return "demo/add";
	}

	@PostMapping(value = "/add.do")
	public String addAction(@ModelAttribute(value = "usrForAdd") Demo usrForAdd) {

		demoService.add(usrForAdd);

		return "redirect:/demo";
	}

	@GetMapping(value = "/{account}/edit")
	public String edit(@PathVariable(value = "account") String account, Model model) {

		Demo usrForEdit = demoService.selectById(account);
		model.addAttribute("usrForEdit", usrForEdit);

		return "demo/edit";
	}

	@PostMapping(value = "/{account}/edit.do")
	public String editAction(@ModelAttribute(value = "usrForEdit") Demo usrForEdit) {

		demoService.edit(usrForEdit);
//		demoService.transactionDemo(usrForEdit);

		return "redirect:/demo";
	}

	@GetMapping(value = "/{account}/delete.do")
	public String deleteAction(@PathVariable(value = "account") String account) {

		demoService.delete(account);

		return "redirect:/demo";
	}

}
