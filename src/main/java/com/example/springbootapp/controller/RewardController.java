package com.example.springbootapp.controller;

import com.example.springbootapp.domain.Reward;
import com.example.springbootapp.service.RewardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/rewards", produces = MediaType.APPLICATION_JSON_VALUE)
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @PostMapping
    public ResponseEntity<Reward> saveReward(@Valid @RequestBody Reward reward) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rewardService.saveReward(reward));
    }

    @PostMapping("/list")
    public ResponseEntity<List<Reward>> saveAllRewards(@Valid @RequestBody List<Reward> rewards) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rewardService.saveAllRewards(rewards));
    }

    @PostMapping("/{reward_id}/author/{author_id}")
    public ResponseEntity<Reward> addAuthorToReward(@PathVariable Integer reward_id, @PathVariable Integer author_id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rewardService.addAuthorToReward(author_id, reward_id));
    }

    @PostMapping("/{reward_id}/book/{book_id}")
    public ResponseEntity<Reward> addBookToReward(@PathVariable Integer reward_id, @PathVariable Integer book_id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rewardService.addBookToReward(book_id, reward_id));
    }

    @PostMapping("/{reward_id}/publisher/{publisher_id}")
    public ResponseEntity<Reward> addPublisherToReward(@PathVariable Integer reward_id, @PathVariable Integer publisher_id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rewardService.addPublisherToReward(publisher_id, reward_id));
    }

    @GetMapping
    public ResponseEntity<List<Reward>> getAllRewards() {
        return ResponseEntity.status(HttpStatus.OK).body(rewardService.getAllRewards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reward> getRewardById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(rewardService.getRewardById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reward> updateReward(@PathVariable("id") Integer id, @Valid @RequestBody Reward reward) {
        return ResponseEntity.status(HttpStatus.OK).body(rewardService.updateReward(id, reward));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReward(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(rewardService.deleteReward(id));

    }

}
