/**
 * 
 */
package hr.srce.isvu.restpreglednik.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Controller
public class LoginController {
   @GetMapping( "/login" )
   public String login() {
      return "login";
   }

}
