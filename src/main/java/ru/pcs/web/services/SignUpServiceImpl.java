package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.pcs.web.forms.SignUpForm;
import ru.pcs.web.models.User;
import ru.pcs.web.repositories.UsersRepository;

@RequiredArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    @Override
    public void signUpUser(SignUpForm form) {
        User user = User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .role(User.Role.USER)
                .state(User.State.NOT_CONFIRMED)
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .build();

        usersRepository.save(user);
    }
}
