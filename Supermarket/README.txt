Readme File for Supermarket application

This application requires a database application in order to run.

The application is pre-packaged to work with the open source database
Apache Derby project DBMS version 10.0.2.1
See:	http://incubator.apache.org/derby/
Please read the LICENSE.txt file.

========================================================

In order to run and test the program you have to setup the database:

 - create the "SuperMarket" db; 
    e.g. from a console prompt in the project folder
 
 	java -cp derby.jar;derbytools.jar org.apache.derby.tools.ij setupDerby.sql
 