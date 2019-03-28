package com.uabc.database.example.examplejpa.components;

import com.uabc.database.example.examplejpa.entity.Log;
import com.uabc.database.example.examplejpa.model.LogModel;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.*;

@Component("logConverter")
public class LogConverter {
    public Log convertToLogModel2Log(LogModel logModel) throws Exception{

        Log log = new Log();
        log.setUrl(logModel.getUrl());

        //Date date = log.getDate();
        //SimpleDateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
        //String strDate = dateFormat.format(date);
        //System.out.println("Converted String: " + strDate);

        //Date date = log.getDate();
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        //String strDate = formatter.format(date);

        String[] dates = logModel.getDate().split("T");
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dates[0] + " " + dates[1]);


        log.setDate(date);

        //log.setDate(logModel.getDate());
        log.setDetails(logModel.getDetails());
        log.setUsername(logModel.getUsername());
        log.setId(logModel.getId());
        return log;
    }

    public LogModel convertLog2LogModel(Log log){
        LogModel logModel = new LogModel();
        logModel.setUrl(log.getUrl());
        logModel.setDate(log.getDate().toString());
        logModel.setDetails(log.getDetails());
        logModel.setUsername(log.getUsername());
        logModel.setId(log.getId());
        return logModel;
    }
}
