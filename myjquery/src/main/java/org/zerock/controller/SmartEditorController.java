package org.zerock.controller;

import java.util.Locale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/editor/*")
public class SmartEditorController {
	
	private static final Logger logger = LoggerFactory.getLogger(SmartEditorController.class);
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write(Locale locale, Model model) {
		logger.info("write called............");
		
		return "editor/write";
	}

}
