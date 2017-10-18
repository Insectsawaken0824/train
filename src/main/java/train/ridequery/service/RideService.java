package train.ridequery.service;

import org.springframework.stereotype.Service;
import train.ridequery.vo.NonStopVo;

import java.util.List;

/**
 * Created by zhao on 2017/10/18.
 */

public interface RideService {
    /**
     * 得到直达车辆信息
     * @param leaveStationName
     * @param arriveStationName
     * @return 直达信息的VO
     */
    List<NonStopVo> getNonStopInfo(String leaveStationName,String arriveStationName);
}
