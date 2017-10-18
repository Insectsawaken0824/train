package train.ridequery.vo;

/**
 * Created by zhao on 2017/10/18.
 * 直达车vo
 */
public class NonStopVo {

    public NonStopVo() {
    }

    public NonStopVo(String leaveStationName, String arriveStationName, String trainNumber, String arriveTime, String leaveTime, long runtime, int distance, int other_day) {
        this.leaveStationName = leaveStationName;
        this.arriveStationName = arriveStationName;
        this.trainNumber = trainNumber;
        this.arriveTime = arriveTime;
        this.leaveTime = leaveTime;
        this.runtime = runtime;
        this.distance = distance;
        this.other_day = other_day;
    }
    //离开站名
    private String leaveStationName;
    //到达站名
    private String arriveStationName;
    //车次
    private String trainNumber;
    //到达时间
    private String arriveTime;
    //离开时间
    private String leaveTime;
    //行驶时间
    private long runtime;
    //距离
    private int distance;
    //0 当天 1 第二天 ..
    private int other_day;

    public String getLeaveStationName() {
        return leaveStationName;
    }

    public void setLeaveStationName(String leaveStationName) {
        this.leaveStationName = leaveStationName;
    }

    public String getArriveStationName() {
        return arriveStationName;
    }

    public void setArriveStationName(String arriveStationName) {
        this.arriveStationName = arriveStationName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getOther_day() {
        return other_day;
    }

    public void setOther_day(int other_day) {
        this.other_day = other_day;
    }
}
