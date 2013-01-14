package netdb.courses.softwarestudio.asksite.mvc.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import netdb.courses.softwarestudio.asksite.mvc.model.domain.Comment;
import netdb.courses.softwarestudio.asksite.service.json.JsonService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class CommentController extends ResourceController<Comment>{
	private static final Log log = LogFactory.getLog(Comment.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// invoke business logics
		if(log.isDebugEnabled()) {
			log.debug("Invoking business logics");
		}
		include(req, resp, "/model/business/persistence/comment-dao");
				
		// dispatch to view
		if(log.isDebugEnabled()) {
			log.debug("Dispatching to view");
		}
		if(!req.getHeader("Accept").contains("application/json")) {
			forward(req, resp, "/view/406-not-acceptable-view");
			return;
		}
		forward(req, resp, "/view/comment-json-view");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//set up model in request
		try{
			if(log.isDebugEnabled()){
				log.debug("Setting up model in request");
			}
			String body = getRequestBody(req);
			Comment comment = JsonService.deserialize(body, Comment.class);
			setModel(req, comment);
		} catch(Exception e){
			forward(req, resp, "view/400-bad-request-view");
			if(log.isDebugEnabled()){
				log.info("Bad request" + e.getMessage());
			}
			return;
		}
		
		//distribute to dao
		if(log.isDebugEnabled()){
			log.debug("Invoking business logics");
		}
		include(req, resp, "/model/business/persistence/comment-dao");
		
		//dispatch to view
		if(log.isDebugEnabled()) {
			log.debug("Dispatching to view");
		}
		forward(req, resp, "/view/comment-json-view");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// invoke business logics
		if(log.isDebugEnabled()) {
			log.debug("Invoking business logics");
		}
		include(req, resp, "/model/business/persistence/comment-dao");
		
		// dispatch to view
		if(log.isDebugEnabled()) {
			log.debug("Dispatching to view");
		}
		forward(req, resp, "/view/comment-json-view");
	}
}
