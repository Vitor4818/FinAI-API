package com.finai.Service;


import com.finai.DTOs.UpdateUserDTO;
import com.finai.DTOs.UserResponseDTO;
import com.finai.DTOs.UserRequestDTO;
import com.finai.Exception.DataConflictException;
import com.finai.Exception.ResourceNotFoundException;
import com.finai.Model.User;
import com.finai.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Retorna todos os usuarios cadastrados
    public Page<UserResponseDTO> getAllUser (Pageable page){
        return userRepository.findAll(page).map(UserResponseDTO::new);
    }

    //Retorna usuario por ID
    public UserResponseDTO getUserById(Long id){
        return userRepository.findById(id).map(UserResponseDTO::new).orElseThrow(()-> new ResourceNotFoundException("Usuario não encontrado"));
    }

    //Cadastra usuario
    @Transactional
    public User postUser(UserRequestDTO userDto) {
        boolean exist = userRepository.existsByEmail(userDto.email());
        if (exist){
            throw new DataConflictException("Esse e-mail já está sendo usado por outro usuário");
        }
        User user = new User(userDto);
        return userRepository.save(user);
    }

    //Atualiza um usuario
    @Transactional
    public void putUser(Long id, UpdateUserDTO dto) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuario não encontrado"));
        if (userRepository.existsByEmailAndIdNot(dto.email(), id)){
            throw new DataConflictException("Já existe um usuario com esse email.");
        }
        user.update(dto);
    }

    @Transactional
    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuario não encontrado"));
        userRepository.delete(user);
    }
}
