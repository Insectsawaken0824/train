package train.ridequery.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import train.basic.domain.FormalTrainNumberStationsInfo;
import train.basic.repository.TrainNumberStationsInfoRepository;
import train.ridequery.service.RideService;
import train.ridequery.vo.NonStopVo;

import java.util.List;

/**
 * Created by zhao on 2017/10/17.
 */
@RestController
@RequestMapping("/ride")
public class RideController {
    @Autowired
    TrainNumberStationsInfoRepository trainNumberStationsInfoRepository;
    @Autowired
    RideService rideService;

    @RequestMapping("/nonstop")
    public List<NonStopVo> nonstop(String leaveStationName,String arriveStationName) {
        return rideService.getNonStopInfo(leaveStationName,arriveStationName);
    }
}
