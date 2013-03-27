package com.mylab.learn.myarchetype.core;

/**
 * General purpose validator
 * 
 * @author cmartin
 * 
 */
public interface Validator {
	/**
	 * Ensures validation of the types that this validator supports
	 * 
	 * @param clazz class supplied to the validator
	 * @return if validator supports the class validation
	 */
	Boolean supports(Class<?> clazz);

	/**
	 * Validates a class
	 * 
	 * @param target class to be validated
	 * @throws ValidationException validation erros
	 */
	void validate(Object target) throws ValidationException;

}
