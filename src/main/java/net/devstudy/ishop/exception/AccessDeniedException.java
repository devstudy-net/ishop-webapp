package net.devstudy.ishop.exception;
/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class AccessDeniedException extends IllegalArgumentException {
	private static final long serialVersionUID = -8981777225188967376L;

	public AccessDeniedException(String s) {
		super(s);
	}
}
