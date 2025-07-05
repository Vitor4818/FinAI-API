package com.finai.Controller;

import com.finai.DTOs.UpdateUserDTO;
import com.finai.DTOs.UserRequestDTO;
import com.finai.DTOs.UserResponseDTO;
import com.finai.Model.User;
import com.finai.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/users")
public class UserController {



    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> getAllUsers(@PageableDefault (size = 5, sort = "id", direction = Sort.Direction.ASC)Pageable page){
        return ResponseEntity.ok(userService.getAllUser(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserBydId(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> postUser(@RequestBody  UserRequestDTO dto){
        User savedUser = userService.postUser(dto);
        return ResponseEntity.created(URI.create("/users/" + savedUser.getId())).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserDTO> putUser(@PathVariable Long id, @RequestBody  UpdateUserDTO dto){
        userService.putUser(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
