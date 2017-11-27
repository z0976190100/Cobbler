package com.daProject.dao.entity;

import java.util.Date;

public abstract class WorkSheetUnit {

    long id;
    long techRoutId;
    Date date;
    String timeOpen;
    String timeClosed;
    String modelArt;
    String taskId; // id of incoming document
    long operationId;
    Boolean isChecked;
    long checkerId; // id of user who checked current operation

}
