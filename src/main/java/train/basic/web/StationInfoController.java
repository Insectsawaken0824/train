package train.basic.web;

import train.basic.domain.FormalTrainNumberStationsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import train.basic.repository.TrainNumberStationsInfoRepository;

import java.util.List;

/**
 * Created by zhao on 2017/10/17.
 */
@RestController
public class StationInfoController {
    @Autowired
    TrainNumberStationsInfoRepository trainNumberStationsInfoRepository;

    @RequestMapping("/address")
    public List<FormalTrainNumberStationsInfo> address(String name) {
        return trainNumberStationsInfoRepository.findByStationsName(name);
    }
}
