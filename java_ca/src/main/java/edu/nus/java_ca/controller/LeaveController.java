package edu.nus.java_ca.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.nus.java_ca.model.Department;
import edu.nus.java_ca.model.Leave;
import edu.nus.java_ca.model.LeaveStatus;
import edu.nus.java_ca.model.User;
import edu.nus.java_ca.service.UserService;
import edu.nus.java_ca.service.LeaveBalanceService;
import edu.nus.java_ca.service.LeaveService;
import edu.nus.java_ca.service.LeaveServiceImpl;

@Controller
@RequestMapping("/leave")
public class LeaveController {

	@Autowired
	private LeaveService lservice;
	@Autowired
	private UserService uservice;
	@Autowired
	public void setLeaveService(LeaveServiceImpl lserviceImpl) {
		this.lservice = lserviceImpl;
	}
	
//	@Autowired
//	private LeaveBalanceService lbservice;
	
	@RequestMapping(value="/leaves/all")
	public String listAll(Model model) {
		model.addAttribute("leaves", lservice.listAllLeaves());
		return "leaves/allleaves";
	}
 
	//Movement Register
	@RequestMapping(value="/leaves/mvt-reg")
	public String viewMvtReg(Model model) {
		model.addAttribute("leave", new Leave());	
		List<Integer> mthlist = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11);
		int year = Year.now().getValue();
		List<Integer> yrlist = Arrays.asList(year-1, year, year+1);
		model.addAttribute("mthlist", mthlist);
		model.addAttribute("yrlist", yrlist);
		return "leaves/mvt-reg";
	}
	@PostMapping(value="/view") 
	public String viewMvtRegChooseMth(@RequestParam("mth")String mth, 
			@RequestParam("yr")String yr, Model model) throws ParseException {				
		int mthparsed = Integer.parseInt(mth);
		int yrparsed = Integer.parseInt(yr);
		List<Leave> mls = lservice.findLeavesByYearandMonth
				(yrparsed, mthparsed);
		model.addAttribute("mvtleaves", mls);
		return "forward:/leave/leaves/mvt-reg";
	}
	//Subordinate leave history
	//initial view of leave history of respective employee
	@RequestMapping(value="/leaves/empl-leavehistory")
	public String empLeaveHistSearchPage(Model model) {
		model.addAttribute("leave", new Leave());
		return "leaves/empl-leavehistory";
	}
	@PostMapping(value="/search")
	public String searchLeavesByUserId(@RequestParam("user.userId") 
		String UserId, Model model) {
		ArrayList<Leave> lls = (ArrayList<Leave>) 
				lservice.listLeavesByUserId(Long.parseLong(UserId));
		model.addAttribute("emleaves", lls);
		return "forward:/leave/leaves/empl-leavehistory";
	}	
	
	//manager actions
//	@RequestMapping(value = "/leaves/list")
//	public String list(Model model) {
//		model.addAttribute("leaves", lservice.listLeaveToApprove());
//		return "leaves/leave-toapprove";
//	}
//	
//	@RequestMapping(value="/send/{id}")
//	public String managerSetStatus(@PathVariable("id")Long id, 
//			Model model) {
//		List<String> msetstatus = Arrays.asList("APPROVED", "REJECTED");
//		model.addAttribute("msetstatus", msetstatus);
//		model.addAttribute("leaveapplied",lservice.findLeaveById(id));
//		return "leaves/manager-setstatus";
//	}
//	
//	@PostMapping(value="/confirm")
//	public String approverejectLeave(@RequestParam("leaveId")String id, 
//		@RequestParam("mset")String mset, 
//		@RequestParam("mreason")String mrea, Model model) {
//				Leave ls = lservice.findLeaveById(Long.parseLong(id));
//				ls.setMreason(mrea);
//				LeaveStatus stat = Enum.valueOf(LeaveStatus.class, mset);
//				if(stat.equals(LeaveStatus.APPROVED))
//					lservice.approveLeave(ls);
//				if(stat.equals(LeaveStatus.REJECTED))
//					lservice.rejectLeave(ls);
//				return "forward:/leave/leaves/list";
//	}
	
//	@RequestMapping(value = "/approve/{id}")
//	public String approveLeave(@PathVariable("id") Long id) {
//		lservice.approveLeave(lservice.findLeaveById(id));
//		return "forward:/leave/leaves/list";
//	}
//	
//	//rejection require comment
//	@RequestMapping(value = "/reject/{id}")
//	public String rejectLeave(@PathVariable("id") Long id) {
//		lservice.rejectLeave(lservice.findLeaveById(id));
//		return "forward:/leave/leaves/list";
//	}

	
}
