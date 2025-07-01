/**
 * 
 */
package egovframework.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author user
 *
 */
@Controller
public class HomeController {
	@GetMapping("/home.do")
	public String home() {
		return "home";
	
}
}
