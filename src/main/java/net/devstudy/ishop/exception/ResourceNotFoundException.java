package net.devstudy.ishop.exception;
/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class ResourceNotFoundException extends IllegalArgumentException {
	private static final long serialVersionUID = -6121766502027524096L;

	public ResourceNotFoundException(String s) {
		super(s);
	}
}
