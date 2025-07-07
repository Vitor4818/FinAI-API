package com.finai.Controller;

import com.finai.DTOs.movement.MovementRequestDTO;
import com.finai.DTOs.movement.MovementResponseDto;
import com.finai.DTOs.movement.UpdateMovementDTO;
import com.finai.Model.Movement;
import com.finai.Repository.MovementRepository;
import com.finai.Service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/movements")
public class MovementController {

@Autowired
    MovementService movementService;

//Busca transação
@GetMapping
public ResponseEntity<Page<MovementResponseDto>> getAllMovements(@PageableDefault Pageable page){
    return ResponseEntity.ok(movementService.getAllMovements(page));
}

//busca transação por id
@GetMapping("/{id}")
    public ResponseEntity<MovementResponseDto> getMovementById(@PathVariable Long id){
    return ResponseEntity.ok(movementService.getMovementById(id));
}

//Cadastra uma transação
    @PostMapping
    public ResponseEntity<Void> postMovement(@RequestBody MovementRequestDTO dto){
    Movement savedMovement = movementService.postMovement(dto);
    return ResponseEntity.created(URI.create("/movements" + savedMovement.getId())).build();
    }

    // Atualiza transação
    @PutMapping("/{id}")
    public ResponseEntity<Void> putMovement(@PathVariable Long id, @RequestBody UpdateMovementDTO dto){
    movementService.putMovement(id, dto);
    return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovement(@PathVariable Long id){
    movementService.deleteMovement(id);
    return ResponseEntity.noContent().build();
    }




}
