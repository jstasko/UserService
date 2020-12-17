package sk.stasko.userService.type;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
@CrossOrigin(origins = "http://localhost:3000/")
@Api( tags = "Type")
public class TypeController {

    private final Logger logger = LoggerFactory.getLogger(TypeController.class);
    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping("/save")
    @ResponseBody
    private Type saveOrderType(@RequestBody Type type) {
        logger.trace("Saving order type");
        return this.typeService.save(type);
    }

    @GetMapping("/findAll")
    @ResponseBody
    private List<Type> findAll() {
        return this.typeService.findAll();
    }
}
