package javax.validation;

/**
 * Provide contextual data and operation when applying a given constraint implementation
 *
 * @author Emmanuel Bernard
 */
public interface ConstraintContext {
	/**
	 * Disable default error message and default ConstraintViolation object generation.
	 * Useful to set a different error message or generate an ConstraintViolation based on
	 * a different property
	 *
	 * @see #addError(String)
	 * @see #addError(String, String)
	 */
	void disableDefaultError();

	/**
	 * return the current unexpanded default message
	 * TODO: is it needed
	 */
	String getDefaultErrorMessage();

	/**
	 * Add a new unexpanded error message.
	 * <p/>
	 * If isValid returns false, a ConstraintViolation object will be built per error message
	 * including the default one unless #disableDefaultErrorMEssage() has been called.
	 * <p/>
	 * Aside from the error message, ConstraintViolation objects generated from such a call
	 * contains the same contextual information (root bean, path and so on)
	 * <p/>
	 * This method can be called multiple time. One ConstraintViolation instance per
	 * call is created.
	 *
	 * @param message new unexpanded error message
	 */
	void addError(String message);

	/**
	 * Add a new unexpanded error message to a given sub property.
	 * <p/>
	 * If isValid returns false, a ConstraintViolation object will be built
	 * per error message including the default one
	 * if null apply to the current property or the bean the constraint is applied on,
	 * otherwise apply to the <code>property</code> named
	 * <p/>
	 * TODO exception or swallowed when bean level instance is not present?
	 *
	 * @param message new unexpanded error message
	 * @param property property name the ConstraintViolation is targeting
	 *
	 * @throws ValidationException when the property is not present on the bean level object
	 */
	void addError(String message, String property);

}