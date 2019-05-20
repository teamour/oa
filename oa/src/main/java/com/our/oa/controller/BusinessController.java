package com.our.oa.controller;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.Page;
import com.our.oa.dto.GridDTO;
import com.our.oa.dto.list.BusinessManageListDTO;
import com.our.oa.dto.list.BusinessManageListQueryDTO;
import com.our.oa.service.BusinessService;
import com.our.oa.utils.PageInfoToGridDTOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/businessManage")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping(value = "/list")
    public ModelAndView toListPage(ModelAndView modelAndView) {
        modelAndView.setViewName("businessManage/businessManageList");
        return modelAndView;
    }

    @PostMapping(value = "/list")
    public GridDTO<BusinessManageListDTO> listData(HttpServletRequest request, 
        BusinessManageListQueryDTO bussManageQueryDTO) {
        Page<BusinessManageListDTO> queryList = businessService.getQueryList(bussManageQueryDTO);
        return PageInfoToGridDTOUtils.getGridDataResult(queryList);
    }

    @GetMapping(value = {"","/"})
    public ModelAndView toAddPage(ModelAndView modelAndView){
        modelAndView.setViewName("businessManage/businessManageAdd");
        return modelAndView;
    }


     

}