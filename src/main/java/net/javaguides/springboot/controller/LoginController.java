package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Login;
import net.javaguides.springboot.model.VerificationCode;
import net.javaguides.springboot.repository.LoginRepository;
import net.javaguides.springboot.repository.VerificationCodeRepository;
import net.javaguides.springboot.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Autowired
    private VerificationCodeRepository verificationCodeRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("login", new Login());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("login") Login login, RedirectAttributes redirectAttributes) {
        login.setPassword(passwordEncoder.encode(login.getPassword()));
        login.setStatus(0);
        loginRepository.save(login);

        String code = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        VerificationCode verificationCode = new VerificationCode(code, login);
        verificationCodeRepository.save(verificationCode);

        emailService.sendVerificationCode(login.getEmail(), code);
        
        redirectAttributes.addAttribute("email", login.getEmail());
        return "redirect:/verification";
    }

    @GetMapping("/verification")
    public String showVerificationForm(@RequestParam("email") String email, Model model) {
        model.addAttribute("email", email);
        return "verificacion";
    }

    @PostMapping("/verification")
    public String verifyCode(@RequestParam("email") String email, @RequestParam("verification") String code, RedirectAttributes redirectAttributes) {
        Login user = loginRepository.findByEmail(email);
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "Usuario no encontrado.");
            return "redirect:/verification?email=" + email;
        }

        VerificationCode verificationCode = verificationCodeRepository.findByLogin_Id(user.getId());

        if (verificationCode != null && verificationCode.getCode().equals(code)) {
            user.setStatus(1);
            loginRepository.save(user);
            verificationCodeRepository.delete(verificationCode);

            redirectAttributes.addFlashAttribute("success", "¡Tu cuenta ha sido verificada! Ahora puedes iniciar sesión.");
            return "redirect:/login";
        }

        redirectAttributes.addFlashAttribute("error", "Código de verificación incorrecto. Inténtalo de nuevo.");
        return "redirect:/verification?email=" + email;
    }
}
