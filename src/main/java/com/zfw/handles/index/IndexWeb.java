package com.zfw.handles.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping
public class IndexWeb {
	@RequestMapping({"/index.*","/index"})
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
}
