package net.devstudy.tag.jsp2;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class UpperCaseTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();
		getJspBody().invoke(sw);
		getJspContext().getOut().print(sw.toString().toUpperCase());
	}
}
