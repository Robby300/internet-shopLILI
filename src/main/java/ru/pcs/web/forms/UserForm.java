package ru.pcs.web.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pcs.web.models.User;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserForm {

    private Integer id;
    private String email;
    private String firstName;
    private String lastName;

    public static UserForm from(User user) {
        return UserForm.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    public static List<UserForm> from(List<User> accounts) {
        return accounts.stream().map(UserForm::from).collect(Collectors.toList());
    }
}

