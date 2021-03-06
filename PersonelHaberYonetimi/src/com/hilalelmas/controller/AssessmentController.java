package com.hilalelmas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hilalelmas.dao.DAO;
import com.hilalelmas.entity.Assessment;
import com.hilalelmas.entity.Person;

@ManagedBean
@SessionScoped
public class AssessmentController {
	DAO dao;
	List<Person> personList;
	List<String> personName;
	List<Assessment> assessmentList;
	String secilenPersonelName;
	Assessment assAdd;

	@PostConstruct
	public void init() {
		personName = new ArrayList<>();
		dao = new DAO();
		createPersonNameList();
		assAdd = new Assessment();
		assessmentList = dao.getAssment();

	}

	public void setAssAdd(Assessment assAdd) {
		this.assAdd = assAdd;
	}

	public Assessment getAssAdd() {
		return assAdd;
	}

	public void createPersonNameList() {
		personList = dao.getPersonList();
		for (int i = 0; i < personList.size(); i++) {
			personName.add(personList.get(i).getName());

		}
	}

	public Person findPersonNamePerson(String name) {
		personList = dao.getPersonList();
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getName().equals(name))
				return personList.get(i);

		}
		return null;
	}

	public String save() {
		assAdd.setPerson(findPersonNamePerson((secilenPersonelName)));
		dao.save(assAdd);
		assessmentList = dao.getAssment();
		return "haberview.xhtml?faces-redirect=true";

	}

	public void setPersonName(List<String> personName) {
		this.personName = personName;
	}

	public List<String> getPersonName() {
		return personName;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setSecilenPersonelName(String secilenPersonelName) {
		this.secilenPersonelName = secilenPersonelName;
	}

	public String getSecilenPersonelName() {
		return secilenPersonelName;
	}

	public void setAssessmentList(List<Assessment> assessmentList) {
		this.assessmentList = assessmentList;
	}

	public List<Assessment> getAssessmentList() {
		return assessmentList;
	}
}
