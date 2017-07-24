package antiProcastinator.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import antiProcastinator.dao.TacheDAO;



@WebListener
public class BDDListener implements ServletContextListener {

    public BDDListener() {
        // TODO Auto-generated constructor stub
    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("initialisation connection base");
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/antiprocastinator",
					"root",
					"");
			// instanciation du dao des taches
			TacheDAO tacheDAO = new TacheDAO(connection);
			
			sce.getServletContext().setAttribute(TacheDAO.DAO_CONTEXT_KEY, tacheDAO);
			System.out.println("initialisation DAO terminée");
			
		} catch (ClassNotFoundException e) {e.printStackTrace();}
    	catch (SQLException e) {e.printStackTrace();}
    	
    }
	
}
