package com.uabc.database.example.examplejpa.services;



import com.uabc.database.example.examplejpa.entity.Log;
import com.uabc.database.example.examplejpa.model.LogModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("logService")
public interface LogService{
    public abstract LogModel addContact(LogModel logModel) throws Exception;

    public abstract List<LogModel> listAllContacts();

    public abstract Log findContactById(int id);

    public abstract void removeContact(int id);

    public abstract LogModel findContactByIdModel(int id);

}
