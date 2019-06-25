package com.service;

import java.util.List;

import com.entity.Manager;

public interface ManagerService {

	List<Manager> findByName(String mananame,String password);

}
