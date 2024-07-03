package com.sunbeam.Beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateListBean {
	private List list;

	public CandidateListBean() {}
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	public List getCandidateList() {
		List<Candidate> list = new ArrayList<>();
		try(CandidateDao candidate = new CandidateDaoImpl()){
			this.list = candidate.findAll();
			return this.list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
