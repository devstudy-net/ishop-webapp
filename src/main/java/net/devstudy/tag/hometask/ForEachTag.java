package net.devstudy.tag.hometask;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class ForEachTag extends SimpleTagSupport {
	private String var;
	private Object items;
	@Override
	public void doTag() throws JspException, IOException {
		Iterator<?> it = iterator();
		while(it.hasNext()) {
			setVar(it);
			handleTagBody();
		}
	}
	private void setVar(Iterator<?> it) {
		if(var != null) {
			getJspContext().setAttribute(var, it.next());
		}
	}
	private void handleTagBody() throws JspException, IOException{
		getJspBody().invoke(null);
	}
	private Iterator<?> iterator() throws JspException {
		if(items == null) {
			return Collections.emptyIterator();
		} else {
			if(items instanceof Iterable<?>) {
				return ((Iterable<?>)items).iterator();
			} else if(items instanceof Map<?, ?>) {
				return ((Map<?,?>)items).entrySet().iterator();
			} else if(items instanceof Iterator<?>){
				return ((Iterator<?>)items);
			} else if(items instanceof String) {
				return Arrays.asList(items.toString().split(",")).iterator();
			} else if(items instanceof Enumeration<?>) {
				return Collections.list((Enumeration<?>)items).iterator();
			} else if(items.getClass().isArray()) {
				return new Iterator<Object>() {
					private int current = 0;
					private int length = Array.getLength(items);
					@Override
					public boolean hasNext() {
						return current < length;
					}
					@Override
					public Object next() {
						return Array.get(items, current++);
					}
					@Override
					public void remove() {
					}
				};
			}
			throw new JspException("Can't iterate throw items: "+items.getClass());
		}
	}
	public void setVar(String var) {
		this.var = var;
	}
	public void setItems(Object items) {
		this.items = items;
	}
}
