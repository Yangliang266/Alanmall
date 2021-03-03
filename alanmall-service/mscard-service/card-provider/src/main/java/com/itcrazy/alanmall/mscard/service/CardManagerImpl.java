package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.manager.CardManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CardManagerImpl implements CardManager{

	@Override
	public List<Integer> getPageList() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		return list;
	}

}
