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
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("begin handle request");
		try {
			RemoteInvocation invocation = readRemoteInvocation(request);
			RemoteInvocationResult result = invokeAndCreateResult(invocation, getProxy());

			if (result.hasInvocationTargetException()) {
				logger.debug("has invocation ex");
			} else {
				logger.debug("has no invocation ex");
			}

			if (result.hasException()) {
				result = this.manageException(result);
			}

			writeRemoteInvocationResult(request, response, result);
		} catch (ClassNotFoundException ex) {
			throw new NestedServletException("Class not found during deserialization", ex);
		}
		logger.debug("end handle request");
	}

	private RemoteInvocationResult manageException(final RemoteInvocationResult result) {
		RemoteInvocationResult managedResult = result;
		Class<TemplateServiceException> clazz = TemplateServiceException.class;

		if (!clazz.isAssignableFrom(result.getException().getCause().getClass())) {
			managedResult = new RemoteInvocationResult(new TemplateServiceException());
		}

		return managedResult;
	}

}
