#EMPLOYEE ATTENDANCE

The main purpose of this service is to store employee data
about their working hours in a company.
The main actors in the project are the Employee and the Admin.
The employee can use the app in that way such he can sign up 
to the system, login, check-in and check-out, and view the hours
worked.

###Tools

You will need:
1. Maven as the building tool
2. JDK 1.8+
3. PostgreSQL
4. IDE

###Getting started
1. Clone the project from here:
```https://github.com/EnsarKarameti/employee-attendance```
2. Configure database:
   1. Create database with name: ```employeeAttendance```
   2. Open ```empAttendance.sql``` file in the query tool of the database
   3. Edit ```application.properties``` file by setting the database name host and username
   4. Add database password to project configuration
3. After everything is set up open the project with your IDE, install the dependencies and 
run the application.


###Endpoints


#####Admin endpoints
* URL: ```http://localhost:8080/admin/allemployees``` METHOD = POST
  Needs json body for login. Response is all employees and their hours worked
    
* URL: ```http://localhost:8080/admin/allhours``` METHOD = POST
                                                   Needs json body for login.
    Response is just the hours worked by all employees.
    
* URL: http://localhost:8080/admin/signup METHOD = POST
                                           Needs json body for sign up.
    Response is the new registered admin
    
#####Employee endpoints

* URL: ```http://localhost:8080/employee/signup``` METHOD = POST Needs json body for sign up.
Response is the new registered employee.

* URL: ```http://localhost:8080/employee/checkin``` METHOD = POST Needs json body for login.
Response is the new registered Hours object.

* URL: ```http://localhost:8080/employee/checkout```  METHOD = POST Needs json body for login.
                                                      Response is the updated hours object with the checkout time provided.

* URL: ```http://localhost:8080/employee/hours``` METHOD = POST Needs json body for login. 
Response is the whole list of hours worked.

* URL: ```http://localhost:8080/employee/month``` METHOD = POST Needs json body for login. 
Response is the whole list of hours worked for one month. Parameters required are month and year (if parameters left empty 
default values will be current month and current year).
```http://localhost:8080/employee/month?month=1&year=2020```

    
   
