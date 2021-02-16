package org.zerock.controller;

import java.util.Locale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/daumeditor/*")
public class DaumEditorController {
	
	private static final Logger logger = LoggerFactory.getLogger(DaumEditorController.class);
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write(Locale locale, Model model) {
		logger.info("write called............");
		return "daumeditor/write";
	}
	
	@RequestMapping(value = "editor_template", method = RequestMethod.GET)
	public String editor_template(Locale locale, Model model) {
		logger.info("editor_template called............");
		
		return "daumeditor/editor_template";
	}
	

}
