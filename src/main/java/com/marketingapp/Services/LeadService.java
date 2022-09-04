package com.marketingapp.Services;

import java.util.List;

import com.marketingapp.entities.Lead;

public interface LeadService {
	public void saveLead(Lead lead);

	public List<Lead> listAll();

	public void deleteById(long id);

	public Lead updateRecordById(long id);

	public Lead getOneLeadById(long id);
}
