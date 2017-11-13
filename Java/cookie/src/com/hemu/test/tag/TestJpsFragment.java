package com.hemu.test.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestJpsFragment extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jFragment =  getJspBody();
		StringWriter sWriter = new StringWriter();
		
		jFragment.invoke(sWriter);
		
		String content = sWriter.toString().toUpperCase();
		getJspContext().getOut().print(content);
		
	}
}
