package com.example.pmster.repos;

import com.example.pmster.domain.Message;

import com.example.pmster.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;



public interface MessageRepo extends CrudRepository<Message, Long> {

    Page<Message> findAll(Pageable pageable);

    Page<Message> findByTag(String tag, Pageable pageable);

    Page<Message> findByAuthor(User user, Pageable pageable);
}
