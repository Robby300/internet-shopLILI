package ru.pcs.web.services;

import ru.pcs.web.forms.UserForm;

public interface ProfileService {
    UserForm getUser(Integer currentUserId);
}
