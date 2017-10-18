package train.basic.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zhao on 2017/10/17.
 * 车站信息Do
 */
@Entity
public class FormalTrainNumberStationsInfo {
    @Id
    @GeneratedValue
    private int id;
    //车次
    private String trainNumber;
    //到站序列号
    private String sequenceNumber;
    //站名
    private String stationsName;
    //距离
    private int distance;
    //总距离
    private int totalDistance;
    //到达时间
    private String arriveTime;
    //离开时间
    private String leaveTime;
    //行驶时间
    private long runtime;
    //总行驶时间
    private long totalRuntime;
    //0 当天 1 第二天 ..
    private int other_day;
    //备用字段1
    private String bak1;
    //备用字段2
    private String bak2;
    //备用字段3
    private String bak3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getStationsName() {
        return stationsName;
    }

    public void setStationsName(String stationsName) {
        this.stationsName = stationsName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public long getRuntime() {
        return runtime;
    }

    public void setRuntime(long runtime) {
        this.runtime = runtime;
    }

    public long getTotalRuntime() {
        return totalRuntime;
    }

    public void setTotalRuntime(long totalRuntime) {
        this.totalRuntime = totalRuntime;
    }

    public int getOther_day() {
        return other_day;
    }

    public void setOther_day(int other_day) {
        this.other_day = other_day;
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1;
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }

    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }
}
