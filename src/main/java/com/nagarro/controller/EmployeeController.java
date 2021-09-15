package com.nagarro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.entity.Employee;
import com.nagarro.services.EmployeeService;
import com.nagarro.services.EmployeeServiceImpl;
import com.nagarro.utility.ExcelFileExporter;

import org.apache.commons.compress.utils.IOUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController()
    {
        employeeService=new EmployeeServiceImpl();
    }
    /*
   This mapping will be called when user click on edit button
   */
    @RequestMapping("/editEmployee")
    public ModelAndView UpdateEmployee(HttpServletRequest request, HttpServletResponse response)
    {
        int employeeCode= Integer.parseInt(request.getParameter("employeeCode"));
        Employee employee=new Employee();
        List<Employee> employeeDetails = employeeService.getEmployeeDetailsById(employeeCode);
        for(Employee employeeDetail:employeeDetails)
        {
            if(employeeCode == employeeDetail.getEmployeecode())
            {
                employee = employeeDetail;
                break;
            }
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("EditEmployee");
        mv.addObject("employee", employee);	//passing employee object to edit-employee-details

        return mv;


    }
    /*
  This mapping will be called when user click on Save Button in update employee page
  */
    @RequestMapping("/updateEmployee")
    public ModelAndView UpdateEmployeeDetails(HttpServletRequest request, HttpServletResponse response)
    {
        int empCode = Integer.parseInt(request.getParameter("employeecode"));
        String empName = request.getParameter("employeename");
        String location = request.getParameter("location");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("dateofbirth");

        Employee employee = new Employee();
        employee.setEmployeecode(empCode);
        employee.setEmployeename(empName);
        employee.setEmail(email);
        employee.setLocation(location);
        employee.setDateofbirth(dateOfBirth);
        employeeService.updateEmployeeDetails(employee);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("Employee");
        return mv;

    }
    /*
  This mapping will be called when user click on Save Button
  */
    @RequestMapping("/add-employee")
    public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response) {
        String empName = request.getParameter("employeename");
        String location = request.getParameter("location");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("dateofbirth");

        Employee employee = new Employee();
        employee.setEmployeename(empName);
        employee.setEmail(email);
        employee.setLocation(location);
        employee.setDateofbirth(dateOfBirth);
        employeeService.addEmployeeDetails(employee);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("Employee");
        return mv;

    }
    /*
   This mapping will be called when user click on Logout Button
   */
    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView("HrLogin");
        return mv;

    }
    /*
  This mapping will be called when user click on upload Button
  */
    @RequestMapping("/upload")
    public ModelAndView uploadEmployee(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("UploadEmployee");
        return mv;
    }
    /*
   This mapping will be called when user click on download button
   */
    @RequestMapping("/download/customers.xlsx")
    public void downloadCsv(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=customers.xlsx");
        ByteArrayInputStream stream = ExcelFileExporter.contactListToExcelFile(employeeService.getEmployeeDetails());
        IOUtils.copy(stream, response.getOutputStream());
    }

}
