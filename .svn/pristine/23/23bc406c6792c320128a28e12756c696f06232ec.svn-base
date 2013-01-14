package netdb.courses.softwarestudio.asksite.mvc.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import netdb.courses.softwarestudio.asksite.mvc.model.domain.Description;
import netdb.courses.softwarestudio.asksite.service.json.JsonService;

//TODO Update web.xml so that it handles these servlets
@SuppressWarnings("serial")
public class DescriptionController extends ResourceController<Description>{
	private static final Log log = LogFactory.getLog(DescriptionController.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//distribute to dao
		if(log.isDebugEnabled()){
			log.debug("Invoking bussiness logics");
		}
		include(req, resp, "/model/business/persistence/description-dao");
		
		//dispatch to view
		if(log.isDebugEnabled()){
			log.debug("Dispatching to view");
		}
		
		log.debug("getting description from model");
		Description description = getModel(req);
		if(description.getText() == null){
			forward(req, resp, "/view/404-not-found-view");
			return;
		}
		if(!req.getHeader("Accept").contains("application/json")){
			forward(req, resp, "/view/406-not-acceptable-view");
			return;
		}
		forward(req, resp, "/view/description-json-view");	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//set up model in request
		try{
			if(log.isDebugEnabled()){
				log.debug("Setting up model in request");
			}
			String body = getRequestBody(req);
			Description description = JsonService.deserialize(body, Description.class);
			setModel(req, description);
		} catch(Exception e){
			forward(req, resp, "/view/400-bad-request-view");
			if(log.isDebugEnabled()){
				log.info("Bad request" + e.getMessage());
			}
			return;
		}
		
		//distribute to dao
		if(log.isDebugEnabled()){
			log.debug("Invoking business logics");
		}
		include(req, resp, "/model/business/persistence/description-dao");
		
		//dispatch to view
		if(log.isDebugEnabled()) {
			log.debug("Dispatching to view");
		}
		forward(req, resp, "/view/description-json-view");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//set up model in request
		try{
			if(log.isDebugEnabled()){
				log.debug("Setting up model in request");
			}
			String body = getRequestBody(req);
			Description description = JsonService.deserialize(body, Description.class);
			setModel(req, description);
		} catch(Exception e){
			forward(req, resp, "/view/400-bad-request-view");
			if(log.isDebugEnabled()){
				log.info("Bad request" + e.getMessage());
			}
			return;
		}
		
		//distribute to dao
		if(log.isDebugEnabled()){
			log.debug("Invoking business logics");
		}
		include(req, resp, "/model/business/persistence/description-dao");
		
		//dispatch to view
		if(log.isDebugEnabled()) {
			log.debug("Dispatching to view");
		}
		forward(req, resp, "/view/description-json-view");
	}
	
	@Override 
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// invoke business logics
		if(log.isDebugEnabled()) {
			log.debug("Invoking business logics");
		}
		include(req, resp, "/model/business/persistence/description-dao");
		
		// dispatch to view
		if(log.isDebugEnabled()) {
			log.debug("Dispatching to view");
		}
		forward(req, resp, "/view/description-json-view");
	}
}
