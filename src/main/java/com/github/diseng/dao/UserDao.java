package com.github.diseng.dao;

import com.github.diseng.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dengqinglin on 14-4-4.
 */
@Repository
public interface UserDao {
    public List<User> getAll();
    public void save(User user);
}
