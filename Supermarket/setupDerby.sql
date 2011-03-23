-- This is the setup file for SuperMarket database using derby
--
-- Usage: 
--  java -cp jars/deby.jar;jars/derbytools.jar org.apache.derby.tools.ij setupDerby.sql
--
-- If you want to use another DBMS you could use the scripts CreateTables.sql 
-- and Populate.sql
--
-- 1) Connects to the DB and supposedly creates it
connect 'jdbc:derby:SuperMarket;create=true';
-- 2) Run the statements to create the tables used by the application
run 'CreateTables.sql'
-- 4) Run the statements to populate the database
run 'Populate.sql'
-- END