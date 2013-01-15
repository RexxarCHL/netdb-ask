package netdb.courses.softwarestudio.asksite.mvc.model.business.persistence;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

import netdb.courses.softwarestudio.asksite.mvc.ModelAwareServlet;
import netdb.courses.softwarestudio.asksite.mvc.model.domain.Description;

@SuppressWarnings("serial")
public class DescriptionDao extends ModelAwareServlet<Description>{
	private static final Log log = LogFactory.getLog(DescriptionDao.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(log.isDebugEnabled()){
			log.debug("Getting a domain object");
		}
		
		//setup model
		String pathInfo = req.getPathInfo();
		log.debug("pathinfo:" + pathInfo);
		if(pathInfo.equals(null)){
			return;
		}
		log.debug("path not null");
		String descriptionTo = pathInfo.substring(1).toLowerCase();
		/*
		List<Description> databaseDescriptions = ObjectifyService.begin().query(Description.class).order("timeStamp").filter("title", descriptionTo).list();
		setModel(req, databaseDescriptions);
		*/
		log.debug("Objectify");
		Query<Description> query = ObjectifyService.begin().query(Description.class).filter("title", descriptionTo);
		log.debug("got query");
		Description description= (query.count() == 0)? new Description() : query.get();
		log.debug("Description:" + description.toString());
		setModel(req, description);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(log.isDebugEnabled()){
			log.debug("Updating a domain object");
		}
		
		String descriptionTo = req.getPathInfo().substring(1).toLowerCase();
		Query<Description> query = ObjectifyService.begin().query(Description.class).filter("title", descriptionTo);
		log.debug("got query");
		Description dbDescription = query.list().get(0);
		dbDescription.setText(getModel(req).getText());
		ObjectifyService.begin().put(dbDescription);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(log.isDebugEnabled()){
			log.debug("Creating a new domain object");
		}
		
		Description description = getModel(req);
		description.setTitle(description.getText().toLowerCase());
		description.setStamp(System.currentTimeMillis());
		ObjectifyService.begin().put(description);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(log.isDebugEnabled()){
			log.debug("Deleting a domain object");
		}
		
		String descriptionTo = req.getPathInfo().substring(1).toLowerCase();
		Query<Description> query = ObjectifyService.begin().query(Description.class).filter("title", descriptionTo);
		Long id = query.list().get(0).getId();
		ObjectifyService.begin().delete(Description.class, id);
	}
}
