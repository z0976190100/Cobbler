package com.daProject.controller;

import com.daProject.controller.APIHandlerServlet;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

public class WorkSheetHandler extends APIHandlerServlet.APIRequestHandler {

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {

         /*JSONObject mpresponse = new JSONObject();
        String temp = request.getParameter("mp");
        if (temp.equals("get")) {
            System.out.println("_______ doing get ________________");
            mpresponse.put("mp", workSheetStringGlobalState);
            System.out.println("sending____________" + mpresponse.get("mp"));

            return mpresponse;
        }
        //multiplaying checker
        workSheetStringGlobalState = Boolean.parseBoolean(request.getParameter("mp"));
        System.out.println("+++++++++++++++++++++" + workSheetStringGlobalState);
        System.out.println("________________________________________" + mpresponse.get("mp"));
*/

        return null;
    }
}
