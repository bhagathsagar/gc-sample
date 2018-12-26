@REM	Classification	Option	Description
@REM		Heap area size	
@REM			-Xms				Heap area size when starting JVM
@REM		 	-Xmx				Maximum heap area size
@REM 	
@REM		New area size	
@REM			-XX:NewRatio		Ratio of New area and Old area
@REM		 	-XX:NewSize			New area size
@REM		 	-XX:SurvivorRatio	Ratio of Eden area and Survivor area
@REM
@REM


echo %JAVA_HOME%
set JAVA=%JAVA_HOME%\bin\java
"%JAVA%" -Xmx512m -XX:+UseG1GC -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -XX:+PrintGCCause -Xloggc:log/gc.log -jar target/gc-sample-0.0.1-SNAPSHOT.jar