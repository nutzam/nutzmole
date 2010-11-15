<?xml version="1.0" encoding="UTF-8"?>
<web-app id="WebApp_ID" version="2.5"
	xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
	
	<filter>
        <filter-name>msgs</filter-name>
        <filter-class>org.nutz.mvc.NutFilter</filter-class>
	</filter>

	<filter-mapping>
        <filter-name>msgs</filter-name>
        <url-pattern>*.jsp</url-pattern>
	</filter-mapping>

	<!-- Nutz -->
	<servlet>
		<servlet-name>nutz</servlet-name>
		<servlet-class>org.nutz.mvc.NutServlet</servlet-class>
		<init-param>
			<param-name>modules</param-name>
			<param-value>${packageName}.MainModule</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>nutz</servlet-name>
		<url-pattern>*.nut</url-pattern>
	</servlet-mapping>

	<welcome-file-list>
		<welcome-file>index.html</welcome-file>
	</welcome-file-list>

</web-app>