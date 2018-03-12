package example.demo.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class Controller {

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi() {
		return "Hello, Welcome";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/secured/hello", method = RequestMethod.GET)
	public String hello() {
		return "Hello, Secured Welcome";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/secured/msg", method = RequestMethod.GET)
	public String msg() {
		return "Hello, Secured 2 Nd Welcome";
	}
}
