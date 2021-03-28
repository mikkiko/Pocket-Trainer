package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.UserDTO;
import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.repository.UserRepository;
import com.github.mikkiko.pockettrainer.util.EntityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Unit testing for {@link UserService}.
 */
@ActiveProfiles("test")
@SpringBootTest
class UserServiceTest {

    @MockBean
    private UserRepository repo;
    @Autowired
    private UserService userService;
    @Autowired
    private EntityMapper mapper;

    @Test
    public void shouldProbablyGetUser(){
        User givenUser = new User().setEmail("@mail.com").setPassword("1234");
        given(repo.findById("@mail.com"))
                .willReturn(Optional.of(givenUser));

        User user = userService.getUser("@mail.com").orElse(null);
        assertThat(user).isEqualTo(givenUser);
    }

    @Test
    public void shouldProbablyGetUserDto() {
        User givenUser = new User()
                .setEmail("@mail.com")
                .setPassword("1234")
                .setName("name")
                .setTrainings(Arrays.asList(new Training()));
        given(repo.findById("@mail.com")).willReturn(Optional.ofNullable(givenUser));

        UserDTO dto = userService.getUserDTO("@mail.com");
        assertThat(mapper.fromUserDtoToEntity(dto).setPassword("1234")).isEqualTo(givenUser);
    }

    @Test
    public void shouldUpdateUserTrainings() {
        Training a1 = new Training().setId(1).setTrainingInfo(new ArrayList<>());
        Training a2 = new Training().setId(2).setTrainingInfo(new ArrayList<>());
        User givenUser = new User()
                .setEmail("@mail.com")
                .setPassword("1234")
                .setTrainings(new ArrayList<>(Arrays.asList(a1)));

        given(repo.findById("@mail.com")).willReturn(Optional.of(givenUser));

        userService.updateUserTrainings("@mail.com", mapper.fromEntityToTrainingDto(a2));

        givenUser.setTrainings(new ArrayList<>(Arrays.asList(a1, a2)));
        verify(repo).save(givenUser);
    }

    @Test
    public void shouldUpdatePassword() {
        User givenUser = new User().setEmail("@mail.com").setPassword("1234");
        given(repo.existsById("@mail.com")).willReturn(true);
        given(repo.getOne("@mail.com")).willReturn(givenUser);

        userService.updatePassword("@mail.com", "4321");
        User expectedUser = new User().setEmail("@mail.com").setPassword("4321");

        verify(repo).save(expectedUser);
    }
}
