package fr.epita.dao;

import java.util.Map;

import fr.epita.datamodel.SignUp;

public class SignUpDao extends GenericDao<SignUp, Long>{

	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return "from SignUp";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, SignUp criteria) {
		return;
		
	}

	@Override
	public Class<SignUp> getEntityClass() {
		// TODO Auto-generated method stub
		return SignUp.class;
	}

	
}
