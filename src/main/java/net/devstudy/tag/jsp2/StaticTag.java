package net.devstudy.tag.jsp2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class StaticTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().println("Current date: " + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
	}
}
