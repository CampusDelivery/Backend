package at.kaindorf.controller;

import at.kaindorf.models.User;
import at.kaindorf.service.user.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserServiceImp userServiceImp;


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        Optional<List<User>> users = userServiceImp.getAllUsers();
        return ResponseEntity.ok().body(users.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> user = userServiceImp.getUserByEmail(id);
        if(user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<User> postUser(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(userServiceImp.createUser(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable String id) {
        userServiceImp.deleteByEmail(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<User> delete(@RequestBody User user) {
        userServiceImp.delete(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        Optional<User> dbUser = userServiceImp.getUserByEmail(user.getEmail());
        if(dbUser.isPresent()) {
            if(dbUser.get().getPassword().equals(user.getPassword())) {
                return ResponseEntity.ok().body(dbUser.get());
            }
            return ResponseEntity.badRequest().build();   //400 bad request --> passwort stimmt nicht
        }
        return ResponseEntity.notFound().build();         //404 not found --> email existiert nicht
    }

}
