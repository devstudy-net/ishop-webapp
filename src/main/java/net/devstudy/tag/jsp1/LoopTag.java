package net.devstudy.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class LoopTag extends TagSupport {
	private static final long serialVersionUID = -3400464140002532373L;
	private int count;

	@Override
	public int doStartTag() throws JspException {
		if (count > 0) {
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}

	@Override
	public int doAfterBody() throws JspException {
		count--;
		if (count > 0) {
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}
	}

	public void setCount(int count) {
		this.count = count;
	}
}
