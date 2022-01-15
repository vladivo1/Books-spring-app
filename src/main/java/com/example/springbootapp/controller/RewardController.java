package com.example.springbootapp.controller;

import com.example.springbootapp.domain.Reward;
import com.example.springbootapp.repository.RewardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RewardController {

    private final RewardRepository rewardRepository;
    public RewardController(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }


    @PostMapping("/reward")
    @ResponseStatus(HttpStatus.CREATED)
    public Reward saveReward(@RequestBody Reward reward) {
        return rewardRepository.save(reward);
    }

    @GetMapping("/rewards")
    @ResponseStatus(HttpStatus.OK)
    public List<Reward> getAllRewards() {
        return rewardRepository.findAll();
    }

    @GetMapping("/reward/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Reward getRewardById(@PathVariable Integer id) {
        Reward reward = rewardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reward with id" + id + "not found"));
        return reward;
    }

    @PutMapping("/reward/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Reward updateReward(@PathVariable("id") Integer id, @RequestBody Reward reward) {

        return rewardRepository.findById(id)
                .map (entity -> {
                    entity.setTitle(reward.getTitle());
                    entity.setYear(reward.getYear());
                    return rewardRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Reward not found with id = " + id));
    }

    @DeleteMapping("/reward/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReward(@PathVariable Integer id) {
        Reward reward = rewardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reward with id" + id + "not found"));
        rewardRepository.delete(reward);
    }

    @DeleteMapping("/rewards")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllAuthors(){
        rewardRepository.deleteAll();
    }

}
