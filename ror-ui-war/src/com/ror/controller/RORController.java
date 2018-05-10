package com.ror.controller;

import static com.ror.constants.RORConstants.APPEND_SPACE;
import static com.ror.constants.RORConstants.LOGIN_INVALID;
import static com.ror.constants.RORConstants.LOGIN_MESSAGE;
import static com.ror.constants.RORConstants.LOGIN_PAGE;
import static com.ror.constants.RORConstants.LOGOUT_MESSAGE;
import static com.ror.constants.RORConstants.PROFILE_PAGE;
import static com.ror.constants.RORConstants.ROR_USER_ID;
import static com.ror.constants.RORConstants.ROR_USER_NAME;
import static com.ror.constants.RORConstants.ROR_USER_PASSWORD;
import static com.ror.constants.RORConstants.SIGNUP_PAGE;
import static com.ror.constants.RORConstants.USER_NAME;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ror.model.RORUser;
import com.ror.svc.RORSvc;

@Controller
public class RORController {

	@Autowired
	private RORSvc rorSvc;

	@RequestMapping("/authenticate")
	public ModelAndView authenticateUser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		String rorUserId = request.getParameter(ROR_USER_ID);
		String rorUserPassword = request.getParameter(ROR_USER_PASSWORD);
		RORUser user = new RORUser(null, rorUserId, null, rorUserPassword);
		if ((user = rorSvc.authenticateUser(user)) != null) {
			HttpSession session = request.getSession();
			session.setAttribute(ROR_USER_NAME, user.getUserName());
			mav = new ModelAndView(PROFILE_PAGE, USER_NAME, user.getUserName());
		} else {
			mav = new ModelAndView(LOGIN_PAGE, LOGIN_MESSAGE, LOGIN_INVALID);
		}
		return mav;
	}

	@RequestMapping("/signup")
	public ModelAndView signUpPageRedirection(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView(SIGNUP_PAGE);
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		String message = "Thank You For visiting";
		System.out.println("Session name: " + request.getSession().getAttribute(ROR_USER_NAME));
		if (request.getSession().getAttribute(ROR_USER_NAME) != null) {
			String userName = (String) request.getSession().getAttribute(ROR_USER_NAME);
			request.getSession().invalidate();
			return new ModelAndView(LOGIN_PAGE, LOGOUT_MESSAGE, message + APPEND_SPACE + userName + "!");
		}
		return new ModelAndView(LOGIN_PAGE, LOGOUT_MESSAGE, message + "!");
	}

/*	@RequestMapping(value = "/upload", consumes = "multipart/form-data")
	public ModelAndView uplaodImage(HttpServletRequest request, HttpServletResponse response) {
		try {
			Part filePart = request.getPart("file");// Retrieves <input type="file" name="image">`
			String filePath = filePart.getName();
			System.out.println("file path : " + filePath);
			Path p = Paths.get(filePath); // creates a Path object
			String fileName = p.getFileName().toString();// Retrieves file name from Path object
			InputStream fileContent = filePart.getInputStream();// converts Part data to input stream

			byte[] buffer = new byte[(int) filePart.getSize()];
			fileContent.read(buffer, 0, (int) filePart.getSize());
			MongoURI uri = new MongoURI("mongodb://akash:akash@ds249269.mlab.com:49269/ror");
			Mongo mongo1 = new Mongo(uri);
			String dbName = "ror";
			DB db = mongo1.getDB(dbName);
			// Create GridFS object
			GridFS fs = new GridFS(db);
			// Save image into database
			GridFSInputFile ing = fs.createFile(buffer);
			ing.save();
			GridFSDBFile out = fs.findOne(new BasicDBObject("_id", ing.getId()));

			// Save loaded image from database into new image file
			System.out.println("getURI"+request.getRequestURI());
			System.out.println("getPathInfo"+request.getPathInfo());
			System.out.println("getServletPath"+request.getServletPath());
			
			String servletPath = request.getServletPath();
			String pageContext = request.getRequestURL().toString().replaceAll(servletPath, "");
			System.out.println("page context "+pageContext);
			  FileOutputStream outputImage = new FileOutputStream(pageContext+"/images/userAvatar.jpg");
			  out.writeTo(outputImage);
			  outputImage.close();
			 

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			out.writeTo(baos);
			byte[] thumb = baos.toByteArray();

			String name = "userAvatar";
			response.setContentType("image/jpeg");
			response.setContentLength(thumb.length);

			response.setHeader("Content-Disposition", "inline; filename=\"" + name + "\"");

			BufferedInputStream input = null;
			BufferedOutputStream output = null;

			try {
				input = new BufferedInputStream(new ByteArrayInputStream(thumb));
				output = new BufferedOutputStream(new FileOutputStream(request.getRequestURL()+"/images/userAvatar.jpg"));
				byte[] buffer1 = new byte[8192];
				int length;
				while ((length = input.read(buffer1)) > 0) {
					output.write(buffer1, 0, length);
				}
			} catch (IOException e) {
				System.out.println("There are errors in reading/writing image stream " + e.getMessage());
			} finally {
				if (output != null)
					try {
						output.close();
					} catch (IOException ignore) {
					}
				if (input != null)
					try {
						input.close();
					} catch (IOException ignore) {
					}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("welcome", "message", "Save Failed!");
		}
		return new ModelAndView("welcome", "message", "Saved Successfully");
	}

	// upload.cont
*/
}
