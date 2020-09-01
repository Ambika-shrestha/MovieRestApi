package fr.epita.dao;

import java.util.Map;
import fr.epita.datamodel.Contact;

public class ContactDao extends GenericDao<Contact, String> {

	@Override
	public void setParameters(Map<String, Object> parameters, Contact criteria) {
		parameters.put("pTitle", criteria.getEmail());
	}

	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<Contact> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}
}