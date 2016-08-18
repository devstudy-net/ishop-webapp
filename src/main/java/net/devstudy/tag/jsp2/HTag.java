package net.devstudy.tag.jsp2;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HTag extends SimpleTagSupport {
	private String type;

	public HTag() {
		setDefaults();
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<" + type + ">");
		getJspBody().invoke(null);
		out.print("</" + type + ">");
	}

	private void setDefaults() {
		type = "h6";
	}

	public void setType(String type) {
		if (type != null) {
			if (Arrays.asList(new String[] { "h1", "h2", "h3", "h4", "h5", "h6" }).contains(type.toLowerCase())) {
				this.type = type;
			}
		}
	}
}
