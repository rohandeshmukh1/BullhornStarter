import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProfileServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * simplify this so that it always requires two parameters, userid and action
		 * action is view or edit. If edit then the userID of the session(user) must be same as userID for profile
		 * since you can only edit your own.
		 * all urls coming to this page must contain both parameters or get error.
		 */
		HttpSession session = request.getSession();
		String nextURL = "/error.jsp";
		int userid = 0;
		String action = "";
		//create variables to hold the user who is logged in and the user for whom we are requesting a profile
		User loggedInUser = null;
		User profileUser = null;
	
		//get user out of session. If they don't exist then send them back to the login page.
		//kill the session while you're at it.
		if (session.getAttribute("user")==null){
			//http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
			nextURL = "/login.jsp";
			session.invalidate();
			response.sendRedirect(request.getContextPath() + nextURL);
		    return;//return prevents an error; Don't believe me? Take it out.
		}
		
		try{
		userid = Integer.parseInt(request.getParameter("userid"));
		action = request.getParameter("action");//action is a hidden input on the form that gives us information
			
		//update profile for user in request variable if action = updateprofile
		if (request.getParameter("action").equals("updateprofile")){
			int uid = Integer.parseInt(request.getParameter("userid"));
			String userEmail = request.getParameter("useremail");
			String userMotto = request.getParameter("usermotto");
			User updateUser = DbUser.getUserById(uid);
			updateUser.setMotto(userMotto);
			updateUser.setEmail(userEmail);
			DbUser.updateUser(updateUser);
		}
		
		//get the user from the parameter
		profileUser = DbUser.getUserByEmail(userEmail);
    	//get the current user out of the session
		loggedInUser = (User) session.getAttribute("user");		
		
		if (profileUser.getUserId()==loggedInUser.getUserId()){
			//display profile as form
			//the session variable editProfile is used by the JSP to
			//display the profile in edit mode
			session.setAttribute("editProfile", true);
		}else{
			//display profile read-only
			//the session variable editProfile is used by the JSP to
			//display the profile in read-only mode
			session.setAttribute("editProfile", false);
		}
		
	    //populate the data in the attributes
		int imgSize = 120;
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
		String joindate = sdf.format(profileUser.getJoinDate());
		request.setAttribute("userid", profileUser.getUserId());
		request.setAttribute("username", profileUser.getUsername());
		request.setAttribute("useremail", profileUser.getEmail());
		request.setAttribute("usermotto", profileUser.getMotto());
		request.setAttribute("userjoindate", joindate);
		nextURL = "/profile.jsp";
		
		
		}catch(Exception e){
			System.out.println(e);
		}finally{
			//redirect to next page as indicated by the value of the nextURL variable
			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		}
	}
}
