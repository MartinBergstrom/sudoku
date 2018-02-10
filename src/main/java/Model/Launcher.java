package Model;

import Model.Persistence.CacheView;
import Model.Persistence.PersistenceFactory;
import Model.Validation.ValidateImpl;
import Model.Validation.Validation;
import REST_Impl.SaveSudokuServiceResource;
import REST_Impl.ValidateServiceResource;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class Launcher {
    private static final Logger LOG = LogManager.getLogger(Launcher.class);

    static {
        System.setProperty("log4j.configurationFile","log4j2.properties.xml");
    }

    public static void main(String[] args) throws Exception {
        new Launcher();
    }

    public Launcher(){
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");

        Server jettyServer = new Server(8080);

        ServletContainer container = new ServletContainer(createResourceConfig());
        ServletHolder servletHolder = new ServletHolder(container);

        handler.addServlet(servletHolder, "/*");
        jettyServer.setHandler(handler);

        try {
            LOG.log(Level.INFO, "Starting upp Jetty server...");
            jettyServer.start();
            jettyServer.join();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            jettyServer.destroy();
        }
    }

    private static ResourceConfig createResourceConfig(){
        //manually inject dependencies to jetty resources
        ResourceConfig resourceConfig = new ResourceConfig();

        Validation validation = new ValidateImpl();
        resourceConfig.register(new ValidateServiceResource(validation));

        CacheView cacheView = PersistenceFactory.getDefaultPersistenceImpl();
        resourceConfig.register(new SaveSudokuServiceResource(cacheView));

        return resourceConfig;
    }
}
