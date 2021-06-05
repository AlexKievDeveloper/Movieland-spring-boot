package com.hlushkov.movieland.repositiry;

import com.hlushkov.movieland.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
