package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.dto.UserDto;
import uz.pdp.repository.UserRepository;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    @GetMapping("/sign-in")
    public String login(){
        return "sign-in";
    }

    @GetMapping("/sign-up")
    public String signup(){
        return "cabinet";
    }

    @PostMapping("/sign-in")
    public String authenticate(@ModelAttribute UserDto userDto, Model model)
    {
        boolean admin = userRepository.isAdmin(userDto);
        if (admin)
            return "cabinet";
        else
            return "sign-in";
    }




}
