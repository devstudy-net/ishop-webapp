package net.devstudy.tag.hometask;

import java.util.Objects;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class CaseTag extends AbstractSwithChildTag {
	private Object value;

	@Override
	protected boolean shouldBeProcessed(SwitchTag sw) {
		return Objects.equals(value, sw.getValue());
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
