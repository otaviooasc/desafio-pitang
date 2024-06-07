package com.carros.oasc.services;

import com.carros.oasc.dto.UserDTO;
import com.carros.oasc.dto.UserResponseDTO;
import com.carros.oasc.exceptions.UserException;
import com.carros.oasc.models.UserModel;
import com.carros.oasc.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserResponseDTO> listUsers() {
        List<UserModel> users = repository.findAll();

        return users.stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
    }

    public UserResponseDTO saveUser(UserDTO userDTO) throws Exception {
        UserModel userModel = new UserModel(userDTO);
        if (repository.existsByEmail(userModel.getEmail())) {
            throw new UserException("Email already exists");
        }

        if (repository.existsByLogin(userModel.getLogin())) {
            throw new UserException("Login already exists");
        }

        return new UserResponseDTO(repository.save(userModel));
    }

    public UserModel changeUser(String id, UserDTO userDTO) throws UserException {
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel);
        userModel.setId(id);
        var userFindById = repository.findById(id);
        if(!userModel.getEmail().equals(userFindById.get().getEmail())) {
            if (repository.existsByEmail(userModel.getEmail())) {
                throw new UserException("Email already exists");
            }
        }
        if(!userModel.getLogin().equals(userFindById.get().getEmail())) {
            if (repository.existsByLogin(userModel.getLogin())) {
                throw new UserException("Login already exists");
            }
        }
        return repository.save(userModel);
    }

    public UserModel findByLogin(String login) {
        return repository.findByLogin(login);
    }

    public Optional<UserModel> findById(String id) {
        return repository.findById(id);
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}
