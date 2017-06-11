package com.stock.app.services;

import com.stock.app.model.PatchOperation;
import com.stock.app.model.User;

import java.util.List;

/**
 * Created by vvicario on 30/05/2017.
 */
public interface UserService {

    User findUserById(Integer id);

    Integer createUser(User user);

    void updateUser(User user, Integer id);

    void updatePartialUser(List<PatchOperation> patchOperations, Integer id);

    void deleteUser(Integer id);

}
