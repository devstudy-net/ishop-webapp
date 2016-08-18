package net.devstudy.tag.hometask;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class DefaultTag extends AbstractSwithChildTag {
	@Override
	protected boolean shouldBeProcessed(SwitchTag sw) {
		return true;
	}
}
