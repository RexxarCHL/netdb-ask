package netdb.courses.softwarestudio.asksite.mvc.model.business.persistence;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import netdb.courses.softwarestudio.asksite.mvc.ModelAwareServlet;
import netdb.courses.softwarestudio.asksite.mvc.model.domain.Comment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class CommentDao extends ModelAwareServlet<Comment> {
	private static final Log log = LogFactory.getLog(CommentDao.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if (log.isDebugEnabled()) {
			log.debug("Getting/listing domain object(s)");
		}
		
		//TODO check if the target is written in json "title"
		String commentTo = req.getPathInfo().substring(1).toLowerCase();
		log.debug("commentTO" + commentTo);
		List<Comment> comments = ObjectifyService.begin().query(Comment.class).filter("title", commentTo).list();
		log.debug(comments.toString());
		setModel(req, comments);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (log.isDebugEnabled()) {
			log.debug("Creating a domain object");
		}
		
		Comment comment = getModel(req);
		comment.setTitle(comment.getTitle().toLowerCase());
		comment.setStamp(System.currentTimeMillis());
		ObjectifyService.begin().put(comment);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (log.isDebugEnabled()) {
			log.debug("deleting a domain object");
		}
		
		String pathInfo = req.getPathInfo();
		Long id = new Long(pathInfo.substring(1));
		ObjectifyService.begin().delete(Comment.class, id);
	}
}
