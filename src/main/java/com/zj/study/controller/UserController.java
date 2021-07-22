package com.zj.study.controller;

import com.zj.study.entity.User;
import com.zj.study.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ZhaoJiu
 * @data: 2021/7/22
 * @desc: r2dbc 操作mysql CRUD
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    PersonRepository repository;

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PutMapping("/update")
    public Mono<ResponseEntity<String>> update(@RequestBody User user){
        return repository.findById(user.getId())
                .flatMap(u -> repository.save(user)
                        .then(Mono.just(new ResponseEntity<>("修改成功",HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>("用户未找到",HttpStatus.NOT_FOUND));
    }

    /**
     * 根据id查询
     * @param id 用户id
     * @return Mono
     */
    @GetMapping("{id}")
    public Mono<User> findById(@PathVariable String id){
        return repository.findById(id);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("save")
    public Mono<User> save(@RequestBody User user){
        return repository.save(user);
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/list")
    public Flux<User> findAll() {
        return repository.findAll();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public Mono<Void> delete(@PathVariable String id){
        return repository.deleteById(id);
    }

}
