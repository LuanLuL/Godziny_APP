package com.cefet.godziny.api.activity;

public class ActivityDTO {
    private String title;
    private Long activityDate;
    private Long createdAt;
    // Definir se é melhor salvar esse valor em minutos ou separado
    private Long workloadMinutes;
    private String status;
    private String category;

    // Mudar arquivo para link
    private String file;

    public ActivityDTO(String title, Long activityDate, Long createdAt, Long workloadMinutes, String status,
            String category, String file) {
        this.title = title;
        this.activityDate = activityDate;
        this.createdAt = createdAt;
        this.workloadMinutes = workloadMinutes;
        this.status = status;
        this.category = category;
        this.file = file;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Long activityDate) {
        this.activityDate = activityDate;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getWorkloadMinutes() {
        return workloadMinutes;
    }

    public void setWorkloadMinutes(Long workloadMinutes) {
        this.workloadMinutes = workloadMinutes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

}
