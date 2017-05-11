

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import customTools.DbUser;
/**
 * Servlet implementation class NewsfeedServelet
 */
@WebServlet("/NewsfeedServelet")
public class NewsfeedServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsfeedServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
        String feeduseremailid = request.getParameter("userid");
		DbUser du = new DbUser();
		
		if (!feeduseremailid.isEmpty()||!(feeduseremailid==null)){
		
			//User feeduser = (User) du.getUserByEmail(feeduseremailid);		
		 
     		String nextPage;
		
		
	    	if(!action.isEmpty()||!(action==null)){
		        if (request.getParameter("action").toString().equals("viewPosts")){

			  	    ArrayList<Post> posts = new ArrayList<Post>();
        			 Post p = new Post();
        			 
		         	 p.setEmail(request.getParameter("userid"));
		         	 p.setText(" This is the text of my post");
				
		         	 posts.add(p);
        			 
                     Post q = new Post();
        			 
		         	 q.setEmail(request.getParameter("userid"));
		         	 q.setText(" This is the second text of my post");
				
		         	 posts.add(q);
        			
        		 
		    	//Go back to newsfeed.jsp. 
		    	nextPage = "/newsfeed.jsp";
		      //  response.sendRedirect(request.getContextPath() + nextPage);
		        
		    	String message = " ";
		    	String tweet;
		    	// add the code to return tweets
		    	for (int i=0; i < posts.size(); i++){
		    	
		    		tweet = "<tr><td>" + posts.get(i).getText() + "</td></tr>";
		    		message = message + tweet;
		    	}
		    	
		    	// set message to next page
				session.setAttribute("tweet",message);
				
				getServletContext().getRequestDispatcher(nextPage).forward(request, response);
				
		        return;//return here exits the method and prevents an error
		    }
		
		   }
		}
	}

}
