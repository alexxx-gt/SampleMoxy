package com.testadapter;

public class NotifObject {
    private String settingsKey;
    private String channelType;
    private String settingValue;
    private int enabled;

    public NotifObject(String settingsKey, String channelType, String settingValue, int enabled) {
        this.settingsKey = settingsKey;
        this.channelType = channelType;
        this.settingValue = settingValue;
        this.enabled = enabled;
    }

    public String getSettingsKey() {
        return settingsKey;
    }

    public void setSettingsKey(String settingsKey) {
        this.settingsKey = settingsKey;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
