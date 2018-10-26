package com.tarena.netctoss.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.netctoss.dao.CostDAO;
import com.tarena.netctoss.entity.Cost;
@Service("costService")
public class CostServiceImpl implements CostService{
	
	@Resource(name="costDAO")
	private CostDAO dao;
	
	public List<Cost> findCost() {
		List<Cost> cost = null;
		cost = dao.findAll();
		return cost;
	}
	
}
