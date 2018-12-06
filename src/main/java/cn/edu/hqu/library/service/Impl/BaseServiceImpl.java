package cn.edu.hqu.library.service.Impl;


import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseServiceImpl {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new MyDateEditor());
    }
    private class MyDateEditor extends PropertyEditorSupport {
        @Override
        public void  setAsText (String text){
            SimpleDateFormat format = new SimpleDateFormat(("yyyy-MM-dd"));
            Date date=null;
            try {
                date=format.parse(text);
            } catch (ParseException e) {
                format = new SimpleDateFormat(("yyyy-MM-dd"));
                try {
                    date = format.parse(text);
                } catch (ParseException e1) {
                    format = new SimpleDateFormat(("yyyyMMdd"));
                    try {
                        date = format.parse(text);
                    } catch (ParseException ignored) {

                    }
                }
                setValue(date);
            }
        }
    }
}

