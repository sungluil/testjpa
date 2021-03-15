package com.example.testjpa.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountRepository accountRepository;
    private final SignUpFormValidator signUpFormValidator;

    @InitBinder("signUpForm")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpFormValidator);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/sign-up")
    public String signUpForm(Model model) {
        model.addAttribute(new SignUpForm());
        return "account/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUpFormAction(@Valid SignUpForm signUpForm, Errors errors) {
        if (errors.hasErrors()) {
            return "account/sign-up";
        }
        Account newAccount = accountService.getSave(signUpForm);
        accountService.newAccountSetting(newAccount);
        accountService.sendMail(newAccount);
        accountService.autoLogin(newAccount);
        return "redirect:/";
    }

    @GetMapping("/email-check-token")
    public String emailCheck(String email, String token, Model model) {

        Account account = accountRepository.findByEmail(email);

        if(account == null) {
            model.addAttribute("error","존재하지 않는 이메일입니다.");
            return "account/email-check";
        }

        if(!account.getEmailCheckToken().equals(token)) {
            model.addAttribute("error","유효하지 않은 토큰입니다.");
            return "account/email-check";
        }

        accountService.completeSignUp(account);
        model.addAttribute("nickname",account.getNickname());
        model.addAttribute("count",accountRepository.count());
        return "account/email-check";
    }

    @GetMapping("/profile/{nickname}")
    public String profile(@PathVariable("nickname") String nickname, @CurrentUser Account account, Model model) {
        Account byNickname = accountRepository.findByNickname(nickname);
        if(nickname == null) {
            throw new IllegalArgumentException(nickname + "에 해당하는 유저가 존재하지 않습니다.");
        }

        model.addAttribute(byNickname);
        model.addAttribute("isOwner",byNickname.equals(account));

        return "account/profile";
    }


}
