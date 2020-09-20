# car-rentals

Description:
Design and prototype a car rental system using object-oriented principles.

Functionality:<br />
•	In-Scope
<ul>
<li>The system should let a customer reserve a car of a given type at a desired date and time for a given number of days</li>
<li>The number of cars of each type is limited, but customers should be able to reserve a single rental car for multiple, non-overlapping time frames</li>
<li>Provide a Junit test that illustrates the core reservation workflow and demonstrates its correctness</li>
<li>Use Java as the implementation language.</li>
<li>ohe solution should allow for an extension to be exposed as a service</li>
</ul>
•	Out of Scope
<ul>
<li>No UI needs to be provided</li>
<li>No need to explicitly suspend the solution in a web container, e.g. using spring boot</li>
<li>No need to explicitly integrate the solution with a database.</li>
</ul>
Constraints and Risks:
  •	This is an assessment task and should be delivered within 2 to 5 hours.
  •	Due to time constraints, extensive testing is not performed.
  •	Lots of assumptions have been made due to the absence of a requirement provider.
  •	There can be multiple solutions to same the same problem but due to time constraints all solutions are not explored and there is always room for improvement. Some of them are mentioned in the “Future enhancements” section.
  •	Due to time constraints, no UML diagram is used. Instead, they are discussed in the Implementation section as a Text.
Implementation:
This section describes the high-level approach that is used for implementation and describes the component and classes in text notation instead of the UML and Sequence diagram.
•	The system code is divided into multiple packages. Model, Dao, Dao Implementation, Service, Exception, and Unit Test.
•	Model 
o	The model contains the domain classes for the rental system.
•	Dao
o	Dao is divided into three groups. 
	Dao Interface, 
	AbstractDao 
	DaoImpl. 
o	Interfaces have only general abstract methods that any data layer API is expected to have.
o	AbstractDao has the general functionality that every concrete Dao implementation is expected to have. 
o	LocalDao has been implemented as a concrete extension of the Dao interface. 
o	LocalDao classes serve as the local fixed data source for the system. 
o	There shall be separate concrete implementation for each data source. For example, we can have OracleDaoImpl for an oracle data source, S3DaoImpl for S3 data source, RestDaoImpl for the restful API data source.
•	Service:
o	Service classes are the meat of the implementation from the API user perspective. 
o	API users shall use classes to interact with the system. 
o	Again, due to time constraint service class are provided as Concrete implementation and not Interface/Abstract object hierarchy is established. 
o	Also, the Dao hierarchy is good enough to handle Concrete Service implementation for this task.
•	Exceptions:
o	Exception classes are used to define unexpected conditions.
o	Also, classes are made as an unchecked exception to make code less polluted. But this the thing that can be revisited.
•	Unit Test:
o	Three test classes have been implemented as a part of the implementation.
o	ReservationServiceTest, have the basic flow of the reservation and system correctness. It has the test to reserve a valid car for the valid customer, this is our happy flow. Is also has a negative test that shows how a car cannot be reserved by the same customer for the overlapping duration.
o	The other two test classes, check the validity of the car and customer.
o	No tests have been written for the inventory
 
Assumptions:
•	This is a maven-based Java project.
•	Java 1.8 has been selected for the implementation.
•	Application logging is NOT implemented.
•	Other non-functional requirements like performance, scalability high availability is not given any thought.
•	For this demo, I have assumed that only car type will be handled. So, I have not created a more generalized Vehicle as a parent hierarchy. See Future enhancement for more on this.
•	The system assumes that “Customer” is already registered with a system. Only valid customers can make reservations. 
•	It is assumed that a Single Customer can reserve multiple cars of different types but cannot reserve the same type of car for the same period or overlapping period.
•	The customer can rent a car for as many days as he wants. There is no upper bound on the duration rented. The only system-level constraint is that a customer can rent for Integer.MAX_VALUE days.	
•	I have made Exception classes as unchecked exceptions to make code less polluted. It is assumed that the user of the API should read the documentation of API and take care of the exception.
•	 LocalDao serves as local DB, these concrete implementations have a fixed set of data to demonstrate the functionality.
•	I have not used car type as an enum with the assumption that there will be many car types available and those should be coming from some data source.
•	We can have OracleDaoImpl, FileDaoImpl, RestDaoImpl, etc, all should extend from AbstractDao.

Future enhancements:
•	The system is highly focused on one type of vehicle, that is the car. As an enhancement, we should design a Vehicle hierarchy as a more generalized form for the enhanced system. With the Vehicle hierarchy in place, we can reserve cars, bikes, bicycles etc. But more discussion and specific requirements are needed before diving into the design.
•	Concrete Dao Implementation classes should be outsourced to another child maven project. Only Interface and AbstractDao classes should be part of the core reservation system. 
•	It will be difficult to do Object Relational Mapping with LocalDate class. So, we should look for more ORM friendly class in case our data source a database, and we planning to use ORM.
•	Exception classes can be revisited. We can have a combination of checked and unchecked exceptions. But it needs more analysis of the system and the client. For example, if the service is exposed to a rest client then the client will only concern with the HTTP response code. And in this case, the definition and use of exception classes will be handled by the service developer. But if the service is exposed as a Java API then exception handling will become the shared responsibility of the service developer and service client.
•	Better naming conventions for packages and classes
•	Since in software engineering only constant thing is change, so there could be more enhancements.
