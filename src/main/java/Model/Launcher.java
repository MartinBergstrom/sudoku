package Model;

import Model.Persistence.DataBaseInMemoryView;
import Model.Persistence.PersistenceFactory;
import Model.Sudoku.Generator;
import Model.Sudoku.SudokuGenerator;
import Model.Validation.ValidateImpl;
import Model.Validation.Validation;
import REST_Impl.GenerateSudokuServiceResource;
import REST_Impl.SaveSudokuServiceResource;
import REST_Impl.ValidateServiceResource;
import REST_Interface.GenerateSudokuService;
import REST_Interface.SaveSudokuService;
import REST_Interface.ValidateService;
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

    //static {
        //System.setProperty("log4j.configurationFile", "log4j2.xml");
    //}

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

        Generator generator = new SudokuGenerator();
        GenerateSudokuService generateSudokuService = new GenerateSudokuServiceResource(generator);
        resourceConfig.register(generateSudokuService);

        Validation validation = new ValidateImpl();
        ValidateService validateService = new ValidateServiceResource(validation);
        resourceConfig.register(validateService);

        DataBaseInMemoryView dataBaseInMemoryView = PersistenceFactory.getDefaultPersistenceImpl();
        SaveSudokuService saveSudokuService = new SaveSudokuServiceResource(dataBaseInMemoryView, validation);
        resourceConfig.register(saveSudokuService);

        return resourceConfig;
    }
}
