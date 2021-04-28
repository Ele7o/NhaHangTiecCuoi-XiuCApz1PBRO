package com.nhahang.service.impl;

import com.nhahang.pojo.NghiepVu;
import com.nhahang.repository.NghiepVuRepository;
import com.nhahang.service.NghiepVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NghiepVuServiceImpl implements NghiepVuService {
    @Autowired
    private NghiepVuRepository nghiepVuRepository;
    @Override
    public List<NghiepVu> getNghiepVu(){
        return this.nghiepVuRepository.getNghiepVu();
    }

}