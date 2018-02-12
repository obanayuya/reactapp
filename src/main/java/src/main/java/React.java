package src.main.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class React {

@RequestMapping("/")
public @ResponseBody String main() {


	return "Hellow works!!";

}

@RequestMapping("/index/**")
public String displayIndex() {

	System.out.println("react.java");
	return "index";
}


}