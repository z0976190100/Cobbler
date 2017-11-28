
// !!!!!!!!!! UNDER CONSTRUCTION !!!!!!!!!!!!

package com.daProject.manager.executable;

import com.daProject.dao.hibernateFactory.Factory;

import java.sql.SQLException;
import static com.daProject.dao.entity.WorkSheet.workSheetStringGlobalState;
import static com.daProject.dao.entity.WorkSheet.syncRequired;

public class WorkSheetService {


    public synchronized void setGlobalState(String opTagId, boolean state, long init) throws SQLException {

        Factory.getInstance().getWorkSheetDAO().updateIsChekedByOpTagId(opTagId, state, init);
        syncRequired = true;

    }

    public synchronized boolean getGlobalState(String opTagId) throws SQLException {
        workSheetStringGlobalState =
                Factory.getInstance().getWorkSheetDAO().getIsChekedByOpTagId(opTagId);
        return workSheetStringGlobalState;
    }

}
