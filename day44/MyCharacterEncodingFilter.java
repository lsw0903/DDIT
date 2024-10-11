package day44;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyCharacterEncodingFilter implements Filter {
	
	private String encoding; // 인코딩 정보

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding(this.encoding);
		response.setCharacterEncoding(this.encoding);
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		if(filterConfig.getInitParameter("encoding") == null) {
			this.encoding = "UTF-8";
		}else {
			this.encoding = filterConfig.getInitParameter("encoding");
		}
		
		System.out.println("설정된 인코딩 정보 : " + this.encoding);
		
	}
}