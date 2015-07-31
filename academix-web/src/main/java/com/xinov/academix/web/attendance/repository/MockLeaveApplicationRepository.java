package com.xinov.academix.web.attendance.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xinov.academix.attendance.api.domain.LeaveApplication;
import com.xinov.academix.core.api.domain.Status;
import com.xinov.academix.core.api.domain.User;
import com.xinov.academix.web.user.repository.UserRepository;

@Repository
public class MockLeaveApplicationRepository implements
		LeaveApplicationRepository {

	private List<LeaveApplication> leaveApplications;
	
	private UserRepository userRepository;
	
	private List<User> students;
	
	@Autowired 
	public MockLeaveApplicationRepository(UserRepository userRepository){
		this.userRepository = userRepository;
		
		students = this.userRepository.listStudents(1);
		
		leaveApplications = new ArrayList<LeaveApplication>();
		
		int count = 0;
		for(User student : students){
			leaveApplications.add(createLeaveApplication(student, count++));
		}
	}
	
	@Override
	public List<LeaveApplication> list() {
		return leaveApplications;
	}

	@Override
	public LeaveApplication find(long id) {
		for (LeaveApplication leaveApplication : leaveApplications) {
			if(leaveApplication.getId() == id){
				return leaveApplication;
			}
		}
		return null;
	}

	@Override
	public List<LeaveApplication> findByTeacher(User teacher) {
		return leaveApplications;
	}

	@Override
	public List<LeaveApplication> findByStudent(User student) {
		List<LeaveApplication> applications = new ArrayList<LeaveApplication>();
		for(LeaveApplication leaveApplication : leaveApplications){
			if(leaveApplication.getStudent().equals(student)){
				applications.add(leaveApplication);
			}
		}
		return applications;
	}

	@Override
	public LeaveApplication findByStudentAndDate(User student, Date date) {
		for(LeaveApplication application : findByStudent(student)){
			if(application.getApplicationDate().equals(date)){
				return application;
			}
		}
		return null;
	}

	@Override
	public void create(LeaveApplication leaveApplication) {
		leaveApplications.add(leaveApplication);
	}

	@Override
	public void update(LeaveApplication leaveApplication) {
		//
	}

	@Override
	public void delete(LeaveApplication leaveApplication) {
		leaveApplications.remove(leaveApplication);
	}

	private LeaveApplication createLeaveApplication(User student, int count){
		LeaveApplication application = new LeaveApplication();
		application.setId(count);
		application.setApplicant(new ArrayList<User>(student.getParents()).get(0));
		
		Date applicationDate = createRandomDate();
		application.setApplicationDate(applicationDate);
		application.setLeaveFromDate(applicationDate);
		Date toDate = DateUtils.addDays(applicationDate, RandomUtils.nextInt(4));
		application.setLeaveToDate(toDate);
		
		application.setReason("sick");
		application.setSchoolInfo(student.getSchoolInfo());
		application.setStatus(new Status(1, "APPROVED", ""));
		
		application.setStudent(student);
		application.setTeacher(userRepository.get("teacher1", "teacher1"));
		
		application.setApplicationContent(createApplicationContent(student, applicationDate, toDate));
		
		return application;
	}
	
	private String createApplicationContent(User student, Date fromDate, Date toDate) {
		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
		StringBuilder content = new StringBuilder();
		content.append("Dear Sir, <BR/><BR/>");
		content.append("My "+(student.getSex().equals("M")?"son ":"daughter ")+ student.getName()+" will not be able to attend school from "+dateFormat.format(fromDate)+" to "+dateFormat.format(toDate)+" because of medical reasons.<BR/>");
		content.append("Request you to grant "+(student.getSex().equals("M")?"him":"her")+" the leave for mentioned period and inform me in case of any issue.<BR/><BR/>");
		content.append("Yours faithfully,<BR/>");
		content.append(((User)student.getParents().toArray()[0]).getName());
		
		return content.toString();
	}

	private Date createRandomDate() {
		int day = RandomUtils.nextInt(18)+10;
		int month = RandomUtils.nextInt(8)+1;
		int year = 2015;
		try {
			return new SimpleDateFormat("dd MM yyyy").parse(day + " 0" + month + " " + year);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
