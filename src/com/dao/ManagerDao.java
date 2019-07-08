package com.dao;

import java.util.List;

import com.entity.Manager;

public interface ManagerDao {

	List<Manager> findByName(String mananame,String password);

}
