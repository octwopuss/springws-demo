package com.yohaneshdr.demo.Config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class DemoSoapConfig extends WsConfigurerAdapter {
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/soapWS/*");
	}
	
	@Bean
	public XsdSchema documentMappingSchema() {
		return new SimpleXsdSchema(new ClassPathResource("DocumentMapping.xsd")); 
	}
	
	@Bean(name="documentMapping")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema documentMappingSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setSchema(documentMappingSchema);
		definition.setLocationUri("/soapWS");
		definition.setPortTypeName("DocumentMappingServicePort");
		definition.setTargetNamespace("http://yohaneshdr.com/demo");
		return definition;
	}
}
