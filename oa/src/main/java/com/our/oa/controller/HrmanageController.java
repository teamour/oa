package com.our.oa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.github.pagehelper.Page;
import com.our.oa.dto.GridDTO;
import com.our.oa.dto.form.InterviewerDTO;
import com.our.oa.dto.form.InterviewerTestDTO;
import com.our.oa.dto.form.InterviewerVisaHandleDTO;
import com.our.oa.dto.list.InterviewerListDTO;
import com.our.oa.dto.list.InterviewerListQueryDTO;
import com.our.oa.dto.list.InterviewerTestListDTO;
import com.our.oa.dto.list.InterviewerTestListQueryDTO;
import com.our.oa.dto.list.InterviewerVisaHandleListDTO;
import com.our.oa.dto.list.InterviewerVisaHandleListQueryDTO;
import com.our.oa.entity.Company;
import com.our.oa.entity.Interviewer;
import com.our.oa.service.HrmanageService;
import com.our.oa.service.InterviewerTestService;
import com.our.oa.service.VisaHandleService;
import com.our.oa.utils.PageInfoToGridDTOUtils;
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
	
	@Autowired
	private VisaHandleService visaHandleServiceImpl;
	
	@Autowired
	private InterviewerTestService interviewerTestServiceImpl;
	
	@GetMapping("/hrIndex")
	public ModelAndView hrIndex(ModelAndView modelAndView) {
		modelAndView.setViewName("hr/hrIndex");
		return modelAndView;
	}
	
	@PostMapping("/hrIndex")
	public GridDTO<InterviewerListDTO> hrIndexdata(HttpServletRequest req,
			InterviewerListQueryDTO queryDTO){
		Page<InterviewerListDTO> queryList = hrmanageServiceImpl.getQueryList(queryDTO);
		return PageInfoToGridDTOUtils.getGridDataResult(queryList);
	}
	
	@GetMapping("/search")
	public ModelAndView search(ModelAndView modelAndView) {
		modelAndView.setViewName("hr/hrIndex");
		return modelAndView;
	}
	
	@PostMapping(value="/search")
	public GridDTO<InterviewerListDTO> search(HttpServletRequest req,
			InterviewerListQueryDTO listqueryDTO) {
		Page<InterviewerListDTO> queryInfo = hrmanageServiceImpl.getQueryList(listqueryDTO);
		return PageInfoToGridDTOUtils.getGridDataResult(queryInfo);
	}
	
	@GetMapping(value="/addInfoShow")
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
	
	@PostMapping(value="/addInfoCommit")
	public ModelAndView addInfoCommit(ModelAndView modelAndView,@Valid InterviewerDTO interviewerInfoForm) {
		if(hrmanageServiceImpl.addInfoCommit(interviewerInfoForm)) {
			modelAndView.setView(new RedirectView("hrIndex"));
		}else {
			modelAndView.setViewName("hr/error");
		}
		return modelAndView;
	}
	
	@GetMapping("/detailInfo")
	public ModelAndView detailInfo(ModelAndView modelAndView,int interviewerId) {
		modelAndView.setViewName("hr/detailInfo");
		modelAndView.addObject("detailInfo", hrmanageServiceImpl.getDetailInfoById(interviewerId));
		return modelAndView;
	}
	
	@GetMapping("/updateInfo")
	public ModelAndView updateInfo(ModelAndView modelAndView,int interviewerId) {
		modelAndView.setViewName("hr/updateInfo");
		modelAndView.addObject("detailInfo", hrmanageServiceImpl.getDetailInfoById(interviewerId));
		modelAndView.addObject("company", hrmanageServiceImpl.getCompanyIdAndName());
		return modelAndView;
	}
	
	@PostMapping("/updateInfoDo")
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
	
	@GetMapping("/addResume")
	public ModelAndView addResume(ModelAndView modelAndView) {
		modelAndView.setViewName("hr/addResume");
		return modelAndView;
	}
	
	@PostMapping("/addResumeDo")
	public ModelAndView addResumeDo(ModelAndView modelAndView) {
//		if(hrmanageServiceImpl.addResumeDo(interviewerId,resume)) {
//			
//		}
		modelAndView.setViewName("hr/addResume");
		return modelAndView;
	}
	
	@GetMapping("/visaLogin")
	public ModelAndView visaLogin(ModelAndView modelAndView) {
		modelAndView.setViewName("hr/visaLogin");
		return modelAndView;
	}
	
	@PostMapping("/visaLogin")
	public GridDTO<InterviewerVisaHandleListDTO> allVisaInfo(HttpServletRequest req,
			InterviewerVisaHandleListQueryDTO QueryDTO){
		Page<InterviewerVisaHandleListDTO> queryInfo = visaHandleServiceImpl.getQueryList(QueryDTO);
		return PageInfoToGridDTOUtils.getGridDataResult(queryInfo);
	}
	
	@PostMapping("/visaLoginDo")
	public ModelAndView visaLoginDo(ModelAndView modelAndView,String interviewerCode) {
		Interviewer interviewer = hrmanageServiceImpl.getInterviewerByInterviewerCode(interviewerCode);
		if (interviewer != null) {
			modelAndView.setView(new RedirectView("visaInfo?interviewerId="+interviewer.getInterviewerId()));
		}else {
			modelAndView.setView(new RedirectView("visaLogin"));
		}
		return modelAndView;
	}
	
	@GetMapping("/visaInfo")
	public ModelAndView visaInfo(ModelAndView modelAndView,int interviewerId) {
		InterviewerVisaHandleDTO interviewerVisaHandleDTO = hrmanageServiceImpl.getInterviewerVisaHandleByInterviewerId(interviewerId);
		modelAndView.addObject("interviewerVisaHandle", interviewerVisaHandleDTO);
		modelAndView.setViewName("hr/visaInfo");
		return modelAndView;
	}
	
	@GetMapping("/modifyVisaInfo")
	public ModelAndView modifyVisaInfo(ModelAndView modelAndView,int interviewerId) {
		InterviewerVisaHandleDTO interviewerVisaHandleDTO = hrmanageServiceImpl.getInterviewerVisaHandleByInterviewerId(interviewerId);
		modelAndView.addObject("interviewerVisaHandle", interviewerVisaHandleDTO);
		modelAndView.setViewName("hr/modifyVisaInfo");
		return modelAndView;
	}
	
	@PostMapping("/modifyVisaInfoDo")
	public ModelAndView modifyVisaInfoShowDo(ModelAndView modelAndView,InterviewerVisaHandleDTO interviewerVisaHandleDTO) {
		System.out.println("aaaaaaa"+interviewerVisaHandleDTO.getInterviewerId());
		if(hrmanageServiceImpl.modifyVisaInfo(interviewerVisaHandleDTO)) {
			modelAndView.setView(new RedirectView("visaInfo?interviewerId="+interviewerVisaHandleDTO.getInterviewerId()));
			return modelAndView;
		}
		modelAndView.setViewName("hr/modifyVisaInfo");
		return modelAndView;
	}
	
	@GetMapping("/itSuitableLogin")
	public ModelAndView itSuitaleLogin(ModelAndView modelAndView) {
		modelAndView.setViewName("hr/itSuitableLogin");
		return modelAndView;
	}
	
	@PostMapping("/itSuitableLogin")
	public GridDTO<InterviewerTestListDTO> itSuitaleData(HttpServletRequest req,
			InterviewerTestListQueryDTO queryDTO) {
		Page<InterviewerTestListDTO> queryInfo = interviewerTestServiceImpl.getQueryList(queryDTO);
		return PageInfoToGridDTOUtils.getGridDataResult(queryInfo);
	}
	
	@PostMapping("/itSuitableLoginDo")
	public ModelAndView itSuitaleLoginDo(ModelAndView modelAndView,String interviewerCode) {
		InterviewerTestDTO interviewerTestDTO = interviewerTestServiceImpl.selectInterviewerTestInfoByInterviewerCode(interviewerCode);
		if(interviewerTestDTO != null) {
			modelAndView.setView(new RedirectView("itSuitable?testId="+interviewerTestDTO.getTestId()));
			return modelAndView;
		}
		modelAndView.setView(new RedirectView("itSuitableLogin"));
		return modelAndView;
	}
	
	@GetMapping("/itSuitable")
	public ModelAndView itSuitable(ModelAndView modelAndView,int testId) {
		InterviewerTestDTO dto = interviewerTestServiceImpl.selectInterviewerTestInfoByTestId(testId);
		modelAndView.addObject("testInfo", dto);
		modelAndView.setViewName("hr/itSuitable");
		return modelAndView;
	}
	
}
