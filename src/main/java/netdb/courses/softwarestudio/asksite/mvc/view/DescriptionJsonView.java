package netdb.courses.softwarestudio.asksite.mvc.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import netdb.courses.softwarestudio.asksite.mvc.ModelAwareServlet;
import netdb.courses.softwarestudio.asksite.mvc.model.domain.Description;
import netdb.courses.softwarestudio.asksite.service.json.JsonService;


@SuppressWarnings("serial")
public class DescriptionJsonView extends ModelAwareServlet<Description>{
	private static final Log log = LogFactory.getLog(DescriptionJsonView.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(log.isDebugEnabled()){
			log.debug("Responding 200 OK");
		}
		Object description = getModel(req);
		resp.setContentType("application/JSON");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(JsonService.serialize(description));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(log.isDebugEnabled()){
			log.debug("Responding 202 Accepted");
		}
		resp.setStatus(202);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(log.isDebugEnabled()){
			log.debug("Responding 201 Created");
		}
		Description description = (Description) getModel(req);
		resp.setStatus(201);
		resp.setHeader("Location", req.getAttribute("javax.servlet.forward.request_uri") + "/" + description.getId());
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(log.isDebugEnabled()){
			log.debug("Responding 204 No Content");
		}
		resp.setStatus(204);
	}
	
}
