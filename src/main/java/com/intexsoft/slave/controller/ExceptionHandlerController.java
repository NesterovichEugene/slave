package com.intexsoft.slave.controller;

import javax.persistence.OptimisticLockException;

import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.lang.System.lineSeparator;
import static org.apache.commons.lang3.StringUtils.defaultIfEmpty;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

/**
 * Expression handler controller
 */
public abstract class ExceptionHandlerController
{
	private static final Logger LOGGER = getLogger(ExceptionHandlerController.class);

	/**
	 * Handles exception
	 * @param throwable
	 *            {@link Throwable}
	 */
	@ExceptionHandler({Throwable.class})
	public ResponseEntity<String> handleException(Throwable throwable)
	{
		LOGGER.error("Unexpected error:", throwable);
		String fullMessage = fullMessage(throwable);
		return new ResponseEntity<String>(fullMessage, isOptimistic(throwable) ? CONFLICT : BAD_REQUEST);
	}

	private boolean isOptimistic(Throwable throwable)
	{
		return throwable instanceof OptimisticLockException || throwable instanceof ObjectOptimisticLockingFailureException;
	}

	private String fullMessage(Throwable throwable)
	{
		StringBuilder builder = new StringBuilder();
		while (throwable != null)
		{
			builder.append(getLocalizedMessage(throwable));
			throwable = throwable.getCause();
			if (throwable != null)
			{
				builder.append(lineSeparator());
			}
		}
		return builder.toString();
	}

	private String getLocalizedMessage(Throwable throwable)
	{
		return defaultIfEmpty(throwable.getLocalizedMessage(), throwable.toString());
	}
}
