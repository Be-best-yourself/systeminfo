package com.zfw.handles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class UserController extends AbstractController {
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
}
