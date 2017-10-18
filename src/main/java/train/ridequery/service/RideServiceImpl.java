package train.ridequery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import train.basic.domain.FormalTrainNumberStationsInfo;
import train.basic.repository.TrainNumberStationsInfoRepository;
import train.ridequery.vo.NonStopVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2017/10/18.
 */
@Service
public class RideServiceImpl implements RideService{

    @Autowired
    TrainNumberStationsInfoRepository trainNumberStationsInfoRepository;

    @Override
    public List<NonStopVo> getNonStopInfo(String leaveStationName, String arriveStationName) {
        List<NonStopVo> list = new ArrayList();
        List<FormalTrainNumberStationsInfo> leaveStationInfos = trainNumberStationsInfoRepository.findByStationsName(leaveStationName);
        for (FormalTrainNumberStationsInfo leaveStationInfo : leaveStationInfos) {

        }
        return list;
    }
}
