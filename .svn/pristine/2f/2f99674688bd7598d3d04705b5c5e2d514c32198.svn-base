package netdb.courses.softwarestudio.asksite.service.objectify;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import netdb.courses.softwarestudio.asksite.mvc.model.domain.Comment;
import netdb.courses.softwarestudio.asksite.mvc.model.domain.Description;

import com.googlecode.objectify.ObjectifyService;

/**
 * Objectify needs every persistable object to be registered. This class
 * registers all domain objects at the time when the {@link ServletContext} is
 * initialized.
 */

public final class ObjectifyInitializer implements ServletContextListener {
	@Override
	public void contextInitialized(final ServletContextEvent sce) {
		ObjectifyService.register(Comment.class);
		ObjectifyService.register(Description.class);
	}

	@Override
	public void contextDestroyed(final ServletContextEvent sce) {
		// do nothing
	}
}
