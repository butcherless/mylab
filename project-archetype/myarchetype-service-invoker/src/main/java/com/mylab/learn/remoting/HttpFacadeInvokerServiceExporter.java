package com.mylab.learn.remoting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.support.RemoteInvocation;
import org.springframework.remoting.support.RemoteInvocationResult;
import org.springframework.web.util.NestedServletException;

import com.mylab.learn.myarchetype.service.TemplateServiceException;

public class HttpFacadeInvokerServiceExporter extends HttpInvokerServiceExporter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		try {
			logger.debug("1");
			RemoteInvocation invocation = readRemoteInvocation(request);
			logger.debug("2");
			RemoteInvocationResult result = invokeAndCreateResult(invocation, getProxy());
			logger.debug("3");

			if (result.hasInvocationTargetException()) {
				logger.debug("has invocation ex");
			} else {
				logger.debug("has no invocation ex");
			}
			
			if (result.hasException()) {
				logger.debug("4");
				result = this.manageException(result);
			}
			logger.debug("5");

			writeRemoteInvocationResult(request, response, result);
			logger.debug("6");
		} catch (ClassNotFoundException ex) {
			throw new NestedServletException("Class not found during deserialization", ex);
		}
		logger.debug("7");
	}

	private RemoteInvocationResult manageException(final RemoteInvocationResult result) {
		RemoteInvocationResult managedResult = result;
		Class<TemplateServiceException> clazz = TemplateServiceException.class;
		logger.debug("4.1");
		if (!clazz.isAssignableFrom(result.getException().getCause().getClass())) {
			logger.debug("4.1.1 {}", result.getException().getCause().getClass().toString());
			
			managedResult = new RemoteInvocationResult(new TemplateServiceException());
		}
		logger.debug("4.2");
		
		return managedResult;
	}
	
	
	
}
