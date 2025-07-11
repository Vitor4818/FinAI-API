package com.finai.Service;

import com.finai.DTOs.Goal.GoalRequestDTO;
import com.finai.DTOs.Goal.GoalResponseDTO;
import com.finai.DTOs.Goal.UpdateGoalDTO;
import com.finai.Exception.ResourceNotFoundException;
import com.finai.Model.Goal;
import com.finai.Model.User;
import com.finai.Repository.GoalRepository;
import com.finai.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

@Autowired
    GoalRepository goalRepository;
@Autowired
    UserRepository userRepository;


//retorna todos os objetivos
    public Page<GoalResponseDTO> getGoal(Pageable page){
        return goalRepository.findAll(page).map(GoalResponseDTO::new);
    }

    //Retorna ojetivo por id
    public GoalResponseDTO getGoalById(Long id){
        return goalRepository.findById(id).map(GoalResponseDTO::new).orElseThrow(()-> new ResourceNotFoundException("Meta não encontrada"));
    }

    //Cadastra nova meta
    public void postGoal (GoalRequestDTO dto){
        Goal goal = new Goal(dto);
        goalRepository.save(goal);
        //Implementar lógica para descontar o valor inicial da meta do saldo do usuario ao criar
    }

    public void putGoal(Long id, UpdateGoalDTO dto){
        User user = userRepository.findById(dto.userId().getId()).orElseThrow(()-> new ResourceNotFoundException("Usuario não encontrado"));
        Goal goal = goalRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Meta não encontrada"));
        goal.update(dto);
        userRepository.save(user);
        goalRepository.save(goal);
        //Implementar lógica para descontar o valor da atualização do saldo do usuario
    }

    public void deleteGoal(Long id){
        Goal goal = goalRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Meta não encontrada"));
        goalRepository.delete(goal);
    }
}
