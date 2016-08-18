package net.devstudy.tag.hometask;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public abstract class AbstractSwithChildTag extends SimpleTagSupport {

	@Override
	public final void doTag() throws JspException, IOException {
		SwitchTag sw = getSwitchTag();
		if (!sw.isProcessed() && shouldBeProcessed(sw)) {
			sw.setProcessed(true);
			getJspBody().invoke(null);
		}
	}

	protected abstract boolean shouldBeProcessed(SwitchTag sw);

	protected final SwitchTag getSwitchTag() throws JspException {
		JspTag tag = getParent();
		if (tag instanceof SwitchTag) {
			return ((SwitchTag) tag);
		} else {
			throw new JspException("case tag should be inside switch tag! Current parent is: " + (tag != null ? tag.getClass() : null));
		}
	}
}
