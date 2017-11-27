package com.daProject.controller;

import com.daProject.manager.executable.WorkSheetService;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

import static com.daProject.dao.entity.WorkSheet.syncRequired;
import static com.daProject.dao.entity.WorkSheet.workSheetStringGlobalState;
import static com.daProject.controller.APIHandlerServlet.multiplayer;

public class WorkSheetHandler extends APIHandlerServlet.APIRequestHandler {

    public static final WorkSheetHandler instance = new WorkSheetHandler();

    public static WorkSheetHandler getInstance() {
        return instance;
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {


        JSONObject stateResp = new JSONObject();
        if (multiplayer) {
            WorkSheetService ws = new WorkSheetService();
            String purpose = request.getParameter("purpose");
            String target = request.getParameter("target");

            switch (purpose) {
                case "get":
                    if (syncRequired) {
                        ws.getGlobalState(target);
                        stateResp.put("syncRequired", syncRequired);
                        stateResp.put("target", target);
                        stateResp.put("globalState", workSheetStringGlobalState);
                        return stateResp;
                    }
                    stateResp.put("syncRequired", syncRequired);
                    return stateResp;
                case "set":
                    long init = Long.parseLong(request.getParameter("initiator"));
                    boolean localState = Boolean.parseBoolean(request.getParameter("localState"));
                    ws.setGlobalState(target, localState, init);
                    break;
            }
            return null;
        }
        stateResp.put("syncRequired", false);
        return stateResp;
    }
}
