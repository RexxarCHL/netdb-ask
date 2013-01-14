package netdb.courses.softwarestudio.asksite.mvc.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import netdb.courses.softwarestudio.asksite.mvc.ModelAwareServlet;
import netdb.courses.softwarestudio.asksite.mvc.model.domain.Comment;
import netdb.courses.softwarestudio.asksite.service.json.JsonService;

@SuppressWarnings("serial")
public class CommentJsonView extends ModelAwareServlet<Comment> {
private static final Log log = LogFactory.getLog(CommentJsonView.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(log.isDebugEnabled()) {
			log.debug("Responsing 200 OK");
		}
		
		Object comment = getModel(req);
		resp.setContentType("application/json");
		resp.setHeader("Cache-Control", "no-cache"); // make sure no intermediate node caches the result
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(JsonService.serialize(comment));
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(log.isDebugEnabled()) {
			log.debug("Responsing 201 Created");
		}
		
		Comment comment = (Comment) getModel(req);
		resp.setStatus(201);
		resp.setHeader("Location", req.getAttribute("javax.servlet.forward.request_uri") + "/"+ comment.getId());
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(log.isDebugEnabled()) {
			log.debug("Responsing 204 No Content");
		}
		
		resp.setStatus(204);
	}

}
