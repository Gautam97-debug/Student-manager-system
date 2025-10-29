RUN THE PROJECT IN Eclipse 
it should show 
2025-10-29T14:30:11.825+05:30  INFO 3632 --- [Student-manager-backend] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-10-29T14:30:11.843+05:30  INFO 3632 --- [Student-manager-backend] [  restartedMain] c.e.S.StudentManagerBackendApplication   : Started StudentManagerBackendApplication in 4.355 seconds (process running for 4.821)
2025-10-29T14:31:16.309+05:30  INFO 3632 --- [Student-manager-backend] [nio-8080-exec-5] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-10-29T14:31:16.310+05:30  INFO 3632 --- [Student-manager-backend] [nio-8080-exec-5] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-10-29T14:31:16.313+05:30  INFO 3632 --- [Student-manager-backend] [nio-8080-exec-5] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms

open browser and type http://localhost:8080/ 
enter student detials and add student 
to check API's browse :-http://localhost:8080/api/students
