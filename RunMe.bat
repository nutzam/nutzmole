echo off
SET CLASSPATH=moleconf;lib
for %%i in (lib/*.jar) do call cpappend.bat lib/%%i
for %%i in (lib/uilib/*.jar) do call cpappend.bat lib/uilib/%%i
@REM ECHO %CLASSPATH%
echo on
java -Xmx512m org.nutz.mole.ZMole %*