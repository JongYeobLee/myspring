package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController5 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController5.class);
	
	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON() {
		ProductVO vo = new ProductVO("»ùÇÃ»óÇ°", 30000);
		
		return vo;
	}

}
