package dev.codeio.helloworld.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private final UserService  userService;
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    priavte final JwtUtil jwtUtil;

    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String,String> body){
        String email=body.get("email");
        String password=passwordEncoder.encode(body.get("password"));

        if(userRepository.findByEmail(email).isPresent()){
            return new ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        userService.createUser(User.builder().email(email).password(password).build());
        return new ResponseEntity<>(body:"Successfully registered", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String,String> body){
        String email=body.get("email");
        String password=body.get("password");

        var UserOptional=userRepository.findByEmail(email);
        if(UserOptional.isEmpty()){
            return new ResponseEntity<>(body:"User not regsitered",HttpStatus.UNAUTHORIZED);
        }
        User user=userOptional.get();
        if(!passwordEncoder.matches(password,user.getPassword())){
            return new ResponseEntity<>(body:"Invalid user",HttpStatus.UNAUTHORIZED);

        }
        String token=jwtUtil.generateToken(email);
        return ResponseEntity.ok(Map.of("Token",token));
    }
}
