package com.tom.Exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tom.dto.OutputBase;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String message = null;
        if (ex instanceof CustomException) {
            message = ((CustomException) ex).getMessage();
        } else {
            message = ex.getMessage();
        }

        try {
            //将实体对象转换为JSON Object转换
            ObjectMapper mapper = new ObjectMapper();
            String mapJackson = mapper.writeValueAsString(OutputBase.Fail(message));
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(mapJackson);
        } catch (IOException ioEx) {

        }

        return null;
    }
}
