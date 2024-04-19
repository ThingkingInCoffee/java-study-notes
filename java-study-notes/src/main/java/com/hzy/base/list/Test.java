package com.hzy.base.list;

import java.math.BigDecimal;


public class Test {

    /*@Schema(
            description = "pid"
    )*/
    private Long pid;
    /*@Schema(
            description = "站点名称"
    )*/
    private String name;
    private String collectionid;
    /*@Schema(
            description = "站点scada编号"
    )*/
    private String vhid;
    /*@Schema(
            description = "站点类型"
    )*/
    private Integer station_type;
    /*@Schema(
            description = "站点类型名称"
    )*/
    private String station_type_name;
    /*@Schema(
            description = "收费方式"
    )*/
    private Integer charge_type;
    /*@Schema(
            description = "收费方式"
    )*/
    private String charge_type_name;
    /*@Schema(
            description = "站点Code"
    )*/
    private String stationCode;
    /*@Schema(
            description = "节能类型"
    )*/
    private Integer energy_type;
    /*@Schema(
            description = "节能类型名称"
    )*/
    private String energytype_name;
    /*@Schema(
            description = "站点是否可控，1可控 0不可控"
    )*/
    private Integer is_lock;
    /*@Schema(
            description = "供热面积"
    )*/
    private BigDecimal heating_area;
    /*@Schema(
            description = "排序"
    )*/
    private Integer memo;
    /*@Schema(
            description = "热网id"
    )*/
    private Integer network_id;
    /*@Schema(
            description = "热网名称"
    )*/
    private String network_name;
    /*@Schema(
            description = "公司id"
    )*/
    private Integer com_id;
    /*@Schema(
            description = "公司名称"
    )*/
    private String com_name;
    /*@Schema(
            description = "分区id"
    )*/
    private Integer part;
    /*@Schema(
            description = "分区名称"
    )*/
    private String part_name;
    /*@Schema(
            description = "调控设备是否启用"
    )*/
    private Boolean enabled_adjust_device;
    /*@Schema(
            description = "调控设备"
    )*/
    private Integer exist_adjust_device;
    /*@Schema(
            description = "调控模式"
    )*/
    private Integer control_mode;
    /*@Schema(
            description = "采暖方式"
    )*/
    private Integer heating_method;
    /*@Schema(
            description = "采暖方式名称"
    )*/
    private String heating_method_name;
    /*@Schema(
            description = "功能类型"
    )*/
    private Integer function_type;
    /*@Schema(
            description = "功能类型名称"
    )*/
    private String function_type_name;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollectionid() {
        return collectionid;
    }

    public void setCollectionid(String collectionid) {
        this.collectionid = collectionid;
    }

    public String getVhid() {
        return vhid;
    }

    public void setVhid(String vhid) {
        this.vhid = vhid;
    }

    public Integer getStation_type() {
        return station_type;
    }

    public void setStation_type(Integer station_type) {
        this.station_type = station_type;
    }

    public String getStation_type_name() {
        return station_type_name;
    }

    public void setStation_type_name(String station_type_name) {
        this.station_type_name = station_type_name;
    }

    public Integer getCharge_type() {
        return charge_type;
    }

    public void setCharge_type(Integer charge_type) {
        this.charge_type = charge_type;
    }

    public String getCharge_type_name() {
        return charge_type_name;
    }

    public void setCharge_type_name(String charge_type_name) {
        this.charge_type_name = charge_type_name;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public Integer getEnergy_type() {
        return energy_type;
    }

    public void setEnergy_type(Integer energy_type) {
        this.energy_type = energy_type;
    }

    public String getEnergytype_name() {
        return energytype_name;
    }

    public void setEnergytype_name(String energytype_name) {
        this.energytype_name = energytype_name;
    }

    public Integer getIs_lock() {
        return is_lock;
    }

    public void setIs_lock(Integer is_lock) {
        this.is_lock = is_lock;
    }

    public BigDecimal getHeating_area() {
        return heating_area;
    }

    public void setHeating_area(BigDecimal heating_area) {
        this.heating_area = heating_area;
    }

    public Integer getMemo() {
        return memo;
    }

    public void setMemo(Integer memo) {
        this.memo = memo;
    }

    public Integer getNetwork_id() {
        return network_id;
    }

    public void setNetwork_id(Integer network_id) {
        this.network_id = network_id;
    }

    public String getNetwork_name() {
        return network_name;
    }

    public void setNetwork_name(String network_name) {
        this.network_name = network_name;
    }

    public Integer getCom_id() {
        return com_id;
    }

    public void setCom_id(Integer com_id) {
        this.com_id = com_id;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public Integer getPart() {
        return part;
    }

    public void setPart(Integer part) {
        this.part = part;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public Boolean getEnabled_adjust_device() {
        return enabled_adjust_device;
    }

    public void setEnabled_adjust_device(Boolean enabled_adjust_device) {
        this.enabled_adjust_device = enabled_adjust_device;
    }

    public Integer getExist_adjust_device() {
        return exist_adjust_device;
    }

    public void setExist_adjust_device(Integer exist_adjust_device) {
        this.exist_adjust_device = exist_adjust_device;
    }

    public Integer getControl_mode() {
        return control_mode;
    }

    public void setControl_mode(Integer control_mode) {
        this.control_mode = control_mode;
    }

    public Integer getHeating_method() {
        return heating_method;
    }

    public void setHeating_method(Integer heating_method) {
        this.heating_method = heating_method;
    }

    public String getHeating_method_name() {
        return heating_method_name;
    }

    public void setHeating_method_name(String heating_method_name) {
        this.heating_method_name = heating_method_name;
    }

    public Integer getFunction_type() {
        return function_type;
    }

    public void setFunction_type(Integer function_type) {
        this.function_type = function_type;
    }

    public String getFunction_type_name() {
        return function_type_name;
    }

    public void setFunction_type_name(String function_type_name) {
        this.function_type_name = function_type_name;
    }
}
