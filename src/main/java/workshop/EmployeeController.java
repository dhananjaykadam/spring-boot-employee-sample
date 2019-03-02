package workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    Employee addNewUser(@RequestBody Employee user) {
        return userRepository.save(user);
    }

    @PutMapping(path = "/update/{id}") // Map ONLY GET Requests
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Integer id, @RequestBody Employee user) {
        user.setId(id);
        userRepository.save(user);
    }

    @GetMapping(path = "/list")
    public Iterable<Employee> getAllUsers() {
        return userRepository.findAll();
    }
}
