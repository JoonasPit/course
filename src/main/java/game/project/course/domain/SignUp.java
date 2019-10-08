package game.project.course.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SignUp {
	    @NotEmpty(message = "Can't be empty")
	    @Size(min=5, max = 15)
	    private String username = "";
	  
		@NotEmpty(message = "Can't be empty")
		@Pattern(regexp="^(?=.*\\d)[A-Za-z0-9]+$", message = "Must contain letters and numbers")
	    @Size(min=10, max = 30, message = "Must be between 10 and 30 characters")
	    private String password = "";

	    @NotEmpty(message = "Can't be empty")
	    @Size(min=10, max=30, message ="Must be between 10 and 30 characters")
	    private String passwordCheck = "";

	    @NotEmpty
	    private String userRole = "USER";
	    
	    @NotEmpty
	    @Email
	    private String userEmail = "";
	    
		    public void setuserRole(String userRole) {
				this.userRole = userRole;
			}
	
			public void setPassword(String password) {
				this.password = password;
			}
			
			public void setusername(String username) {
				this.username = username;
			}
	
			public void setPasswordCheck(String passwordCheck) {
				this.passwordCheck = passwordCheck;
			}
			public void setuserEmail(String userEmail) {
				this.userEmail = userEmail;
			}
	
			public String getuserRole() {
				return userRole;
			}
	
			public String getPasswordCheck() {
				return passwordCheck;
			}
	
			public String getusername() {
				return username;
			}
			
			public String getPassword() {
				return password;
			}
			public String getuserEmail() {
				return userEmail;
			}
	    
}


