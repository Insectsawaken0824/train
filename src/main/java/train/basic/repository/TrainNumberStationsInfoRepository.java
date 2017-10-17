package train.basic.repository;

import train.basic.domain.FormalTrainNumberStationsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhao on 2017/10/17.
 */
public interface TrainNumberStationsInfoRepository extends JpaRepository<FormalTrainNumberStationsInfo,Integer> {

    List<FormalTrainNumberStationsInfo> findByStationsName(String name);
}
