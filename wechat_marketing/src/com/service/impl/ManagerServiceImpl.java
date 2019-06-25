package com.service.impl;

import java.util.List;

import com.dao.ManagerDao;
import com.entity.Manager;
import com.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{

	private ManagerDao managerDao;
	
	
	public void setManagerDao(ManagerDao managerDao){
		this.managerDao = managerDao;
	}
	
	@Override
	public List<Manager> findByName(String mananame,String password) {
		// TODO Auto-generated method stub
		
		return managerDao.findByName(mananame,password);
	}

}


