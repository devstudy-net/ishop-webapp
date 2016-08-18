package net.devstudy.tag.hometask;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class SwitchTag extends SimpleTagSupport {
	private Object value;
	private boolean processed;
	@Override
	public void doTag() throws JspException, IOException {
		processed = false;
		getJspBody().invoke(null);
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public boolean isProcessed() {
		return processed;
	}
	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
}
