run
```java
javac -cp C:/"Program Files"/Java/json-simple-1.1.1.jar FileTransferRMI/*.java
start rmiregistry
java FileTransferRMI.RMIClient
java FileTransferRMI.RMIServer
```