/**
 * 
 */
package egovframework.example.faq.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import egovframework.example.common.Criteria;
import lombok.extern.log4j.Log4j2;

/**
 * @author user
 *
 */
@Log4j2
@Controller
public class FaqController {
	@GetMapping("/faq/faq.do")
	public String name(@ModelAttribute Criteria criteria,
			Model model) {
		return "faq/faq_all";
	}
	
}
