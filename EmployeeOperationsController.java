package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {
@Autowired
private IEmployeeMgmtService empService;

@GetMapping("/")
public String showHomePage() {
	//return LVN
	return"welcome";
}
@GetMapping("/report")//G----GET
public String generateReport(Map<String,Object> map) {
	System.out.println("mployeeOperationContoller.generateReport()");
	//use service
	Iterable<Employee> it=empService.showAllEmployees();
	//keep the result in model attribute(shared memory)
	map.put("empList",it);
	//return LVN
	return "show_report";
	}

@GetMapping("/register")
public String showEmployeeRegisterFormPage(@ModelAttribute("emp") Employee emp) {
	//return LVN
	return "register_employee_form";
}
/*@PostMapping("/register")
public String saveEmployee(@ModelAttribute("emp") Employee emp,
		                                              Map<String,Object>map) {
   //use service
	String msg=empService.registerEmployee(emp);
	Iterable<Employee>it=empService.showAllEmployees();
	//keep the result in mdel attrrribtee(shared memory)
	map.put("resultMsg",msg);
	map.put("empList", it);
	//return LVN
	return"show_report";
}//this is usefull but double post problem comes
*/

@PostMapping("/register")//p----POST
public String saveEmployee(@ModelAttribute("emp") Employee emp,
		                                              RedirectAttributes attrs) {
	System.out.println("EmployeeOperationControoller.saveEmployee()");
   //use service
	String msg=empService.registerEmployee(emp);
	
	//keep the result in mdel attrrribtee(shared memory)
	attrs.addFlashAttribute("resultMsg",msg);//RedirectAttributes is used to success mesage of rregistering mployee
	//return LVN
	return"redirect:report";//R----Redirect
}//its best to use RedirectAttribute 

/*@PostMapping("/register")//p----POST
public String saveEmployee(@ModelAttribute("emp") Employee emp,
		                                              HttpSession ses) {
	System.out.println("EmployeeOperationControoller.saveEmployee()");
   //use service
	String msg=empService.registerEmployee(emp);
	
	//keep the result in mdel attrrribtee(shared memory)
	ses.setAttribute("resultMsg",msg);//using seession attibtee the rgister success mssage never goes, even after refressing.
	//return LVN
	return"redirect:report";//R----Redirect
}*/

@GetMapping("/edit")
public String showEditFormPage(@RequestParam Integer no,
		                                                        @ModelAttribute("emp") Employee emp) {
	System.out.println("EmployeeOperationsControoller.SnoowEdiiitFoorrmPage()");
	//use service 
	Employee emp1=empService.findEmployeeByNo(no);
	BeanUtils.copyProperties(emp1, emp);//copy one obj data to another obj if both are having same properties names
//return LVN
return "edit_employee_form";
	
}

@PostMapping("/edit")//edit operation for submission page
public String updateEmployee(@ModelAttribute("emp") Employee emp,
		                                                       RedirectAttributes attrs) {
	//use service
	String msg=empService.updateEmployee(emp);
	//keep the result in shared memory
	attrs.addFlashAttribute("resultMsg", msg);
	//return LVN
	return "redirect:report";
}
@GetMapping("/delete")
public String removeEmployeeById(@RequestParam Integer no,
		                                                               RedirectAttributes attrs) {
	//use service
	String msg=empService.removeEmployeeById(no);
	//keep the result in model attribute
	attrs.addFlashAttribute("resultMsg",msg);
	//return LVN
	return "redirect:report";
}


}

