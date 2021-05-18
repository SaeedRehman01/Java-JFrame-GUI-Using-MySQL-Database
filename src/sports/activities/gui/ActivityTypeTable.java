/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sports.activities.gui;

/**
 *
 * @author saeed
 */
public class ActivityTypeTable {

    private String activityType;
    private String activityStartDate;
    private String activityEndDate;

    // Getters class for the Sports Activity Type Table
    public ActivityTypeTable(String activityType, String activityStartDate, String activityEndDate) {
        this.activityType = activityType;
        this.activityStartDate = activityStartDate;
        this.activityEndDate = activityEndDate;

    }

    public ActivityTypeTable(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityType() {
        return activityType;
    }

    public String getActivityStartDate() {
        return activityStartDate;
    }

    public String getActivityEndDate() {
        return activityEndDate;
    }
  
}
