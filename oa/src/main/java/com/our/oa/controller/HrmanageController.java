package com.our.oa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.our.oa.dto.form.InterviewerDTO;
import com.our.oa.entity.Company;
import com.our.oa.entity.Interviewer;
import com.our.oa.entity.InterviewerVisaHandle;
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
		InterviewerDTO interviewer = new InterviewerDTO();
		modelAndView.setViewName("hr/addInfo");
		interviewer.setInterviewerCode(hrmanageServiceImpl.getCode());
//		modelAndView.addObject("interviewerCode",  hrmanageServiceImpl.getCode());
		List<Company> company = hrmanageServiceImpl.getCompanyIdAndName();
		modelAndView.addObject("company", company);
		modelAndView.addObject("interviewerInfoForm", interviewer);
		return modelAndView;
	}
	
	/**
	 * do add
	 * @param modelAndView
	 * @param interviewer
	 * @return
	 */
	@RequestMapping(value="/addInfoCommit")
	public ModelAndView addInfoCommit(ModelAndView modelAndView,@Valid InterviewerDTO interviewerInfoForm) {
		if(hrmanageServiceImpl.addInfoCommit(interviewerInfoForm)) {
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
		modelAndView.addObject("company", hrmanageServiceImpl.getCompanyIdAndName());
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
			modelAndView.setView(new RedirectView("detailInfo?interviewerId="+interviewerId));
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
	public ModelAndView visaLoginDo(ModelAndView modelAndView,String interviewerCode) {
		Interviewer interviewer = hrmanageServiceImpl.getInterviewerByInterviewerCode(interviewerCode);
		if (interviewer != null) {
			modelAndView.setView(new RedirectView("visaInfoShow?interviewerId="+interviewer.getInterviewerId()));
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
	@RequestMapping("/visaInfoShow")
	public ModelAndView visaInfoShow(ModelAndView modelAndView,int interviewerId) {
		InterviewerVisaHandle interviewerVisaHandle = hrmanageServiceImpl.getInterviewerVisaHandleByInterviewerId(interviewerId);
		modelAndView.addObject("interviewerVisaHandle", interviewerVisaHandle);
		System.out.println(interviewerVisaHandle.getInterviewerId());
		modelAndView.setViewName("hr/visaInfo");
		return modelAndView;
	}
	
	/**
	 * modify visa info
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/modifyVisaInfoShow")
	public ModelAndView modifyVisaInfoShow(ModelAndView modelAndView,int interviewerId) {
		InterviewerVisaHandle interviewerVisaHandle = hrmanageServiceImpl.getInterviewerVisaHandleByInterviewerId(interviewerId);
		modelAndView.addObject("interviewerVisaHandle", interviewerVisaHandle);
		modelAndView.setViewName("hr/modifyVisaInfo");
		return modelAndView;
	}
	
	/**
	 * modify visa info
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/modifyVisaInfoDo")
	public ModelAndView modifyVisaInfoShowDo(ModelAndView modelAndView,InterviewerVisaHandle interviewerVisaHandle) {
		System.out.println(interviewerVisaHandle);
		
		
		
		modelAndView.setViewName("hr/visaInfo");
		return modelAndView;
	}
	
}
