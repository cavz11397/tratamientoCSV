package com.example.demo.inter;

import com.example.demo.model.Player;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlayerReactiveRepository extends ReactiveCrudRepository<Player,String> {
}
