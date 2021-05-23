package ua.lviv.elearn.odoskaliuk.cinema.web.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import ua.lviv.elearn.odoskaliuk.cinema.db.util.TimeDurationFormatter;

public class DurationTagHandler extends TagSupport{
	int value;
	
	public void setValue(String value) {
		this.value = Integer.parseInt(value);
	}
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			String durationStr = TimeDurationFormatter.getStringFromTimeDuration(value);
			out.println(durationStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
