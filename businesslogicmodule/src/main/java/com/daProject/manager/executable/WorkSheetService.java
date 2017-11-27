package com.daProject.manager.executable;

import com.daProject.dao.impl.WorkSheetDAOImpl;

import static com.daProject.dao.entity.Errors.workSheetStringGlobalState;

public class WorkSheetService {

    WorkSheetDAOImpl wsd = new WorkSheetDAOImpl();


    public synchronized void setGlobalState(String opTagId) {



    }

    public synchronized boolean getGlobalState(String opTagId) {
        workSheetStringGlobalState =  wsd.getIsChekedByOpTagId(opTagId);
        return workSheetStringGlobalState;
    }

}
