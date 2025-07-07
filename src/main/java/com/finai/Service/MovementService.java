package com.finai.Service;


import com.finai.DTOs.movement.MovementRequestDTO;
import com.finai.DTOs.movement.MovementResponseDto;
import com.finai.DTOs.movement.UpdateMovementDTO;
import com.finai.Exception.ResourceNotFoundException;
import com.finai.Exception.insufficientBalance;
import com.finai.Model.*;
import com.finai.Repository.MovementRepository;
import com.finai.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovementService {

@Autowired
    MovementRepository movementRepository;

@Autowired
    UserRepository userRepository;


    //Retorna todas as transações
        public Page<MovementResponseDto> getAllMovements(Pageable page){
            return movementRepository.findAll(page).map(MovementResponseDto::new);
        }


    //Retorna as transações por id
    public MovementResponseDto getMovementById(Long id){
            return  movementRepository.findById(id).map(MovementResponseDto::new).orElseThrow(()-> new ResourceNotFoundException("Transação não encontrada"));
    }

    //Adiciona nova transação
    @Transactional
    public Movement postMovement(MovementRequestDTO dto){
            User user = userRepository.findById(dto.user().getId()).orElseThrow(()-> new ResourceNotFoundException("Usuario não encontrado"));
            //Retornando os Enums por ID
            PaymentMethod paymentMethod = PaymentMethod.fromId(dto.paymentMethodId());
            Category category = Category.fromId(dto.categoryId());
            MovementType movementType = MovementType.fromId(dto.movementTypeId());
            Recurring recurring = Recurring.fromId(dto.recurringId()); // 🚨 Valida aqui!

        if (!category.getMovementType().equals(movementType)) {
            throw new RuntimeException("Categoria não compatível com o tipo de movimento!");
        }

        //Verifica se tem saldo o suficiente para a despesa. OBS: Permite saldo negativo para o cartão de crédito
        if (dto.value()>user.getBalance() && paymentMethod != PaymentMethod.CREDIT_CARD) {
                throw new insufficientBalance("Saldo insuficiente!");
            }
            Movement transaction = new Movement(dto);
        if (movementType == MovementType.EXPENSE && paymentMethod != PaymentMethod.CREDIT_CARD){
            user.setBalance(user.getBalance() - dto.value());
        } else if (movementType == MovementType.INCOME){
            user.setBalance(user.getBalance() + dto.value());
        }
            userRepository.save(user);
            return movementRepository.save(transaction);
    }

    //Atualiza transação
    @Transactional
    public void putMovement(Long id, UpdateMovementDTO dto){
            User user = userRepository.findById(dto.user().getId()).orElseThrow(()-> new ResourceNotFoundException("Usuario não encontrado"));
            PaymentMethod paymentMethod = PaymentMethod.fromId(dto.paymentMethodId());
            MovementType movementType = MovementType.fromId(dto.movementTypeId());
            Movement movement = movementRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Transação não encontrada"));
            movement.update(dto);

            //FIX: Atualiza saldo do cliente
            if (movementType.equals(MovementType.EXPENSE)){
                user.setBalance(user.getBalance() +  );
            }
            movementRepository.save(movement);
    }

    //Deleta transação
    @Transactional
    public void deleteMovement(Long id){
            Movement movement = movementRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Transação não encontrada"));
            movementRepository.deleteById(id);
    }



}
