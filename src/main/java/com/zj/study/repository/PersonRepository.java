package com.zj.study.repository;

import com.zj.study.entity.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

/**
 * @author ZhaoJiu
 * @since: 2021/7/22
 * @desc:
 */
public interface PersonRepository extends R2dbcRepository<User,String> {

}
