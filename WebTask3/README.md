First to deal with the idl files and then compile the java file,
later we start the system.

Please follow these steps:

1.Open the command line at the project's src directory.

2.Type the following command one by one.

	idlj -fall Creator.idl 
	idlj -fall List.idl 

	javac *.java 
	javac CreatorFile/*.java 
	javac ListFile/*.java 

	start ORBD
	java CorbaClient