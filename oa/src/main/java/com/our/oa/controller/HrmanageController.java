package com.our.oa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.our.oa.entity.Company;
import com.our.oa.entity.Interviewer;
import com.our.oa.service.HrmanageService;
/**
 * hr manage
 * @author hk
 *
 */
@RestController
@RequestMapping(value="/hr")
public class HrmanageController {

	@Autowired
	private HrmanageService hrmanageServiceImpl;
	
	/**
	 * home page
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/hrIndex")
	public ModelAndView hrIndex(ModelAndView modelAndView) {
		modelAndView.setViewName("hr/hrIndex");
		List<Interviewer> interviewer = hrmanageServiceImpl.getInterviewerInfo();
		modelAndView.addObject("interviewer", interviewer);
		return modelAndView;
	}
	
	/**
	 * search
	 * @return
	 */
	@RequestMapping(value="/search")
	public ModelAndView search(ModelAndView modelAndView,String search,String interviewerName) {
		modelAndView.setViewName("hr/searchResult");
//		List<Interviewer> list = hrmanageServiceImpl.getSearchInfo(search);
		return modelAndView;
	}
	
	/**
	 * add info page show
	 * @return
	 */
	@RequestMapping(value="/addInfoShow")
	public ModelAndView addInfoShow(ModelAndView modelAndView) {
		modelAndView.setViewName("hr/addInfo");
		modelAndView.addObject("code",  hrmanageServiceImpl.getCode());
		List<Company> company = hrmanageServiceImpl.getCompanyIdAndName();
		modelAndView.addObject("company", company);
		return modelAndView;
	}
	
	/**
	 * do add
	 * @param modelAndView
	 * @param interviewer
	 * @return
	 */
	@RequestMapping(value="/addInfoCommit")
	public ModelAndView addInfoCommit(ModelAndView modelAndView,Interviewer interviewer) {
		if(hrmanageServiceImpl.addInfoCommit(interviewer)) {
			modelAndView.setView(new RedirectView("hrIndex"));
		}else {
			modelAndView.setViewName("hr/error");
		}
		return modelAndView;
	}
	
	/**
	 * select detail info page
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/detailInfo")
	public ModelAndView detailInfo(ModelAndView modelAndView,int interviewerId) {
		modelAndView.setViewName("hr/detailInfo");
		modelAndView.addObject("detailInfo", hrmanageServiceImpl.getDetailInfoById(interviewerId));
		return modelAndView;
	}
	
	/**
	 * update info page
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/updateInfo")
	public ModelAndView updateInfo(ModelAndView modelAndView,int interviewerId) {
		modelAndView.setViewName("hr/updateInfo");
		modelAndView.addObject("detailInfo", hrmanageServiceImpl.getDetailInfoById(interviewerId));
		return modelAndView;
	}
	
	/**
	 * update info page do
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/updateInfoDo")
	public ModelAndView updateInfoDo(ModelAndView modelAndView,int interviewerId,Interviewer interviewer) {
		modelAndView.addObject("detailInfo", hrmanageServiceImpl.getDetailInfoById(interviewerId));
		if(hrmanageServiceImpl.updateInfoDo(interviewer)) {
			modelAndView.setViewName("hr/detailInfo");
			return modelAndView;
		}else {
			modelAndView.setViewName("hr/error");
			return modelAndView;
		}
	}
	
	/**
	 * addResume page show
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/addResume")
	public ModelAndView addResume(ModelAndView modelAndView) {
		modelAndView.setViewName("hr/addResume");
		return modelAndView;
	}
	
	/**
	 * addResume page show
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/addResumeDo")
	public ModelAndView addResumeDo(ModelAndView modelAndView) {
//		if(hrmanageServiceImpl.addResumeDo(interviewerId,resume)) {
//			
//		}
		modelAndView.setViewName("hr/addResume");
		return modelAndView;
	}
	
	/**
	 * visa login page
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/visaLogin")
	public ModelAndView visaLogin(ModelAndView modelAndView) {
		modelAndView.setViewName("hr/visaLogin");
		return modelAndView;
	}
	
	/**
	 * visa login do
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/visaLoginDo")
	public ModelAndView visaLoginDo(ModelAndView modelAndView,int interviewerCode) {
		if (hrmanageServiceImpl.getInterviewerByInterviewerCode(interviewerCode)) {
			modelAndView.setView(new RedirectView("visaInfo?interviewerCode="+interviewerCode));
			
		}else {
			modelAndView.setView(new RedirectView("visaLogin"));
		}
		return modelAndView;
	}
	
	/**
	 * visa login do
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/visaInfo")
	public ModelAndView visaInfo(ModelAndView modelAndView,int interviewerCode) {
		System.out.println(interviewerCode);
		
		modelAndView.setViewName("hr/visaInfo");
		return modelAndView;
	}
	
}
