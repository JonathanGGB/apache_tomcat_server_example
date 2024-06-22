@echo off

rem Configuración de opciones de memoria de la JVM
set "JAVA_OPTS=-Xms512m -Xmx2048m -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -XX:+UseStringDeduplication"

rem Configuración de opciones de seguridad
set "JAVA_OPTS=%JAVA_OPTS% -Djava.security.egd=file:/dev/./urandom"