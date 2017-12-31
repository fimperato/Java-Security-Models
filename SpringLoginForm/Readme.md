# SpringLoginForm

## endpoint spring security 3.2 and 4+
### 3.2
In 3.2 version post parameters have changed from j_username to username and j_password to password. The login url has also changed from /j_spring_security_check to /login.
See this link for the explanation of why this change was implemented: http://docs.spring.io/spring-security/site/docs/3.2.0.RELEASE/reference/htmlsingle/#jc-httpsecurity. These are the changes:
  GET /login renders the login page instead of /spring_security_login
  POST /login authenticates the user instead of /j_spring_security_check
  The username parameter defaults to username instead of j_username
  The password parameter defaults to password instead of j_password
And this for an example of a login form: http://docs.spring.io/spring-security/site/docs/3.2.0.RELEASE/reference/htmlsingle/#jc-form
### 4
Spring Security version 4.+ parameters names for form login changed their names:
  username instead of j_username
  password instead of j_password
  POST to /login URL instead of /j_spring_security_check
http://docs.spring.io/spring-security/site/migrate/current/3-to-4/html5/migrate-3-to-4-xml.html#m3to4-xmlnamespace-form-login