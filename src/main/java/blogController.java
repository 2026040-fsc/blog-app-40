import org.springframework.stereotype.Controller;

@Controller
public class blogController {
    @GetMapping("/blog")
    public String blogs() {
        return ("/blog");
    }
    
}
