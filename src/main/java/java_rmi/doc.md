   ## RMI
### Keywords
1. Stub
    + An identifier of the remote object to be used
    + Method name which is to be invoked
    + Params to the remote JVM
2. Skeleton
    + Call desired method on the real object present on server
    + Forwards the params received from the Stub to method

+ Providing communication between client and server
+ Client holds Stub object -> When client want to invoke a method on a remote object, Must be through Stub
+ Server holds Skeleton object -> receiving the method invoked and forwards to the remote object (dispatches to the approriate remote object)

3. RMI registry: providing directory service for registering and locating remote object


### Programming step
```
Step 1
1. Remote interface 
2. Define functions gonna be called from remote
3. try catch with RemoteException

Step 2
1. Remote interface
2. This interface must extends UnicastRemoteObject to
    inherit all the remote features
3. Construct with remote object

Step 3
1. Create stub and skeleton using rmic

Step 4
1. Copy remote interface and file stub created to client

Step 5
1. Init Remote registry server
```


### Run with own project
cd to java not java_rmi
javac java_rmi/*.java
/java start rmiregistry

then /java java -cp . java_rmi.ServerRMI
/java java -cp . java_rmi.ClientRMI