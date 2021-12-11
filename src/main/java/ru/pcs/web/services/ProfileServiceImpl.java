package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pcs.web.forms.UserForm;
import ru.pcs.web.repositories.UsersRepository;

@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService{

    private final UsersRepository usersRepository;

    @Override
    public UserForm getUser(Integer currentUserId) {
        return UserForm.from(usersRepository.getById(currentUserId));
    }

}
